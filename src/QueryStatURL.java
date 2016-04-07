import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.json.JSONArray;
import org.json.JSONObject;

public  class QueryStatURL{
	int select;
	StringBuffer res = null;
	public QueryStatURL(String limit, int select)throws Exception{
		this.select = select;
		String url;
		if(this.select==0) { //space_num
			url = "http://hyldeb.ddns.net/~hyl/youbike/query_stations_by_space_num.php";
		} //bike_num
		else url = "http://hyldeb.ddns.net/~hyl/youbike/query_stations_by_bike_num.php";
		 
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("POST");
	
		String Parameter = "limit="+limit;
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
	
	public void showMsg(JTextArea msg, String response){
			JSONObject json_obj = null;
		try{
			json_obj = new JSONObject(response);
			String error_msg = json_obj.getJSONObject("error").getString("msg");
			JOptionPane.showMessageDialog(null, error_msg,"Error",JOptionPane.INFORMATION_MESSAGE);
			msg = null;
		} catch(Exception e){
			JSONArray json_arr = new JSONArray(response);
			int date_count = json_arr.length();
			
			try{
				for(int i = 0 ; i<date_count ; i++){
					msg.append("ID:"+json_arr.getJSONObject(i).getInt("id")+"\n");
					msg.append("站名:"+json_arr.getJSONObject(i).getString("name")+"\n");
					if(select == 0)
						msg.append("空位數:"+json_arr.getJSONObject(i).getInt("space_num")+"\n");
					else msg.append("車輛數:"+json_arr.getJSONObject(i).getInt("bike_num")+"\n");
					if(i!=date_count)
					msg.append("------------------------------------\n");
				}
			} catch(Exception e2){
				System.out.println("e2:"+e2);
			}
		}
	}
	
}