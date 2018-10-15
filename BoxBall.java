import java.awt.*;
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
    private static final int GRAVITY = 3;  // effect of gravity

    // private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int bottomWall;          // y position of bottom Wall
    private int topWall;             // y position of top Wall
    private int leftWall;            // x position of left Wall
    private int rightWall;           // x position of right Wall
    private Canvas canvas;
    private int r; 
    private int g; 
    private int b;
    private int xSpeed; 
    private int ySpeed;
    private Random rand = new Random();
    private ArrayList<BoxBall> balls; 

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int bottomWall,
                   int topWall, int rightWall, int leftWall, Canvas drawingCanvas,
                   int ySpeed, int xSpeed)                   
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        this.topWall = topWall; 
        this.bottomWall = bottomWall; 
        this.rightWall = rightWall; 
        this.leftWall = leftWall; 
        this.ySpeed = ySpeed; 
        this.xSpeed = xSpeed; 
       
    }

    
    /**
     * This method draws the canvas and the balls that move inisde.
     */
    public void boxBounce(){
        canvas = new Canvas("Box", 700, 700);
        balls = new ArrayList<BoxBall>(); 
        rand = new Random(); 
        
        //drawing the box
        leftWall = 0;
        rightWall = 600;
        topWall = 0;
        bottomWall = 600;
        
        canvas.setVisible(true); // makes the canvas visible
        
        for(int i = 0; i <=  30 && i >= 5;  i++) // randomizes the number of balls 
        { do{
            xSpeed = rand.nextInt(); // randomizes the x position speed for each ball
        } while (xSpeed == 0); 
        do{ ySpeed = rand.nextInt(); // randomizes y position speed for each ball
        }while (ySpeed == 0);
        
        
        do{
            xPosition = rand.nextInt(rightWall - leftWall) + 1 + leftWall; // randomizes x position starting point 
        }while (xPosition==0); 
        do { 
            yPosition = rand.nextInt(bottomWall - topWall) +1 + topWall; // randomizes y position starting point
        } while(yPosition==0);    
        
        do{
            diameter = rand.nextInt(25-10)+1+10; //EXTRA CREDIT randomize the diameter of the ball
        }while (diameter ==0); 
       
        r = rand.nextInt(250); // random int, which will be passed as the red value in rgb
        g = rand.nextInt(250); // random int, which will be passed as the green value in rgb
        b = rand.nextInt(250); // random int, which will be passed as the blue value in rgb
        
        //add new balls to the ArrayList with the random generated speed, position, and color
        balls.add(new BoxBall(xPosition, yPosition, diameter, new Color(r, g, b),
        leftWall, rightWall, topWall, bottomWall, canvas, xSpeed, ySpeed));
       
        
        //while loop keeps the balls moving. The balls will never stop bouncing. 
        while(true){
            for (BoxBall b : balls){
                b.move(); 
                
        //redraws canvas if chipped
        Shape rectangle = (new Rectangle2D.Double(leftWall, topWall, rightWall, bottomWall));
        canvas.draw(rectangle);
    }
}
}
}


    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
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
