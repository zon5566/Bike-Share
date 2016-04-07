import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Frame extends JFrame{
	
	Container cp;
	SelectPanel s_p;
	RentPanel r_p;
	ReturnPanel rt_p;
	UserInformPanel ui_p;
	StatInformPanel si_p;
	DepositPanel d_p;
	QueryUserPanel qu_p;
	QueryUserResult qu_r;
	QueryDepositPanel qd_p;
	QueryDepositResult qd_r;
	CardLayout card; JPanel mainp, image_p;
	QueryStatPanel qs_p;
	NearStatPanel ns_p;
	public Frame(){
		s_p = new SelectPanel();
		r_p = new RentPanel();
		rt_p = new ReturnPanel();
		ui_p = new UserInformPanel();
		si_p = new StatInformPanel();
		d_p = new DepositPanel();
		qu_p = new QueryUserPanel();
		qu_r = new QueryUserResult();
		qd_p = new QueryDepositPanel();
		qd_r = new QueryDepositResult();
		qs_p = new QueryStatPanel();
		ns_p = new NearStatPanel();
		
		card = new CardLayout();
		mainp = new JPanel();
		mainp.setLayout(card);
	
		setTitle("UBike System");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(mainp, BorderLayout.CENTER);
		addImage_P();
		mainp.add(r_p,"r");
		mainp.add(s_p,"s");
		mainp.add(rt_p,"rt");
		mainp.add(ui_p,"ui");
		mainp.add(si_p,"si");
		mainp.add(d_p,"dp");
		mainp.add(qu_p,"qu");
		mainp.add(qu_r,"qur");
		mainp.add(qd_p,"qd");
		mainp.add(qd_r,"qdr");
		mainp.add(qs_p,"qs");
		mainp.add(ns_p,"ns");
		
		card.show(mainp,"s");
		
		Listener L = new Listener();
		s_p.b1.addActionListener(L);
		s_p.b2.addActionListener(L);
		s_p.b3.addActionListener(L);
		s_p.b4.addActionListener(L);
		s_p.b7.addActionListener(L);
		s_p.b5.addActionListener(L);
		s_p.b8.addActionListener(L);
		s_p.b6.addActionListener(L);
		s_p.b9.addActionListener(L);
        r_p.submit.addActionListener(L);
        r_p.cancel.addActionListener(L);
        rt_p.submit.addActionListener(L);
        rt_p.cancel.addActionListener(L);
        ui_p.submit.addActionListener(L);
        ui_p.cancel.addActionListener(L);
        si_p.submit.addActionListener(L);
        si_p.cancel.addActionListener(L);
        d_p.submit.addActionListener(L);
        d_p.cancel.addActionListener(L);
        qu_p.submit.addActionListener(L);
        qu_p.cancel.addActionListener(L);
        qu_r.OK.addActionListener(L);
        qd_p.submit.addActionListener(L);
        qd_p.cancel.addActionListener(L);
        qd_r.OK.addActionListener(L);
        qs_p.submit.addActionListener(L);
        qs_p.cancel.addActionListener(L);
        ns_p.submit.addActionListener(L);
        ns_p.cancel.addActionListener(L);
	}
	
	void addImage_P(){
		image_p = new JPanel();
		image_p.setPreferredSize(new Dimension(200,200));
		 
		ImageIcon image = new ImageIcon(getClass().getResource("/ubike.jpg"));
		JLabel label = new JLabel();
		label.setIcon(image);
		image_p.add(label);
		cp.add(image_p, BorderLayout.NORTH);
	}	
	
	public class Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==s_p.b1){
				card.show(mainp,"r");	
			}
			else if(e.getSource()==s_p.b2){
				card.show(mainp,"rt");		
			}
			else if(e.getSource()==s_p.b4){
				card.show(mainp,"ui");
			}
			else if(e.getSource()==s_p.b3){
				card.show(mainp,"si");
			}
			else if(e.getSource()==s_p.b7){
				card.show(mainp,"dp");
			}
			else if(e.getSource()==s_p.b5){
				card.show(mainp,"qu");	
			}
			else if(e.getSource()==s_p.b8){
				card.show(mainp,"qd");
			}
			else if(e.getSource()==s_p.b6){
				card.show(mainp,"qs");
			}
			else if(e.getSource()==s_p.b9){
				card.show(mainp,"ns");
			}
			else if(e.getSource()==r_p.cancel){	
				card.show(mainp,"s");
				r_p.id_tf.setText("");
				r_p.stat_tf.setText("");
			}
			else if(e.getSource()==r_p.submit){
				String uid = r_p.id_tf.getText();
				String sid = r_p.stat_tf.getText();
				try {
					RentURL r_url = new RentURL(uid, sid);
					r_url.showMsg(r_url.getResponse());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				r_p.id_tf.setText("");
				r_p.stat_tf.setText("");
			}
					
			else if(e.getSource()==rt_p.cancel){	
				card.show(mainp,"s");
				rt_p.id_tf.setText("");
				rt_p.stat_tf.setText("");
			}
			else if(e.getSource()==rt_p.submit){
				String uid = rt_p.id_tf.getText();
				String sid = rt_p.stat_tf.getText();
				try {
					ReturnURL rt_url = new ReturnURL(uid, sid);
					rt_url.showMsg(rt_url.getResponse());

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				rt_p.id_tf.setText("");
				rt_p.stat_tf.setText("");
			}
			
			else if(e.getSource()==ui_p.cancel){
				card.show(mainp,"s");
				ui_p.id_tf.setText("");
				ui_p.balance_l.setText("  Balance : ");
				ui_p.is_renting_l.setText("  Status : ");
				ui_p.datetime_l.setText("  Last renting time : ");
			}		
			else if(e.getSource()==ui_p.submit){
				String uid = ui_p.id_tf.getText();
				String show_msg = null;
				try {
					UserInformURL qu_url = new UserInformURL(uid);
					show_msg = qu_url.showMsg(qu_url.getResponse());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//TODO
				String[]arr = show_msg.split("_");
				if(arr[0].equals("0")){
					ui_p.id_tf.setText("");
					ui_p.balance_l.setText("  餘額              : ");
					ui_p.is_renting_l.setText("  使用狀態        : ");
					ui_p.datetime_l.setText("  上次租車時間 : ");
				}
				else if(arr[0].equals("1")){
					ui_p.balance_l.setText("  餘額              : "+arr[1]);
					ui_p.is_renting_l.setText("  使用狀態        : "+arr[2]);
					ui_p.datetime_l.setText("  上次租車時間 : "+arr[3]);
					
				}
				
			}
			
			else if(e.getSource()==si_p.cancel){
				card.show(mainp,"s");
				si_p.ta.setText("");
				si_p.id_tf.setText("");
				si_p.advanced_tf.setText("");
				si_p.cb.setSelected(false);
				si_p.advanced_tf.setEnabled(false);
			}
			else if(e.getSource()==si_p.submit){
				si_p.ta.setText("");
				String sid;
				String advanced;
				StatInformURL url = null;
				try{
					sid = si_p.id_tf.getText();
					advanced = si_p.advanced_tf.getText();
					if(!si_p.cb.isSelected()){
						url = new StatInformURL(sid,0,null);
						url.showMsg(si_p.ta, url.getResponse());
					}
					else if(si_p.cb.isSelected()){
						url = new StatInformURL(sid,1,advanced);
						url.showMsg(si_p.ta, url.getResponse());
					}
					si_p.ta.setCaretPosition(0);
				} catch(Exception e2){
					System.out.println(e2);
				}
			}
		
			else if(e.getSource()==d_p.cancel){
				card.show(mainp,"s");
				d_p.id_tf.setText("");
				d_p.deposit_tf.setText("");
			}
			else if(e.getSource()==d_p.submit){
				String uid = d_p.id_tf.getText();
				String deposit = d_p.deposit_tf.getText();
				try {
					if(deposit.equals(""))
						throw new Exception();
					DepositURL d_url = new DepositURL(uid, deposit);
					d_url.showMsg(d_url.getResponse());
				} catch (Exception e2) {
				}
				d_p.id_tf.setText("");
				d_p.deposit_tf.setText("");
			}
			
			else if(e.getSource()==qu_p.cancel){
				card.show(mainp,"s");
				qu_p.id_tf.setText("");
				for(int i = 0 ; i<6 ; i++){
					qu_p.mcb.from[i].setSelectedIndex(-1);
					qu_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qu_p.mcb.from[i].setEnabled(false);
						qu_p.mcb.to[i].setEnabled(false);
					}
				}
				qd_p.id_tf.setText("");
			}
			else if(e.getSource()==qu_p.submit){
				String uid;
				String from[] = new String[6];
				String to[] = new String[6];
				
				try{
					uid = qu_p.id_tf.getText();
					
					for(int i = 0 ; i<6 ; i++){
						from[i] = String.valueOf(qu_p.mcb.from[i].getSelectedItem());
						to[i] = String.valueOf(qu_p.mcb.to[i].getSelectedItem());
					}
					String from_time="", to_time="";
					for(int i = 0 ; i<2 ; i++){
						from_time += from[i]+"-";
						to_time += to[i]+"-";
					}
					from_time+=from[2]+" "; to_time+=to[2]+" ";
					for(int i= 3 ; i<5 ; i++){
						from_time += from[i]+":";
						to_time += to[i]+":";
					}
					from_time+=from[5]; to_time+=to[5];			
					JTextArea msg;		
					QueryUserURL qu_url = null;
					try {
						qu_url = new QueryUserURL(uid, from_time, to_time);
					} catch(Exception e2){
						e2.printStackTrace();
					};
					msg = qu_url.showMsg(qu_url.getResponse());
					qu_r.makeScrollPane(msg);
					card.show(mainp,"qur");
					msg.setCaretPosition(0);
				} catch(Exception e2){
					card.show(mainp,"s");		
				}
				for(int i = 0 ; i<6 ; i++){
					qu_p.mcb.from[i].setSelectedIndex(-1);
					qu_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qu_p.mcb.from[i].setEnabled(false);
						qu_p.mcb.to[i].setEnabled(false);
					}
				}
			}
			else if(e.getSource()==qu_r.OK){
				card.show(mainp,"s");
				qu_r.remove(qu_r.scroll_p);
				
				for(int i = 0 ; i<6 ; i++){
					qu_p.mcb.from[i].setSelectedIndex(-1);
					qu_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qu_p.mcb.from[i].setEnabled(false);
						qu_p.mcb.to[i].setEnabled(false);
					}
				}
				qu_p.id_tf.setText("");
				repaint();
			}
			
			else if(e.getSource()==qd_p.cancel){
				card.show(mainp,"s");
				qd_p.id_tf.setText("");
				for(int i = 0 ; i<6 ; i++){
					qd_p.mcb.from[i].setSelectedIndex(-1);
					qd_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qd_p.mcb.from[i].setEnabled(false);
						qd_p.mcb.to[i].setEnabled(false);
					}
				}
				qd_p.id_tf.setText("");
			}
			else if(e.getSource()==qd_p.submit){
				String uid;
				String from[] = new String[6];
				String to[] = new String[6];
				
				try{
					uid = qd_p.id_tf.getText();
					
					for(int i = 0 ; i<6 ; i++){
						from[i] = String.valueOf(qd_p.mcb.from[i].getSelectedItem());
						to[i] = String.valueOf(qd_p.mcb.to[i].getSelectedItem());
					}
					String from_time="", to_time="";
					for(int i = 0 ; i<2 ; i++){
						from_time += from[i]+"-";
						to_time += to[i]+"-";
					}
					from_time+=from[2]+" "; to_time+=to[2]+" ";
					for(int i= 3 ; i<5 ; i++){
						from_time += from[i]+":";
						to_time += to[i]+":";
					}
					from_time+=from[5]; to_time+=to[5];			
					JTextArea msg;		
					QueryDepositURL qd_url = null;
					try {
						qd_url = new QueryDepositURL(uid, from_time, to_time);
					} catch(Exception e2){
						e2.printStackTrace();
					};
					msg = qd_url.showMsg(qd_url.getResponse());
					qd_r.makeScrollPane(msg);
					msg.setCaretPosition(0);
					card.show(mainp,"qdr");
				} catch(Exception e2){
					card.show(mainp,"s");		
				}
				for(int i = 0 ; i<6 ; i++){
					qd_p.mcb.from[i].setSelectedIndex(-1);
					qd_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qd_p.mcb.from[i].setEnabled(false);
						qd_p.mcb.to[i].setEnabled(false);
					}
				}
				qd_p.id_tf.setText("");
			}
			else if(e.getSource()==qd_r.OK){
				card.show(mainp,"s");
				qd_r.remove(qd_r.scroll_p);
				
				for(int i = 0 ; i<6 ; i++){
					qd_p.mcb.from[i].setSelectedIndex(-1);
					qd_p.mcb.to[i].setSelectedIndex(-1);
					if(i==1 || i==2){
						qd_p.mcb.from[i].setEnabled(false);
						qd_p.mcb.to[i].setEnabled(false);
					}
				}
				qd_p.id_tf.setText("");
				repaint();
			}
			
			else if(e.getSource()==qs_p.cancel){
				card.show(mainp,"s");
				qs_p.limit_tf.setText("");
				qs_p.ta.setText("");
				qs_p.bg.clearSelection();
			}
			else if(e.getSource()==qs_p.submit){	
				qs_p.ta.setText("");
				String limit;
				QueryStatURL url = null;
				try{
					limit = qs_p.limit_tf.getText();
					if(qs_p.space_num_r.isSelected()){
						url = new QueryStatURL(limit,0);
						url.showMsg(qs_p.ta, url.getResponse());
					}
					else if(qs_p.bike_num_r.isSelected()){
						url = new QueryStatURL(limit,1);
						url.showMsg(qs_p.ta, url.getResponse());
					}
					qs_p.ta.setCaretPosition(0);
				} catch(Exception e2){
					System.out.println(e2);
					card.show(mainp,"s");		
				}
			}
			
			else if(e.getSource()==ns_p.cancel){
				card.show(mainp,"s");
				ns_p.longitude_tf.setText("");
				ns_p.latitude_tf.setText("");
				ns_p.dist_tf.setText("");
				ns_p.ta.setText("");
				ns_p.bg.clearSelection();
			}
			else if(e.getSource()==ns_p.submit){	
				ns_p.ta.setText("");
				String lonitude, latitude, dist;
				NearStatURL url = null;
				try{
					lonitude = ns_p.longitude_tf.getText();
					latitude = ns_p.latitude_tf.getText();
					dist = ns_p.dist_tf.getText();
					if(lonitude.equals("")||latitude.equals("")||dist.equals(""))
						throw new Exception();
					
					if(ns_p.dist_space.isSelected())
						url = new NearStatURL(lonitude, latitude, dist, "dist_space");
					else if(ns_p.dist_bike.isSelected())
						url = new NearStatURL(lonitude, latitude, dist, "dist_bike");
					else if(ns_p.space_dist.isSelected())
						url = new NearStatURL(lonitude, latitude, dist, "space_dist");
					else if(ns_p.bike_dist.isSelected())
						url = new NearStatURL(lonitude, latitude, dist, "bike_dist");
					else{
						throw new Exception();
					}
					url.showMsg(ns_p.ta, url.getResponse());
					ns_p.ta.setCaretPosition(0);
				} catch (Exception e2) {
				}
			}
			
		}	
	}
}
//6c3d8dd0-fd28-11e4-b939-0800200c9a66