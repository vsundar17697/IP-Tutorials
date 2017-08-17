import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
// import java.applet.Applet;
// import java.awt.Graphics;

import java.applet.Applet;
import java.awt.Graphics;


public class ExampleEventHandling extends Applet implements Runnable{ 
   StringBuffer strBuffer;
    Ball ballOne = new Ball(30 , 30 , 50 , 1 , 1);
    Ball ballTwo = new Ball(200 , 200 , 50 , 1 , 1);
    Ball ballThree = new Ball(300 , 300 , 50 , 1 , 1);

   public void init() {
      strBuffer = new StringBuffer();
      addItem("initializing the apple ");
   }

   public void start() {
      addItem("starting the applet ");
      Thread th = new Thread(this);
      th.start();
   }

   public void run(){
     while(true){
        int width = getWidth();
        int height = getHeight();
        ballOne.updateLim(width, height);
        ballTwo.updateLim(width, height);


        ballOne.updatePosX();
        ballOne.updatePosY();
        ballOne.checkOtherBall(ballTwo);

        ballTwo.updatePosX();
        ballTwo.updatePosY();
        ballTwo.checkOtherBall(ballOne);




        repaint();
        try{
          Thread.sleep(5);
        }
        catch(Exception e){
          System.out.println("thread sleep");
        }
     }
   }

   public void stop() {
      addItem("stopping the applet ");
   }

   public void destroy() {
      addItem("unloading the applet");
   }

   void addItem(String word) {
      System.out.println(word);
      strBuffer.append(word);
      repaint();
   }

   public void paint(Graphics g) {
      // Draw a Rectangle around the applet's display area.
        ballOne.fillBall(g);
        ballTwo.fillBall(g);
        g.drawString("hehe" , 100 , 200);
   }

}
