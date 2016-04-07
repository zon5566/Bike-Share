import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SelectPanel extends JPanel{
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	public SelectPanel(){
		setLayout(new BorderLayout());
		JPanel p[] = new JPanel[5];
		for(int i = 0 ; i<5 ; i++){
			p[i] = new JPanel();
			p[i].setBackground(Color.WHITE);
			p[i].setPreferredSize(new Dimension(30,30));
		}
		add(p[0],BorderLayout.NORTH);
		add(p[1],BorderLayout.WEST);
		add(p[2],BorderLayout.SOUTH);
		add(p[3],BorderLayout.EAST);
		add(p[4],BorderLayout.CENTER);
		
		p[4].setLayout(new GridLayout(1,3));
		GridLayout gl = new GridLayout(3,1);
		gl.setHgap(1000);
	    gl.setHgap(1000);
		JPanel leftp = new JPanel(gl);
		JPanel midp = new JPanel(gl);
		JPanel rightp = new JPanel(gl);
		
		leftp.setBackground(Color.WHITE);
		midp.setBackground(Color.WHITE);
		rightp.setBackground(Color.WHITE);
		
		Font f = new Font("", Font.PLAIN, 15);

		b1 = new JButton("租車");
		b2 = new JButton("還車");
		b4 = new JButton("查詢使用者");
		b3 = new JButton("查詢單一站點");
		b5 = new JButton("使用者歷史紀錄");
		b6 = new JButton("查詢多個站點");
		b7 = new JButton("加值");
		b8 = new JButton("加值紀錄");
		b9 = new JButton("交錯查詢");
		
		b1.setFont(f);b2.setFont(f);b3.setFont(f);b4.setFont(f);
		b5.setFont(f);b6.setFont(f);b7.setFont(f);b8.setFont(f);
		b9.setFont(f);
		
		setLocation(b1,leftp);
		setLocation(b2,leftp);
		setLocation(b7,leftp);
		setLocation(b4,midp);
		setLocation(b5,midp);
		setLocation(b8,midp);
		setLocation(b3,rightp);
		setLocation(b6,rightp);
		setLocation(b9,rightp);
		
		p[4].add(leftp);
		p[4].add(midp);
		p[4].add(rightp);
	}
	void setLocation(Component obj, JPanel p){
		p.add(obj);
	}
}
