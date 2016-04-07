import javax.swing.*;
import java.awt.*;

public class RentPanel extends JPanel{
	JButton submit, cancel = null;
	JTextField id_tf, stat_tf = null;
	public RentPanel(){
		setLayout(new BorderLayout());
		Font f = new Font("", Font.PLAIN, 20);
		
		JPanel label_p = new JPanel(new FlowLayout(FlowLayout.CENTER,20,30));
		label_p.setBackground(Color.WHITE);
		label_p.setPreferredSize(new Dimension(150,100));
		JLabel id_l = new JLabel("使用者 ID");
        JLabel stat_l = new JLabel("車站 ID");
        id_l.setFont(f);
        stat_l.setFont(f);
        label_p.add(id_l);
        label_p.add(stat_l);
        add(label_p, BorderLayout.WEST); 
 
        JPanel text_p = new JPanel(new FlowLayout(FlowLayout.LEFT,20,30));
        text_p.setBackground(Color.WHITE);
		id_tf = new JTextField(20);
        stat_tf = new JTextField(20);
        
        text_p.add(id_tf);
        text_p.add(stat_tf);
        add(text_p, BorderLayout.CENTER);
        
        JPanel butt_p = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        butt_p.setPreferredSize(new Dimension(500,150));
        butt_p.setBackground(Color.WHITE);
        submit = new JButton("確認");
        cancel = new JButton("返回");
        
        butt_p.add(submit);
        butt_p.add(cancel);
        add(butt_p, BorderLayout.SOUTH);
	}
}
// 6c3db510-fd28-11e4-b939-0800200c9a66