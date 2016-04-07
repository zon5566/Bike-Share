import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

public  class UserInformURL{
	
	StringBuffer res = null;
	public UserInformURL(String uid)throws Exception{
		String url = "http://hyldeb.ddns.net/~hyl/youbike/query_user.php";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	
		conn.setRequestMethod("POST");
	
		String Parameter = "id="+uid;
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
	
	public String showMsg(String response){
		JSONObject json_obj = new JSONObject(response);
		String msg = null;
		try{
			msg = json_obj.getJSONObject("error").getString("msg");
			JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.INFORMATION_MESSAGE);
			msg = "0_" + msg;
		} catch(JSONException e1){
			String balance = Integer.toString(json_obj.getInt("balance"));
			String is_renting = json_obj.getInt("is_renting")==1? "¯²­É¤¤" : "«D¯²­É¤¤";
			
			String last_renting_datetime = null;
			try{
				last_renting_datetime = json_obj.getString("last_renting_datetime");
			} catch(JSONException e2){
				last_renting_datetime = "-";
			}
			msg = "1_" + balance + "_" + is_renting + "_" + last_renting_datetime;
		}
		return msg;
	}
	
}