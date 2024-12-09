package java交通灯;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class Test extends Map implements Runnable{
	boolean turn_left=false;
	boolean turn_right=false;//定义两个成员变量来做图片是否旋转的标识
	List <Car>list_all=new ArrayList<Car>();
public Test(List <Car>list_all) {
    this.list_all=list_all;
    	
    }//构造方法Test()结束
    /*public static void main(String[] args) {
    	Car_add f=new Car_add();
    	f.add_car();
		new Thread(new Test(f.list_S2W)).start();
		new Thread(new Test(f.list_S2N)).start();
		new Thread(new Test(f.list_S2E)).start();
		new Thread(new Test(f.list_N2E)).start();
		new Thread(new Test(f.list_N2S)).start();
		new Thread(new Test(f.list_N2W)).start();
		new Thread(new Test(f.list_E2N)).start();
		new Thread(new Test(f.list_E2S)).start();
		new Thread(new Test(f.list_E2W)).start();
		new Thread(new Test(f.list_W2N)).start();
		new Thread(new Test(f.list_W2E)).start();
		new Thread(new Test(f.list_W2S)).start();
    	new Thread(new Test(f.list_all)).start();	
	}*/
	public void paint(Graphics g) {
		Graphics2D G=(Graphics2D)g;
		if(this.list_all!=null)
	for (int j = 0; j < list_all.size(); j++) 
		if(list_all.get(j).road=="S2W"||list_all.get(j).road=="S2N"||
		   list_all.get(j).road=="S2E"||list_all.get(j).road=="N2E"||
		   list_all.get(j).road=="N2S") 
			G.drawImage(getToolkit().getImage(list_all.get(j).car_img), list_all.get(j).x1, list_all.get(j).y1, Car.car_width, Car.car_height, this);
		else 
			G.drawImage(getToolkit().getImage(list_all.get(j).car_img), list_all.get(j).x1, list_all.get(j).y1, Car.car_height, Car.car_width, this);
	
}//paint()方法结束
	@Override
	public void run() {
		if(this.list_all!=null)
		while(true) {
			for (int i = 0; i < this.list_all.size(); i++) {
			switch(this.list_all.get(i).road) {
			case "S2W"://转折点（570,430）南左转西
				boolean temp=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		           while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()中的y1做递减操作
		            		repaint();
		            if(this.list_all.get(j).y1==430) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//只转一次，所以要及时改变左转值
		            		temp=true;
		            }
		            if(temp&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp=false;
	            		break;
		            }//if判断结束
		            }//while循环结束
		            }//for循环结束
		       
				break;
			case "S2N"://南直走北
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            	try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            	this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()中的y1做递减操作
		            	repaint();
		            if(this.list_all.get(j).y1==this.list_all.get(j).y2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "S2E"://南右转东
				boolean temp1=false;
				for (int j = 0; j < this.list_all.size(); j++) {
			            while(true) {
			            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
			            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()中的y1做递减操作
			            		repaint();
			            if(this.list_all.get(j).y1==600) {
			            		turn_right=true;
			            		repaint();
			            		turn_right=false;//只转一次，所以要及时改变右转值
			            		temp1=true;
			            }//第二层if判断结束
			            if(temp1&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
			            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()中的x1做递增操作
			            else {
			            		this.list_all.remove(j);
			            		repaint();
			            		temp1=false;
			            		break;
			            }//f判断结束
			            }//while循环结束
			        }//for循环结束
				 break;
			case "N2E"://转折点（530,470）北左转东
				boolean temp2=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_S2N()中的y1做递减操作
		            		repaint();
		            if(this.list_all.get(j).y1==470) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//只转一次，所以要及时改变左转值
		            		temp2=true;
		             }//if判断结束
		            if(temp2&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            	this.list_all.remove(j);
		            	temp2=false;
	            		repaint();
	            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "N2S"://北直走南
				for (int j = 0; j < this.list_all.size(); j++) { 	
		            while(true) {
		            	try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            	this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()中的元素做递增操作
		            	repaint();
		            if(this.list_all.get(j).y1==this.list_all.get(j).y2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "N2W"://北右转西
				boolean temp3=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()中的y1做递增操作
		            		repaint();
		            if(this.list_all.get(j).y1==360) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//只转一次，所以要及时改变右转值
		            		temp3=true;
		            }
		            if(temp3&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp3=false;
		            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "E2S"://东左转南 转折点（530,430）
				boolean temp4=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_S2N()中的y1做递增操作
		            		repaint();
		            if(this.list_all.get(j).x1==520) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//只转一次，所以要及时改变左转值
		            		temp4=true;
		            }
		            if(temp4&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		     
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp4=false;
	            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "E2W"://东直走西
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_E2W()中的y1做递减操作
		            repaint();
		            if(this.list_all.get(j).x1==this.list_all.get(j).x2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "E2N"://东右转北
				boolean temp5=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()中的y1做递增操作
		            		repaint();
		            if(this.list_all.get(j).x1==670) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//只转一次，所以要及时改变右转值
		            		temp5=true;
		            }
		            if(temp5&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp5=false;
		            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "W2N"://西左转北 转折点（570,470）
				boolean temp6=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_S2N()中的y1做递增操作
		            		repaint();
		            if(this.list_all.get(j).x1==570) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//只转一次，所以要及时改变左转值
		            		temp6=true;
		            }
		            if(temp6&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp6=false;
	            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "W2E"://西直走东
				for (int j = 0; j < this.list_all.size();j++) {
		            while(true) {
		            try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_S2N()中的元素做递减操作
		            repaint();
		            if(this.list_all.get(j).x1==this.list_all.get(j).x2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            	//t=false;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			case "W2S"://西右转南
				boolean temp7=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()中的y1做递增操作
		            		repaint();
		            if(this.list_all.get(j).x1==450) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//只转一次，所以要及时改变右转值
		            		temp7=true;
		            }
		            if(temp7&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()中的x1做递减操作
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp7=false;
		            		break;
		            }//if判断结束
		            }//while循环结束
		        }//for循环结束
				 break;
			}//switch语句结束
			}//for 循环
			}//while循环
		
		}//run()结束
	
	}


