import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public  class DepositURL{
	
	StringBuffer res = null;
	public DepositURL(String uid, String deposit)throws Exception{
		String url = "http://hyldeb.ddns.net/~hyl/youbike/deposit.php";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	
		conn.setRequestMethod("POST");
	
		String Parameter = "id="+uid+"&deposit="+deposit;
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
	
	void showMsg(String response){
		JSONObject json_obj = new JSONObject(response);
		String msg = null;
		try{
			msg = json_obj.getJSONObject("error").getString("msg");
			JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.INFORMATION_MESSAGE);
		} catch(JSONException e1){
			msg = "Successfully deposited!\n¥[­È«áª÷ÃB¡G"+Integer.toString(json_obj.getInt("balance"));
			JOptionPane.showMessageDialog(null, msg,"Success",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}