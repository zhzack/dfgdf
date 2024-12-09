package java交通灯;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
@SuppressWarnings("serial")
public class Car_add extends MyCanvas{
//	JButton start=new JButton("statrt");
//	JButton stop=new JButton("stop");
//	 //北灯
// 	static Light light_N_left=new Light(0,0,Light.light_green);
// 	static Light light_N_middle=new Light(50,0,Light.light_green);
// 	static Light light_N_right=new Light(100,0,Light.light_red);
// 	//南灯
// 	static Light light_S_left=new Light(50,0,Light.light_red);
// 	static Light light_S_middle=new Light(100,0,Light.light_green);
// 	static Light light_S_right=new Light(150,0,Light.light_green);
// 	//东灯
// 	static Light light_E_left=new Light(0,0,Light.light_green);
// 	static Light light_E_middle=new Light(0,50,Light.light_red);
// 	static Light light_E_right=new Light(0,100,Light.light_red);
// 	//西灯
// 	static Light light_W_left=new Light(0,50,Light.light_red);
// 	static Light light_W_middle=new Light(0,100,Light.light_red);
// 	static Light light_W_right=new Light(0,150,Light.light_green);
	
 	//四组灯组
//    Light_control Light_control1=new Light_control(light_N_right,light_N_middle,light_N_left,"NS",'N',10);
// 	Light_control Light_control2=new Light_control(light_S_left,light_S_middle,light_S_right,"NS",'S',10);
// 	Light_control Light_control3=new Light_control(light_E_right,light_E_middle,light_E_left,"WE",'E',20);
// 	Light_control Light_control4=new Light_control(light_W_left,light_W_middle,light_W_right,"WE",'W',20);
// 		Thread f1=new Thread(Light_control1);
//	 	Thread f2=new Thread(Light_control2);
//	 	Thread f3=new Thread(Light_control3);
//	 	Thread f4=new Thread(Light_control4);
 	//线程对象
// 	public Car_add() {
// 		 	start.addActionListener(this);
//			start.setBounds(30, 30, 80, 30);
//			this.add(start);
//			
//			stop.addActionListener(this);
//			stop.setBounds(30, 70, 80, 30);
//			this.add(stop);
//		//设置灯组在面板的位置
//		 	 	Light_control1.setBounds(405, 305, 200,50);//N
//		 	 	Light_control2.setBounds(495, 545,200,50);//S
//		 	 	Light_control3.setBounds(645, 305, 50,200);//E
//		 	 	Light_control4.setBounds(405, 395, 50,200);//W
//		 	 	//添加四个灯组
//		 	 	 	this.add(Light_control1);
//		 	 	 	this.add(Light_control2);
//		 	 	 	this.add(Light_control3);
//		 	 	 	this.add(Light_control4);
// 	}//构造方法结束
// 		 	@Override
//public void actionPerformed(ActionEvent e) {
// 				if(e.getSource()==start) {
// 					//启动四组灯
// 					Light_control.RUN=true;
// 				 	f1.start();
// 				 	f2.start();
// 				 	f3.start();
// 				 	f4.start();
// 				 	
// 				}
// 				else if(e.getSource()==stop)
// 			 	{
// 					Light_control.RUN=false;
// 			 	}
// 				
// 			}//添加监听事件结束
//public void paint(Graphics g) {
// 		 	super.paint(g);
// 		 	Graphics2D G=(Graphics2D)g;
//for (int j = 0; j <Car.list_all.size(); j++) 
//		if(Car.list_all.get(j).road=="S2W"||Car.list_all.get(j).road=="S2N"||
//				   Car.list_all.get(j).road=="S2E"||Car.list_all.get(j).road=="N2E"||
//				   Car.list_all.get(j).road=="N2S"||Car.list_all.get(j).road=="N2W") 
//					if(Car.list_all.get(j).turn_left==false)
//						  	G.drawImage(getToolkit().getImage(Car.list_all.get(j).car_img), Car.list_all.get(j).x1, Car.list_all.get(j).y1, Car.car_width, Car.car_height, this);
//					else {
//							//G.rotate(Math.toRadians(-90),Car.list_all.get(j).x1,Car.list_all.get(j).y1);
//							G.drawImage(getToolkit().getImage(Car.list_all.get(j).car_img), Car.list_all.get(j).x1, Car.list_all.get(j).y1, Car.car_width, Car.car_height, this);}
//					else 
//						  	G.drawImage(getToolkit().getImage(Car.list_all.get(j).car_img), Car.list_all.get(j).x1, Car.list_all.get(j).y1, Car.car_height, Car.car_width, this);
//				
//	}

//public void update(Graphics scr)
//
//{
//
//    paint(scr);
//
//}

	
} 		 	
 		 	
 		 	
	



