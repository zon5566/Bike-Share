import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

public  class ReturnURL{
	
	StringBuffer res = null;
	public ReturnURL(String uid, String sid)throws Exception{
		String url = "http://hyldeb.ddns.net/~hyl/youbike/return.php";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	
		conn.setRequestMethod("POST");
	
		String Parameter = "user_id="+uid+"&station_id="+sid;
		conn.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(Parameter);
		wr.flush();
		wr.close();
		
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
	}
	
	void showMsg(String response){
		JSONObject json_obj = new JSONObject(response);
		String msg = null;
		try{
			msg = "Successfully returned!\n¦©´Úª÷ÃB¡G"+json_obj.getInt("charge") + "\n¥d¤ù¾lÃB¡G"+json_obj.getInt("balance");
			JOptionPane.showMessageDialog(null, msg,"Success",JOptionPane.INFORMATION_MESSAGE);
		} catch(JSONException e1){
			msg = json_obj.getJSONObject("error").getString("msg");
			JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}