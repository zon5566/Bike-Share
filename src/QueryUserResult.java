import javax.swing.*;
import java.awt.*;

public class QueryUserResult extends JPanel{
	
	JScrollPane scroll_p;
	JButton OK;
	Font f;
	public QueryUserResult(){
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		f = new Font("", Font.PLAIN, 20);
	
		JPanel south_p = new JPanel();
		south_p.setBackground(Color.WHITE);
		south_p.setLayout(new BorderLayout());
		OK = new JButton("½T»{");
		OK.setFont(f);
		south_p.add(OK,BorderLayout.SOUTH);
		
		//add(scroll_p, BorderLayout.CENTER);
		add(south_p, BorderLayout.SOUTH);
	}
	public void makeScrollPane(JTextArea msg){
		msg.setFont(f);
		msg.setEditable(false);
		scroll_p = new JScrollPane(msg);
		JScrollBar verticalScrollBar = scroll_p.getVerticalScrollBar();
	    JScrollBar horizontalScrollBar = scroll_p.getHorizontalScrollBar();
	    verticalScrollBar.setValue(verticalScrollBar.getMinimum());
	    horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
		
		add(scroll_p, BorderLayout.CENTER);
	}
}
// 6c3db510-fd28-11e4-b939-0800200c9a66