import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class QueryDepositPanel extends JPanel{
	JButton submit, cancel;
	JTextField id_tf;
	JPanel result_p;
	MakeComboBox mcb;
	public QueryDepositPanel(){
		
		JPanel p[] = new JPanel[6];
		for(int i = 0 ; i<6 ; i++){
			if(i==5) p[i] = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
			else p[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
			p[i].setBackground(Color.WHITE);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		Font f = new Font("", Font.PLAIN, 14);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,3,5,3);
		c.anchor = GridBagConstraints.WEST;
		
		JLabel id_l = new JLabel("使用者 ID");
		id_l.setFont(f);
		id_tf = new JTextField(25);
		setLocation(id_l,p[0], c, 0, 0, 1, 1);
		setLocation(id_tf,p[0], c, 1, 0, 20, 1);
	
        mcb = new MakeComboBox();
        JLabel[] time_l = new JLabel[12];
        String[] time = {"年","月","日", "時", "分","秒","年","月", "日", "時", "分","秒"};
        for(int i = 0 ; i<12; i++){
        	time_l[i] = new JLabel(time[i]);
        	time_l[i].setFont(f);
        }
        
        JLabel from_l = new JLabel("起點時間"); 
        JLabel trash1_l = new JLabel("                   ");
        from_l.setFont(f);
        setLocation(from_l, p[1], c,      0, 1, 1, 1);
        setLocation(mcb.from[0], p[1], c, 1, 1, 1, 1);
        setLocation(time_l[0], p[1], c,   2, 1, 1, 1);
        setLocation(mcb.from[1], p[1], c, 3, 1, 1, 1);
        setLocation(time_l[1], p[1], c,   4, 1, 1, 1);
        setLocation(mcb.from[2], p[1], c, 7, 1, 1, 1);
        setLocation(time_l[2], p[1], c,   8, 1, 1, 1);
        setLocation(trash1_l, p[2],c,1,1,1,1);
        setLocation(mcb.from[3], p[2], c, 1, 2, 1, 1);
        setLocation(time_l[3], p[2], c,   2, 2, 1, 1);
        setLocation(mcb.from[4], p[2], c, 3, 2, 1, 1);
        setLocation(time_l[4], p[2], c,   4, 2, 1, 1);
        setLocation(mcb.from[5], p[2], c, 6, 2, 1, 1);
        setLocation(time_l[5], p[2], c,   7, 2, 1, 1);       
            
        JLabel to_l = new JLabel("終點時間");
        JLabel trash1_2 = new JLabel("                   ");
        to_l.setFont(f);
        setLocation(to_l, p[3], c,      0, 3, 1, 1);
        setLocation(mcb.to[0], p[3], c, 1, 3, 1, 1);
        setLocation(time_l[6], p[3], c, 2, 3, 1, 1);
        setLocation(mcb.to[1], p[3], c, 3, 3, 1, 1);
        setLocation(time_l[7], p[3], c, 4, 3, 1, 1);
        setLocation(mcb.to[2], p[3], c, 6, 3, 1, 1);
        setLocation(time_l[8], p[3], c, 7, 3, 1, 1);
        setLocation(trash1_2, p[4],c,1,1,1,1);
        setLocation(mcb.to[3], p[4], c, 1, 4, 1, 1);
        setLocation(time_l[9], p[4], c, 2, 4, 1, 1);
        setLocation(mcb.to[4], p[4], c, 3, 4, 1, 1);
        setLocation(time_l[10], p[4], c, 4, 4, 1, 1);
        setLocation(mcb.to[5], p[4], c, 6, 4, 1, 1);
        setLocation(time_l[11], p[4], c, 7, 4, 1, 1);           

        submit = new JButton("確認");
        cancel = new JButton("返回");
        setLocation(submit,p[5],c,2,5,1,1);
        setLocation(cancel,p[5],c,3,5,1,1);
        
        for(int i = 0 ; i<6 ; i++) add(p[i]);
	}
	void setLocation(Component obj, JPanel p, GridBagConstraints c, int gridx, int gridy, int width, int height){
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = width;
		c.gridheight = height;
		p.add(obj,c);
	}
	
	public class MakeComboBox implements ItemListener{ 
		@SuppressWarnings("rawtypes")
		JComboBox from[], to[];
		int year[], month[], date[], hour[], minute[], second[];
		boolean is_leap = false;
		@SuppressWarnings("unchecked")
		public MakeComboBox(){	
			from = new JComboBox[6];
			to = new JComboBox[6];
			for(int i= 0 ; i<6 ; i++){
				from[i] = new JComboBox<Integer>();
				to[i] = new JComboBox<Integer>();
				from[i].addItemListener(this);
				to[i].addItemListener(this);    
			}
			for(int i = 0 ; i<100 ; i++){
				from[0].addItem(i+2000);
				to[0].addItem(i+2000);
			}
			for(int i = 0 ; i<24 ; i++){
				from[3].addItem(i);
				to[3].addItem(i);
			}
			for(int i = 0 ; i<60 ; i++){
				from[4].addItem(i);
				to[4].addItem(i);
				from[5].addItem(i);
				to[5].addItem(i);
			}
			for(int i = 0 ; i<12 ; i++){
				from[1].addItem(i+1);
				to[1].addItem(i+1);
			}
			for(int i = 0 ; i<31 ; i++){
				from[2].addItem(i+1);
				to[2].addItem(i+1);
			}
			
			for(int i=0 ; i<6 ; i++){
				from[i].setSelectedIndex(-1);
				to[i].setSelectedIndex(-1);
			}
			from[1].setEnabled(false);
			from[2].setEnabled(false);
			to[1].setEnabled(false);
			to[2].setEnabled(false);
			
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public void itemStateChanged(ItemEvent e){
			int index = 0;
			if(e.getSource()==from[0]){
				from[1].removeAllItems();				
				index = from[0].getSelectedIndex()+2000;
				if(index!=-1){
					if((index % 4==0 && index%100!=0)||(index%400==0)) is_leap = true;
					else is_leap = false;	
					for(int i=0 ; i<12 ;i++){
						from[1].addItem(i+1);
					}
					from[1].setEnabled(true);
					if(from[1].getSelectedIndex()!=-1){
						from[1].setSelectedIndex(-1);
						from[2].setSelectedIndex(-1);
					}
				}
			}
			else if(e.getSource()==from[1]){//month
				from[2].removeAllItems();
				index = from[1].getSelectedIndex() + 1;
				if(index!=-1){
					if(index==2){
						if(is_leap)
							for(int i = 0 ; i<29 ; i++)
								from[2].addItem(i+1);
						else
							for(int i = 0 ; i<28 ; i++)
								from[2].addItem(i+1);
					}
					else if(index!=8 && (index%2==0&&index<8||index%2!=0&&index>8))
						for(int i = 0 ; i<30 ; i++)
							from[2].addItem(i+1);
					else if(index==8 ||(index%2!=0&&index<8) || (index%2==0&&index>8))
						for(int i = 0 ; i<31 ; i++)
							from[2].addItem(i+1);
				}
				if(from[1].isEnabled()){
					if(from[1].getSelectedIndex()!=-1){
						from[2].setEnabled(true);
						from[2].setSelectedIndex(-1);
					}
				}
			}
			else if(e.getSource()==to[0]){
				to[1].removeAllItems();
				index = to[0].getSelectedIndex()+2000;
				if(index!=-1){
					if((index % 4==0 && index%100!=0)||(index%400==0)) is_leap = true;
					else is_leap = false;	
					for(int i=0 ; i<12 ;i++){
						to[1].addItem(i+1);
					}
					
				}	
				to[1].setEnabled(true);
				to[1].setSelectedIndex(-1);
				to[2].setSelectedIndex(-1);
			}
			else if(e.getSource()==to[1]){//month
				to[2].removeAllItems();
				index = to[1].getSelectedIndex()+1;
				if(index!=-1){
					if(index==2){
						if(is_leap)
							for(int i = 0 ; i<29 ; i++)
								to[2].addItem(i+1);
						else
							for(int i = 0 ; i<28 ; i++)
								to[2].addItem(i+1);
					}
					else if(index!=8 && (index%2==0&&index<8||index%2!=0&&index>8))
						for(int i = 0 ; i<30 ; i++)
							to[2].addItem(i+1);
					else if(index==8 ||(index%2!=0&&index<8) || (index%2==0&&index>8))
						for(int i = 0 ; i<31 ; i++)
							to[2].addItem(i+1);
					if(to[1].isEnabled()){
						if(to[1].getSelectedIndex()!=-1){
							to[2].setEnabled(true);
							to[2].setSelectedIndex(-1);
						}
					}
				}
			}
		}
	}
}
// 6c3db510-fd28-11e4-b939-0800200c9a66