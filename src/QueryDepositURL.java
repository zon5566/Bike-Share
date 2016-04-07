import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.json.JSONArray;
import org.json.JSONObject;

public  class QueryDepositURL{
	
	StringBuffer res = null;
	public QueryDepositURL(String uid, String from, String to)throws Exception{
		String url = "http://hyldeb.ddns.net/~hyl/youbike/query_deposits.php";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	
		conn.setRequestMethod("POST");
	
		String Parameter = "id="+uid+"&from="+from+"&to="+to;
		conn.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(Parameter);
		wr.flush();
		wr.close();
		
		//int response = conn.getResponseCode();
		/*  200: OK
		 *  400: Unauthorized
		 *  -1: not valid HTTP
		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		res = new StringBuffer();
		
		while((inputLine = in.readLine())!=null){
			res.append(inputLine);
		}
		in.close();
	}
	public String getResponse(){
		return res.toString();
	};
	
	public JTextArea showMsg(String response){
		JTextArea msg = null;
		JSONObject json_obj = null;
		try{
			json_obj = new JSONObject(response);
			String error_msg = json_obj.getJSONObject("error").getString("msg");
			JOptionPane.showMessageDialog(null, error_msg,"Error",JOptionPane.INFORMATION_MESSAGE);
			msg = null;
		} catch(Exception e){
			JSONArray json_arr = new JSONArray(response);
			int date_count = json_arr.length();
			JSONArray operation[] = new JSONArray[date_count];
			String date[] = new String[date_count];
			
			int each_operation_size[] = new int[date_count];
			try{
				for(int i = 0 ; i < date_count ; i++){
					operation[i] = json_arr.getJSONObject(i).getJSONArray("deposits");
					date[i] = json_arr.getJSONObject(i).getString("date");
					each_operation_size[i] = operation[i].length();
				}
			
				msg = new JTextArea();
				msg.append("=======================================\n"); //40
				for(int i = 0 ; i<date_count ; i++){
					msg.append(date[i]+"\n");
					msg.append("=======================================\n"); //40
					for(int j = 0 ; j<each_operation_size[i] ; j++){
						msg.append("  Time       ¡G"+operation[i].getJSONObject(j).getString("time")+"\n");
						int deposit = operation[i].getJSONObject(j).getInt("deposit");
						msg.append("  Deposit   ¡G"+deposit+"\n");		
						if(j!=each_operation_size[i]-1)
							msg.append("------------------------------\n"); // 30
					}
					msg.append("=======================================\n"); //40
				}
			} catch(Exception e2){
				System.out.println("e2:"+e2);
			}
		}
		return msg;
	}
	
}