import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
      public Car(String forwardKey, String backKey, String leftKey, String rightKey)
    {
        this.forwardKey = forwardKey;
        this.backKey = backKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;   
        this.speed = 0.0;
        this.score = 0;
        this.out = false;
    }
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
           super.act();

        //move 
        final double MAX_SPEED    = 3.0;
        final double SPEED_CHANGE = 0.1;

        if (Greenfoot.isKeyDown(this.forwardKey)) {
            System.out.println("The " + this.forwardKey + " key was pressed");
            speed += SPEED_CHANGE;
            if (speed > MAX_SPEED) {
                speed = MAX_SPEED;
            }
        }

        if (Greenfoot.isKeyDown(this.backKey)) {
            System.out.println("The "+ this.backKey +" key was pressed");
            speed -= SPEED_CHANGE;
            if (speed < -MAX_SPEED) {
                speed = -MAX_SPEED;
            }
        }
        
        //turn 
        if (Greenfoot.isKeyDown(this.leftKey)) {
            System.out.println("The "+ this.leftKey +" key was pressed");
            turn(-1);
        }
        
        if (Greenfoot.isKeyDown(this.rightKey)) {
            System.out.println("The "+ this.rightKey +" key was pressed");
            turn(1);
        } 
        move((int)speed);

        if (Greenfoot.isKeyDown("r")) {
            this.out = true;
        } 
    }    
    public  boolean isOut(){
        return this.out;
    }
    private String forwardKey;
    private String backKey;
    private String leftKey;
    private String rightKey;
    private double speed;
    public  int    score;
    private boolean out;
}
