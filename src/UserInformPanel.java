import javax.swing.*;
import java.awt.*;

public class UserInformPanel extends JPanel{
	JButton submit, cancel = null;
	JTextField id_tf = null;
	JLabel id_l = null;
	JLabel balance_l, is_renting_l, datetime_l;
	public UserInformPanel(){
		setLayout(new BorderLayout());
		Font f = new Font("", Font.PLAIN, 20);
		
		id_l = new JLabel("�ϥΪ� ID");
        id_l.setFont(f);
        id_tf = new JTextField(15);
        submit = new JButton("�T�{");
        cancel = new JButton("��^");
        
        
		JPanel input_p = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
		input_p.setPreferredSize(new Dimension(500,50));
		input_p.setBackground(Color.WHITE);
		input_p.setPreferredSize(new Dimension(150,100));
		input_p.add(id_l);
		input_p.add(id_tf);
		input_p.add(submit);
		input_p.add(cancel);
		
		JPanel output_p = new JPanel();
		output_p.setLayout(new BoxLayout(output_p, BoxLayout.Y_AXIS));
		output_p.setBackground(Color.WHITE);
		   balance_l = new JLabel("  �l�B              : ");
		is_renting_l = new JLabel("  �ϥΪ��A        : ");
	  	  datetime_l = new JLabel("  �W�������ɶ� : "); 
		balance_l.setFont(f);
		is_renting_l.setFont(f);
		datetime_l.setFont(f);
		
		output_p.add(balance_l);
		output_p.add(is_renting_l);
		output_p.add(datetime_l);
		
		add(input_p,BorderLayout.NORTH);
		add(output_p,BorderLayout.CENTER);
	}
}
// 6c3db510-fd28-11e4-b939-0800200c9a66