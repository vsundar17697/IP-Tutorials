import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;

public class ExampleEventHandling extends Applet{ 
   StringBuffer strBuffer;

   public void init() {
      strBuffer = new StringBuffer();
      addItem("initializing the apple ");
   }

   public void start() {
      addItem("starting the applet ");
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
      
      g.fillOval(30, 30 , 50, 50);


   }

}

public class Ball{
    int posX, posY, diameter;
    int updateX, updateY;
    Ball(int X , int Y , int D , int uX , int uY){
        posX = X;
        posY = Y;
        diameter = D;
        updateX = uX;
        updateY = uY;
    }

    
}