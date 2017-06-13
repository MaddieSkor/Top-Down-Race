import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    //Global Variables
    int carNumber;
    
    private String forwardKey;
    private String backKey;
    private String leftKey;
    private String rightKey;
    private double speed;
    public  int    score;
    private boolean out;
    
    public Car(String forwardKey, String backKey, String leftKey, String rightKey, int carNumber)
    {
        this.forwardKey = forwardKey;
        this.backKey = backKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;   
        this.speed = 0.0;
        this.score = 0;
        this.out = false;
        
        //changes car image to match the car that was chosen at the store
        if(carNumber == 1){
            setImage("redcar.png");
            getImage().scale(55, 25);
        }
        if(carNumber == 2){
            setImage("bluecar.png");
            getImage().scale(55, 25);
        }
        if(carNumber == 3){
            setImage("greycar.png");
            getImage().scale(55, 25);
        }
        if(carNumber == 4){
            setImage("classyredcar.png");
            getImage().scale(55, 25);
        }
        if(carNumber == 5){
            setImage("herbie.png");
            getImage().scale(55, 25);
            Greenfoot.playSound("herbie.mp3");
        }
        if(carNumber == 6){
            setImage("mysterymachine.png");
            getImage().scale(65, 35);
        }
        if(carNumber == 7){
            setImage("policecar.png");
            getImage().scale(55, 60);
            Greenfoot.playSound("siren.mp3");
        }
        if(carNumber == 8){
            setImage("taxi.png");
            getImage().scale(55, 25);
        }
        if(carNumber == 9){
            setImage("yellowcar.png");
            getImage().scale(45, 15);
        }
        if(carNumber == 10){
            setImage("whitecar.png");
            getImage().scale(50, 25);
        }
        
        GreenfootImage currentImage = getImage();
        currentImage.scale((int)(currentImage.getWidth()*0.5), (int)(currentImage.getHeight()*0.5));
        setImage(currentImage);
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

        score = score + 1;
        
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
            turn(-7);
        }
        
        if (Greenfoot.isKeyDown(this.rightKey)) {
            System.out.println("The "+ this.rightKey +" key was pressed");
            turn(7);
        } 
        move((int)speed);
        if (Greenfoot.isKeyDown("r")) {
            this.out = true;
        } 
    }    
    public  boolean isOut(){
        return this.out;
    }
}
