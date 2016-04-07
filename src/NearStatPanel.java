import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class NearStatPanel extends JPanel{
	JButton submit;
	JButton cancel;
	JTextField longitude_tf, latitude_tf, dist_tf;
	JLabel lo_l, la_l, dist_l;
	JRadioButton dist_space, dist_bike, space_dist, bike_dist;
	JTextArea ta;
	ButtonGroup bg;
	public NearStatPanel(){
		setLayout(new BorderLayout());
		
		JPanel input_p = new JPanel();
		input_p.setSize(500,100);
		input_p.setBackground(Color.WHITE);
		input_p.setLayout(new  GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.WEST;
		
		longitude_tf = new JTextField(7);
		latitude_tf = new JTextField(7);
		dist_tf = new JTextField(7);
		dist_space = new  JRadioButton("依距離(空位多優先)");
		dist_space.setBackground(Color.WHITE);
		dist_bike = new  JRadioButton("依距離(車輛多優先)");
		dist_bike.setBackground(Color.WHITE);
		space_dist = new  JRadioButton("依空位數(距離近優先)");
		space_dist.setBackground(Color.WHITE);
		bike_dist = new  JRadioButton("依車輛數(距離近優先)");
		bike_dist.setBackground(Color.WHITE);
		
		bg = new ButtonGroup();
		bg.add(dist_space); bg.add(dist_bike); bg.add(space_dist); bg.add(bike_dist);
		lo_l = new JLabel("經度");
		la_l = new JLabel("緯度");
		dist_l = new JLabel("距離");
		submit = new JButton("確認");
		cancel = new JButton("返回");
		
		setLocation(dist_space, input_p,c, 0,0,4,1);
		setLocation(dist_bike, input_p,c, 5,0,4,1);
		setLocation(space_dist, input_p,c, 0,1,4,1);
		setLocation(bike_dist, input_p,c,5,1,4,1);
		
		setLocation(lo_l, input_p, c, 0,2,1,1);
		setLocation(longitude_tf, input_p, c, 1,2,2,1);
		setLocation(la_l, input_p,c, 3,2,1,1);
		setLocation(latitude_tf, input_p,c, 4,2,2,1);
		setLocation(dist_l, input_p, c, 0,3,1,1);
		setLocation(dist_tf, input_p, c, 1,3,2,1);
		
		setLocation(submit, input_p,c, 5,3,1,1);
		setLocation(cancel, input_p,c, 6,3,1,1);
		
		
		JPanel output_p = new JPanel(new BorderLayout());
		Font f = new Font("", Font.PLAIN, 20);
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setFont(f);
		JScrollPane scroll_p = new JScrollPane(ta);
		JScrollBar verticalScrollBar = scroll_p.getVerticalScrollBar();
	    JScrollBar horizontalScrollBar = scroll_p.getHorizontalScrollBar();
	    verticalScrollBar.setValue(verticalScrollBar.getMinimum());
	    horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
		output_p.add(scroll_p,BorderLayout.CENTER);
		add(input_p, BorderLayout.NORTH);
		add(output_p, BorderLayout.CENTER);
	}
	void setLocation(Component obj, JPanel p, GridBagConstraints c, int gridx, int gridy, int width, int height){
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = width;
		c.gridheight = height;
		p.add(obj,c);
	}
}
