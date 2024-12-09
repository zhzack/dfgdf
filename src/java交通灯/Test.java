package java��ͨ��;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class Test extends Map implements Runnable{
	boolean turn_left=false;
	boolean turn_right=false;//����������Ա��������ͼƬ�Ƿ���ת�ı�ʶ
	List <Car>list_all=new ArrayList<Car>();
public Test(List <Car>list_all) {
    this.list_all=list_all;
    	
    }//���췽��Test()����
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
	
}//paint()��������
	@Override
	public void run() {
		if(this.list_all!=null)
		while(true) {
			for (int i = 0; i < this.list_all.size(); i++) {
			switch(this.list_all.get(i).road) {
			case "S2W"://ת�۵㣨570,430������ת��
				boolean temp=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		           while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()�е�y1���ݼ�����
		            		repaint();
		            if(this.list_all.get(j).y1==430) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp=true;
		            }
		            if(temp&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp=false;
	            		break;
		            }//if�жϽ���
		            }//whileѭ������
		            }//forѭ������
		       
				break;
			case "S2N"://��ֱ�߱�
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            	try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            	this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()�е�y1���ݼ�����
		            	repaint();
		            if(this.list_all.get(j).y1==this.list_all.get(j).y2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "S2E"://����ת��
				boolean temp1=false;
				for (int j = 0; j < this.list_all.size(); j++) {
			            while(true) {
			            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
			            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_S2N()�е�y1���ݼ�����
			            		repaint();
			            if(this.list_all.get(j).y1==600) {
			            		turn_right=true;
			            		repaint();
			            		turn_right=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
			            		temp1=true;
			            }//�ڶ���if�жϽ���
			            if(temp1&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
			            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()�е�x1����������
			            else {
			            		this.list_all.remove(j);
			            		repaint();
			            		temp1=false;
			            		break;
			            }//f�жϽ���
			            }//whileѭ������
			        }//forѭ������
				 break;
			case "N2E"://ת�۵㣨530,470������ת��
				boolean temp2=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_S2N()�е�y1���ݼ�����
		            		repaint();
		            if(this.list_all.get(j).y1==470) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp2=true;
		             }//if�жϽ���
		            if(temp2&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            	this.list_all.remove(j);
		            	temp2=false;
	            		repaint();
	            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "N2S"://��ֱ����
				for (int j = 0; j < this.list_all.size(); j++) { 	
		            while(true) {
		            	try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            	this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()�е�Ԫ������������
		            	repaint();
		            if(this.list_all.get(j).y1==this.list_all.get(j).y2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "N2W"://����ת��
				boolean temp3=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()�е�y1����������
		            		repaint();
		            if(this.list_all.get(j).y1==360) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp3=true;
		            }
		            if(temp3&&(this.list_all.get(j).x1!=this.list_all.get(j).x2))
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp3=false;
		            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "E2S"://����ת�� ת�۵㣨530,430��
				boolean temp4=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_S2N()�е�y1����������
		            		repaint();
		            if(this.list_all.get(j).x1==520) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp4=true;
		            }
		            if(temp4&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		     
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp4=false;
	            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "E2W"://��ֱ����
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_E2W()�е�y1���ݼ�����
		            repaint();
		            if(this.list_all.get(j).x1==this.list_all.get(j).x2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "E2N"://����ת��
				boolean temp5=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1-=this.list_all.get(j).velocity;//list_all()�е�y1����������
		            		repaint();
		            if(this.list_all.get(j).x1==670) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp5=true;
		            }
		            if(temp5&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp5=false;
		            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "W2N"://����ת�� ת�۵㣨570,470��
				boolean temp6=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_S2N()�е�y1����������
		            		repaint();
		            if(this.list_all.get(j).x1==570) {
		            		turn_left=true;
		            		repaint();
		            		turn_left=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp6=true;
		            }
		            if(temp6&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1-=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            	this.list_all.remove(j);
	            		repaint();
	            		temp6=false;
	            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "W2E"://��ֱ�߶�
				for (int j = 0; j < this.list_all.size();j++) {
		            while(true) {
		            try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_S2N()�е�Ԫ�����ݼ�����
		            repaint();
		            if(this.list_all.get(j).x1==this.list_all.get(j).x2)
		            {
		            	this.list_all.remove(j);
		            	repaint();
		            	break;
		            	//t=false;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			case "W2S"://����ת��
				boolean temp7=false;
				for (int j = 0; j < this.list_all.size(); j++) {
		            while(true) {
		            		try {Thread.sleep(300);}catch(InterruptedException e) {e.printStackTrace();}
		            		this.list_all.get(j).x1+=this.list_all.get(j).velocity;//list_all()�е�y1����������
		            		repaint();
		            if(this.list_all.get(j).x1==450) {
		            		turn_right=true;
		            		repaint();
		            		turn_right=false;//ֻתһ�Σ�����Ҫ��ʱ�ı���תֵ
		            		temp7=true;
		            }
		            if(temp7&&(this.list_all.get(j).y1!=this.list_all.get(j).y2))
		            		this.list_all.get(j).y1+=this.list_all.get(j).velocity;//list_all()�е�x1���ݼ�����
		            else {
		            		this.list_all.remove(j);
		            		repaint();
		            		temp7=false;
		            		break;
		            }//if�жϽ���
		            }//whileѭ������
		        }//forѭ������
				 break;
			}//switch������
			}//for ѭ��
			}//whileѭ��
		
		}//run()����
	
	}


