import java.awt.*;
import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Rectangle2D;


/**
 * Class BoxBall - a graphical ball that moves at a constant rate in
 * the x and y axes and bounces off of 'walls' as defined by values passed in
 * to the BoxBall Constructor
 * 
 * This class  is a precursor to implementing Pong
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * EXTRA CREDTIT: diameter of ball is randomized. 
 * 
 * @author Daisry Joy Ladignon
 * 
 * @version 2018.10.15
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int bottomWall;          // y position of bottom Wall
    private int topWall;             // y position of top Wall
    private int leftWall;            // x position of left Wall
    private int rightWall;           // x position of right Wall
    private Canvas myCanvas;
    private int r; 
    private int g; 
    private int b;
    private int xSpeed; 
    private int ySpeed;
    
 

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * 
     */
    public BoxBall()                   
    {
        Random rand = new Random();
        do{
            xSpeed = rand.nextInt(); // randomizes the x position speed for each ball
        } while (xSpeed == 0); 
        do{ ySpeed = rand.nextInt(); // randomizes y position speed for each ball
        }while (ySpeed == 0);
        
        
        do{
            xPosition = rand.nextInt(375 - 10) + 1 + 10; // randomizes x position starting point 
        }while (xPosition==0); 
        do { 
            yPosition = rand.nextInt(375 - 10) +1 + 10; // randomizes y position starting point
        } while(yPosition==0);    
        
        do{
            diameter = rand.nextInt(25-10)+1+10; //EXTRA CREDIT randomize the diameter of the ball
        }while (diameter ==0); 
       
        r = rand.nextInt(250); // random int, which will be passed as the red value in rgb
        g = rand.nextInt(250); // random int, which will be passed as the green value in rgb
        b = rand.nextInt(250); // random int, which will be passed as the blue value in rgb
        color = new Color(r, g, b);                
       
}

    
   

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        myCanvas.setForegroundColor(color);
        myCanvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        myCanvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;

         //check if it has hit the ground
      if(yPosition >= (bottomWall - diameter) && ySpeed > 0) {
           yPosition = (int)(bottomWall - diameter);
           ySpeed = -ySpeed; 
        }

        // WALL CHECKS
        else if (xPosition <= leftWall && xSpeed < 0) {
            xSpeed = -xSpeed; // if the ball has hit the left wall reverse xSpeed
        }
        
        else if (xPosition > rightWall && xSpeed < 0) {
            xSpeed = -xSpeed; // if the ball has hit the right wall reverse xSpeed
        }
        
        else if (yPosition < topWall && ySpeed < 0) {
            ySpeed = -ySpeed; // if the ball has hit the top wall reverse ySpeed
        }
        
        else if (yPosition <= bottomWall && ySpeed < 0) {
            ySpeed = -ySpeed; // if the ball has hit the bottome wall reverse ySpeed
        }
        else { // else if none of the things happen, keep speed and positions the same
            ySpeed = ySpeed;
            xSpeed = xSpeed;
            yPosition = yPosition;
            xPosition = xPosition;    
        }
        // draw again at new position
        draw();
    }    

    
    public void bounce ()
    {
        int ground = 400;
         myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, 50, 50, ground);
        myCanvas.drawLine(50, 50, 550, 50); 
        myCanvas.drawLine(550, 50, 550, ground); 
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
