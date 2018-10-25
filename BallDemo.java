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
         * between five and thirty balls that move inside the box. It instantiates the BoxBall class.
         * 
         * There is an extra credit attempt to make the diameter of the balls from 10-25 pixels
         */
        public void boxBounce(){
            
        Random rand = new Random();
        //int ground = 400;
        myCanvas = new Canvas("Box", 700, 700);
        //create BoxBall objects array
        int numberOfBalls = rand.nextInt(30-5)+1+5; 
        BoxBall[] balls = new BoxBall[numberOfBalls];
        int counter = 0; 
         
        int leftWall = 30;
        int topWall = 30; 
        int rightWall = 550; 
        int bottomWall = 550; 
        
        myCanvas.drawLine(leftWall, bottomWall, rightWall, bottomWall); //left wall
        myCanvas.drawLine(leftWall, topWall, rightWall, topWall); //top
        myCanvas.drawLine(leftWall, topWall, leftWall, bottomWall); // bottom 
        myCanvas.drawLine(rightWall, topWall, rightWall, bottomWall); //right wall
        myCanvas.setVisible(true); // makes the canvas visible
        
        for(counter = 0; counter < balls.length; counter++) // randomizes the number of balls 
        {
        
         
         
         int xSpeed = rand.nextInt((7-2)+1)+2; // randomizes the x position speed for each ball
        
         int ySpeed = rand.nextInt((7-2)+1)+2; // randomizes y position speed for each ball
        
         int xPosition = ((80 - 10) + 1) + 10; // randomizes x position starting point 
        
         int yPosition = ((60 - 10) +1) + 10; // randomizes y position starting point
           
         int diameter = rand.nextInt(25-10)+1+10; //EXTRA CREDIT randomize the diameter of the ball from 10-25 pixels
         
         int ground = rand.nextInt(25-10)+1+10;
       
        int r = rand.nextInt((240-20)+1) + 20; // random int, which will be passed as the red value in rgb
        int g = rand.nextInt((240-20) +1) + 20; // random int, which will be passed as the green value in rgb
        int b = rand.nextInt((240-20) +1) + 20; // random int, which will be passed as the blue value in rgb
        Color color = new Color(r, g, b);  
        
        BoxBall ball = new BoxBall(xPosition, yPosition, diameter, color, ground, myCanvas, xSpeed, ySpeed,
        topWall, bottomWall, rightWall, leftWall);
        balls[counter] = ball; 
        balls[counter].draw(); 
        
    
        myCanvas.drawLine(leftWall, bottomWall, rightWall, bottomWall); //left wall
        myCanvas.drawLine(leftWall, topWall, rightWall, topWall); //top
        myCanvas.drawLine(leftWall, topWall, leftWall, bottomWall); // bottom 
        myCanvas.drawLine(rightWall, topWall, rightWall, bottomWall); //right wall
    }   
        
        boolean finished = false;
        while(!finished){
            for(int i = 0; i < balls.length; i++){
                myCanvas.wait(2);
                balls[i].move();
            }
            myCanvas.drawLine(leftWall, bottomWall, rightWall, bottomWall); //left wall
            myCanvas.drawLine(leftWall, topWall, rightWall, topWall); //top
            myCanvas.drawLine(leftWall, topWall, leftWall, topWall); // bottom 
            myCanvas.drawLine(rightWall, topWall, rightWall, bottomWall);
        }
        
    }}


        
        
    
        
    
        
    

