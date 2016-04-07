import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.json.*;

public  class StatInformURL{
	int select;
	StringBuffer res = null;
	public StatInformURL(String uid, int select, String near)throws Exception{
		String url, Parameter;
		this.select = select;
		if(select == 0){
			url = "http://hyldeb.ddns.net/~hyl/youbike/query_station.php";
			Parameter = "id="+uid;
		}
		else { 
			url = "http://hyldeb.ddns.net/~hyl/youbike/query_station_advanced.php";
			Parameter = "id="+uid+"&nearest_stations_num="+near;
		}
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	
		conn.setRequestMethod("POST");
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
		} catch(Exception e){
			json_obj = new JSONObject(response);
			msg.append(":"+json_obj.getString("name")+"\n");
			msg.append(":"+json_obj.getString("address")+"\n");
			msg.append("计:"+json_obj.getInt("space_num")+"\n");
			msg.append("ó进计:"+json_obj.getInt("bike_num")+"\n");
			if(select==1){
				msg.append("\n====================================================================\n"); //40
				msg.append("綟ó\n"); //40
				msg.append("====================================================================\n"); //40
				JSONArray near = json_obj.getJSONArray("nearest_stations");
				for(int i = 0 ; i<near.length(); i++){
					msg.append("ID:"+near.getJSONObject(i).getInt("id")+"\n");
					msg.append(":"+near.getJSONObject(i).getString("name")+"\n");
					msg.append("禯瞒:"+near.getJSONObject(i).getDouble("distance")+"\n");
					msg.append("计:"+near.getJSONObject(i).getInt("space_num")+"\n");
					msg.append("ó进计:"+near.getJSONObject(i).getInt("bike_num")+"\n");
					msg.append("---\n");
				}
			}
		}
	}
	
}