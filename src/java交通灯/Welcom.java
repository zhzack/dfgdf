package java交通灯;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Welcom extends JPanel implements Runnable{
		int info = 0;
		Boolean isLive=true; 
		public void paint(Graphics g) {
			//super.paint(g);
			Graphics2D G=(Graphics2D)g;
			G.fillRect(0, 0, 400,450);
			
			Color[] colors = { Color.ORANGE, Color.LIGHT_GRAY };
			G.setColor(colors[info%2]);
			Font font = new Font("微软雅黑", Font.BOLD, 30)  ;
			//AffineTransform affineTransform = new AffineTransform();
			//affineTransform.rotate(Math.toRadians(30));
			//Font rotatedFont = font.deriveFont(affineTransform);
			G.setFont(font);
			/*for (int i = 0; i < 12; i++) {
g2d.rotate(30 * Math.PI / 180);
g2d.setPaint(colors[i % 2]);
g2d.drawString(s, 0, 0);
}*/
			if (info % 2 == 0) {
				
				G.drawString("多线程红绿灯模拟", 80, 150);
				
				 
			}

		}
		public void run() {
			while (true) {
				try {

					Thread.sleep(100);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				info++;
				this.repaint();
				
				if (isLive == false) {
					break;
				}

			}//while循环结束

		}//run方法结束
		
}
/*


//G.dispose();
*/
