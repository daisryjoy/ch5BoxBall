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
    private Canvas myCanvas;
    private int r; 
    private int g; 
    private int b;
    private int xSpeed; 
    private int ySpeed;    
    private final int groundPosition;  
    private int bottomWall;
    private int topWall;
    private int leftWall;
    private int rightWall;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  ground position of the ball 
     * @param drawingCanvas  makes the canvas
     * @param xSpeed  horizontal speed of the ball 
     * @param ySpeed  vertical speed of the ball 
     * @param topWall  makes the topWall
     * @param bottomWall  makes the bottomWall
     * @param rightWall  makes the rightWall 
     * @param leftWall  makes the leftWall
     * 
     */
    public BoxBall(int xPos, int yPos, int diameter, Color ballColor, int groundPos, Canvas drawingCanvas, int xSpeed, int ySpeed,
    int topWall, int bottomWall, int rightWall, int leftWall)                   
    {
        xPosition = xPos; 
        yPosition = yPos;
        color = ballColor;
        this.diameter = diameter;
        groundPosition = groundPos;
        myCanvas = drawingCanvas;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.bottomWall = bottomWall; 
        this.rightWall = rightWall;
        this.leftWall = leftWall;
        this.topWall = topWall; 
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
     * Move this ball according to its position and speed and redraws it.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;

         //check if it has hit the ground
         if(yPosition < topWall) {
           yPosition = topWall;
           ySpeed = -ySpeed; 
        }
        // WALL CHECKS
         if (xPosition < leftWall) {
            xPosition = leftWall;
            xSpeed = -xSpeed; // if the ball has hit the left wall reverse xSpeed
        }
        
         if (xPosition  >= (rightWall - diameter)){
             xPosition = (int)(rightWall-diameter);
            xSpeed = -xSpeed; // if the ball has hit the right wall reverse xSpeed
        }
        
         if (yPosition >= bottomWall-diameter) {
             yPosition = (int)(bottomWall - diameter);
            ySpeed = -ySpeed; // if the ball has hit the top wall reverse ySpeed
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
