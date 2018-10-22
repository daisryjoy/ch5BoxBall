import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Daisry Joy Ladignon
 * @version 2018.10.22
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
        
        /**
         * This method draws a rectangle (the box) on screen and
         * between five and thirty balls that move inside the box.
         */
        public void boxBounce(){
            
        Random rand = new Random();
        int ground = 400;
        myCanvas = new Canvas("Box", 700, 700);
        //create BoxBall objects array
        int numberOfBalls = rand.nextInt(30-5+1)+5; 
        BoxBall[] balls = new BoxBall[numberOfBalls];
        
         int r; 
         int g; 
         int b;
         int xSpeed; 
         int ySpeed;
         int xPosition;
         int yPosition;
         int diameter;
         Color color;
        myCanvas.drawLine(50,50,50, 400);
        myCanvas.drawLine(50, 50, 550, 50); 
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(550, 400, 550, 50); 
        myCanvas.setVisible(true); // makes the canvas visible
        
        for(int i = 0; i < balls.length; i++) // randomizes the number of balls 
        {
        
        
            xSpeed = rand.nextInt(); // randomizes the x position speed for each ball
        
         ySpeed = rand.nextInt(); // randomizes y position speed for each ball
        
        
        
        
            xPosition = rand.nextInt(375 - 10) + 1 + 10; // randomizes x position starting point 
        
          yPosition = rand.nextInt(375 - 10) +1 + 10; // randomizes y position starting point
           
        
        
            diameter = rand.nextInt(25-10)+1+10; //EXTRA CREDIT randomize the diameter of the ball
       
       
        r = rand.nextInt(250); // random int, which will be passed as the red value in rgb
        g = rand.nextInt(250); // random int, which will be passed as the green value in rgb
        b = rand.nextInt(250); // random int, which will be passed as the blue value in rgb
        color = new Color(r, g, b);  
        
        BoxBall ball = new BoxBall(xPosition, yPosition, diameter, color, myCanvas);
        balls[i] = ball;
        balls[i].draw();
           
         //while loop keeps the balls moving. The balls will never stop bouncing. 
        for(int x = 0; x<balls.length; x++){
            balls[x].move(); 
        }
                
        //redraws canvas if chipped
        myCanvas.drawLine(50,50,50, 400);
        myCanvas.drawLine(50, 50, 550, 50); 
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(550, 400, 550, 50); 
       
       
        
    }}
}

        
        
    
        
    
        
    

