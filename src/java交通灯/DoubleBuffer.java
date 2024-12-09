package java��ͨ��;


import java.awt.*;

import java.awt.event.*;

public class DoubleBuffer extends Frame//����̳�Frame��

{

    public paintThread pT;//��ͼ�߳�

    public int ypos=-80; //СԲ���Ͻǵ�������

    public DoubleBuffer()//���캯��

    {

       pT=new paintThread(this);

       this.setResizable(false);

       this.setSize(300,300); //���ô��ڵ���ѡ��С

       this.setVisible(true); //��ʾ����

       pT.start();//��ͼ�߳�����

    }


private Image iBuffer;

private Graphics gBuffer;

//����paint(Graphics scr)������

public void paint(Graphics scr)

{

    if(iBuffer==null)

    {

       iBuffer=createImage(this.getSize().width,this.getSize().height);

       gBuffer=iBuffer.getGraphics();

    }

    gBuffer.setColor(getBackground());

    gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);

   gBuffer.setColor(Color.RED);

   gBuffer.fillOval(90,ypos,80,80);

    scr.drawImage(iBuffer,0,0,this);

}


public void update(Graphics scr)

{

    paint(scr);

}


    public static void main(String[] args)

    {

       DoubleBuffer DB=new DoubleBuffer();//��������Ķ���

       DB.addWindowListener(new WindowAdapter()//��Ӵ��ڹرմ�����

       {

           public void windowClosing(WindowEvent e)

           {

              System.exit(0);

           }});

    }

}

class paintThread extends Thread//��ͼ�߳���

{

    DoubleBuffer DB;

       public paintThread(DoubleBuffer DB) //���캯��

       {

           this.DB=DB;

       }

       public void run()//����run()����

       {

           while(true)//�߳��е�����ѭ��

           {

              try{

                  sleep(30); //�߳�����30ms

                  }catch(InterruptedException e){}

              DB.ypos+=5; //�޸�СԲ���Ͻǵ�������

              if(DB.ypos>300) //СԲ�뿪���ں��������Ͻǵ�������

                  DB.ypos=-80;

              DB.repaint();//�����ػ�

           }

       }

}

