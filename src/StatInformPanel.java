import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatInformPanel extends JPanel implements ActionListener{
	JButton submit, cancel;
	JTextField id_tf, advanced_tf;
	JLabel id_l, cb_l;
	JLabel name_l, address_l, space_num_l, bike_num_l;
	JCheckBox cb;
	JTextArea ta;
	public StatInformPanel(){
		setLayout(new BorderLayout());
		
		id_l = new JLabel("車站 ID");
        cb_l = new JLabel("站");
        id_tf = new JTextField(5);
        advanced_tf = new JTextField(5);
        advanced_tf.setEnabled(false);
        cb = new JCheckBox("查詢鄰近站點");
        cb.setBackground(Color.WHITE);
        cb.addActionListener(this);
        submit = new JButton("確認");
        cancel = new JButton("返回");
        
        JPanel input_p = new JPanel();
		input_p.setSize(500,100);
		input_p.setBackground(Color.WHITE);
		input_p.setLayout(new  GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.WEST;
		
		setLocation(id_l, input_p, c, 0,0,1,1);
		setLocation(id_tf, input_p, c, 1,0,4,1);
		setLocation(cb, input_p, c, 0,1,1,1);
		setLocation(advanced_tf, input_p, c, 1,1,4,1);	
		setLocation(cb_l, input_p, c, 5,1,1,1);
		setLocation(submit, input_p, c, 6,1,1,1);
		setLocation(cancel, input_p, c, 7,1,1,1);
		
		JPanel output_p = new JPanel(new BorderLayout());
		ta = new JTextArea();
		ta.setEditable(false);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(cb.isSelected()){
			advanced_tf.setEnabled(true);
		}
		else{
			advanced_tf.setEnabled(false);	
		}
	}
}
// 6c3db510-fd28-11e4-b939-0800200c9a66