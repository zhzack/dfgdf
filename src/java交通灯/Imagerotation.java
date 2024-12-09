package java��ͨ��;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

 

//ͼƬ��ת������

public class Imagerotation  {
//˳ʱ����ת90�ȣ�ͨ������ͼ�����������RGB ֵ��
public static BufferedImage rotateClockwise90(BufferedImage bi) {

		int width = bi.getWidth();

		int height = bi.getHeight();

		BufferedImage bufferedImage = new BufferedImage(height, width, bi.getType());

		for (int i = 0; i < width; i++)

			for (int j = 0; j < height; j++)

				bufferedImage.setRGB(height - 1 - j, width - 1 - i, bi.getRGB(i, j));

		return bufferedImage;

	}
//��ʱ����ת90�ȣ�ͨ������ͼ�����������RGB ֵ��

	public static BufferedImage rotateCounterclockwise90(BufferedImage bi) {

		int width = bi.getWidth();

		int height = bi.getHeight();

		BufferedImage bufferedImage = new BufferedImage(height, width, bi.getType());

		for (int i = 0; i < width; i++)

			for (int j = 0; j < height; j++)

				bufferedImage.setRGB(j, i, bi.getRGB(i, j));

		return bufferedImage;

	}
//��ת180�ȣ�ͨ������ͼ�����������RGB ֵ��

		public static BufferedImage rotate180(BufferedImage bi) {

			int width = bi.getWidth();

			int height = bi.getHeight();

			BufferedImage bufferedImage = new BufferedImage(width,height,bi.getType());

			for (int i = 0; i < width; i++)

				for (int j = 0; j < height; j++)

					bufferedImage.setRGB( width - i-1,height-j-1, bi.getRGB(i, j));

			return bufferedImage;

		}

		

	//ˮƽ��ת

		public static BufferedImage rotateHorizon(BufferedImage bi) {

			int width = bi.getWidth();

			int height = bi.getHeight();

			BufferedImage bufferedImage = new BufferedImage(width,height,bi.getType());

			for (int i = 0; i < width; i++)

				for (int j = 0; j < height; j++)

					bufferedImage.setRGB( width - i-1,j, bi.getRGB(i, j));

			return bufferedImage;

		}

	//��ֱ��ת

		public static BufferedImage rotateVertical(BufferedImage bi) {

			int width = bi.getWidth();

			int height = bi.getHeight();

			BufferedImage bufferedImage = new BufferedImage(width,height,bi.getType());

			for (int i = 0; i < width; i++)

				for (int j = 0; j < height; j++)

					bufferedImage.setRGB(i,height-1-j, bi.getRGB(i, j));

			return bufferedImage;

		}

		

		//main����,���ڲ���

	/*public static void main(String[] args) throws IOException {

		 // ������ԴͼƬ  

        String pathname = "D:\\JAVA�����ռ�\\java��ͨ��\\src\\ͼƬ\\S2N.png";//System.getProperty("d:") + File.separator + "ͼƬ" + File.separator + "S2N.png";  

        File file = new File(pathname);  

        // ��������ͼƬ  

        String testPath = "D:\\JAVA�����ռ�\\java��ͨ��\\src\\ͼƬ\\S2N.png";//System.getProperty("src") + File.separator + "ͼƬ" + File.separator + "S2N.png";  

        File outFile = new File(testPath);  

        

        //˳ʱ����ת90�Ȳ���

        BufferedImage image = ImageIO.read(file);  

        image=rotateClockwise90(image);

        //ImageIO.write(image, "png", outFile);  

       

        //��ʱ����ת90�Ȳ���

        BufferedImage image2 = ImageIO.read(file);  

        image2=rotateCounterclockwise90(image2);

        //ImageIO.write(image2, "png", outFile); 

        

        //��ת180�Ȳ���

        BufferedImage image3 = ImageIO.read(file);  

        image3=rotate180(image3);

        //ImageIO.write(image3, "png", outFile);  

       

        //ˮƽ��ת����

        BufferedImage image4 = ImageIO.read(file);  

        image4=rotateHorizon(image4);

        //ImageIO.write(image4, "png", outFile);

        

        //��ֱ��ת����

        BufferedImage image5 = ImageIO.read(file);  

        image5=rotateVertical(image5);

        ImageIO.write(image5, "png", outFile);

	}*/

}


