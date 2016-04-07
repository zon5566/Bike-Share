import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class QueryStatPanel extends JPanel{
	JButton submit;
	JButton cancel;
	JTextField limit_tf;
	JLabel tf_l, r_l;
	JRadioButton bike_num_r, space_num_r;
	JTextArea ta;
	ButtonGroup bg;
	public QueryStatPanel(){
		setLayout(new BorderLayout());
		
		JPanel input_p = new JPanel();
		input_p.setSize(500,100);
		input_p.setBackground(Color.WHITE);
		input_p.setLayout(new  GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.WEST;
		
		limit_tf = new JTextField(10);
		bike_num_r = new  JRadioButton("車輛數");
		bike_num_r.setBackground(Color.WHITE);
		space_num_r = new  JRadioButton("空位數");
		space_num_r.setBackground(Color.WHITE);
		bg = new ButtonGroup();
		bg.add(bike_num_r); bg.add(space_num_r);
		tf_l = new JLabel("上限");
		r_l = new JLabel("排序");
		submit = new JButton("確認");
		cancel = new JButton("返回");
		
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 1; c.gridheight = 1;
		input_p.add(tf_l,c);
		c.gridx = 1; c.gridwidth = 4;
		input_p.add(limit_tf,c);
		c.gridwidth = 1;	
		c.gridy = 2 ; c.gridx = 0;
		input_p.add(r_l,c);
		c.gridx = 1;
		input_p.add(bike_num_r,c);
		c.gridx = 2;
		input_p.add(space_num_r,c);
		c.gridx = 3;
		input_p.add(submit,c);
		c.gridx = 4;
		input_p.add(cancel,c);
		
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
}
