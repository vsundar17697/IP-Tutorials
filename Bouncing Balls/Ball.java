import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;



public class Ball{
    int posX, posY, diameter;
    int updateX, updateY;
    int limX , limY;
    Ball(int X , int Y , int D , int uX , int uY){
        posX = X;
        posY = Y;
        diameter = D;
        updateX = uX;
        updateY = uY;
    }

    public void fillBall(Graphics g){
        g.fillOval(posX, posY , diameter, diameter);
    }

    public void updatePosX(){
        posX = posX + updateX;
        System.out.println("PosX : " + posX);
        changeUpdateX();
    }
    public void updatePosY(){
        posY = posY + updateY;
        System.out.println("PosY : " + posY);
        changeUpdateY();
    }

    public void updateLim(int x , int y){
        limX = x;
        limY = y;
    }

    // public void 

    public void changeUpdateX(){
        if(posX <= 0){
            updateX = 1;
        }
        else if(posX == limX - diameter){
            updateX = -1;
        }
    }

    public void changeUpdateY(){
        if(posY <= 0){
            updateY = 1;
        }
        else if(posY == limY - diameter){
            updateY = -1;
        }
    }

    public boolean isCollision(Ball other){
        int diffX = this.posX > other.posX ? this.posX - other.posX : other.posX - this.posX;
        int diffY = this.posY > other.posY ? this.posY - other.posY : other.posY - this.posY;

        if((diffX <= this.diameter/2 + other.diameter/2) && (diffY <= this.diameter/2 + other.diameter/2)){
            return true;
        }
        else    {
            return false;
        }

    }

    public void checkOtherBall(Ball other){
        if(isCollision(other)){
            this.updateX = this.updateX * -1;
            this.updateY = this.updateY * -1;
        }
    }

    
}