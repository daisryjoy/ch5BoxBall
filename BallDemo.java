import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
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
/*
    public void boxBounce(){
     //   BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, myCanvas );
       // ball.draw();
        
           while(true) {
            myCanvas.wait(50);           // small delay
         //   ball.move();
        }
    }
    */
    
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
        myCanvas = new Canvas("Box", 700, 700);
        //create BoxBall objects array
        int numberOfBalls = rand.nextInt(30-5+1)+5; 
        BoxBall[] balls = new BoxBall[numberOfBalls];
        
        
        myCanvas.drawLine(50,50,50, 400);
        myCanvas.drawLine(50, 50, 550, 50); 
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(550, 400, 550, 50); 
        myCanvas.setVisible(true); // makes the canvas visible
        
        for(int i = 0; i < balls.length; i++) // randomizes the number of balls 
        {
        //add new balls to the ArrayList with the random generated speed, position, and color
        balls[i] = new BoxBall();
    }
        
           
         //while loop keeps the balls moving. The balls will never stop bouncing. 
        for(int i = 0; i<balls.length; i++){
            balls[i].move(); 
        }
                
        //redraws canvas if chipped
        myCanvas.drawLine(50,50,50, 400);
        myCanvas.drawLine(50, 50, 550, 50); 
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(550, 400, 550, 50); 
       
       
        
    }
}
        
        
    
        
    
        
    

