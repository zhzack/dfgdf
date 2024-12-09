package java½»Í¨µÆ;
import javax.swing.*;

//import traffic.welcompanel;
public class Test1 extends JFrame{
	Test1(){
		Welcom w=new Welcom();
		this.setVisible(true);
		this.setBounds(500, 100, 400,450);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Welcom());
		
		this.setContentPane(w);
		new Thread(w).start();
	}
	public static void main(String[] args) {
		new Test1();
	}
}
