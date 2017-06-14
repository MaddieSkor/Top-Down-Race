import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
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
            getImage().scale(75, 40);
        }
        if(carNumber == 2){
            setImage("bluecar.png");
            getImage().scale(75, 40);
        }
        if(carNumber == 3){
            setImage("greycar.png");
            getImage().scale(75, 40);
        }
        if(carNumber == 4){
            setImage("classyredcar.png");
            getImage().scale(75, 40);
        }
        if(carNumber == 5){
            setImage("herbie.png");
            getImage().scale(75, 40);
        }
        if(carNumber == 6){
            setImage("mysterymachine.png");
            getImage().scale(85, 50);
        }
        if(carNumber == 7){
            setImage("policecar.png");
            getImage().scale(85, 90);
        }
        if(carNumber == 8){
            setImage("taxi.png");
            getImage().scale(75, 40);
        }
        if(carNumber == 9){
            setImage("yellowcar.png");
            getImage().scale(75, 25);
        }
        if(carNumber == 10){
            setImage("whitecar.png");
            getImage().scale(75, 40);
        }
        
        GreenfootImage currentImage = getImage();
        currentImage.scale((int)(currentImage.getWidth()*0.5), (int)(currentImage.getHeight()*0.5));
        setImage(currentImage);
        setRotation(-90);
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        currentWorld = (GameWorld)getWorld();
        //move 
        final double MAX_SPEED    = 3.0;
        final double SPEED_CHANGE = 0.1;

        if (Greenfoot.isKeyDown(this.forwardKey)) {
            speed += SPEED_CHANGE;
            if (speed > MAX_SPEED) {
                speed = MAX_SPEED;
            }
        }

        if (Greenfoot.isKeyDown(this.backKey)) {
            speed -= SPEED_CHANGE;
            if (speed < -MAX_SPEED) {
                speed = -MAX_SPEED;
            }
        }
        
        //turn 
        if (Greenfoot.isKeyDown(this.leftKey)) {
            turn(-7);
        }
        
        if (Greenfoot.isKeyDown(this.rightKey)) {
            turn(7);
        } 
        move((int)speed);
        this.score++;
        
        if ((getOneIntersectingObject(Obstacle.class) != null || getOneIntersectingObject(Track.class) == null) && !destroyed){
            destroyed = true;
            currentTime = currentWorld.getTime();
            rotation = getRotation();
        }
        if (destroyed){
            imgWidth = getImage().getWidth();
            GreenfootImage explosion = new GreenfootImage("explosion.png");
            explosion.scale(imgWidth, imgWidth);
            setImage(explosion);
            speed = 0;
            setRotation(rotation);
            if (currentWorld.getTime() - currentTime > 30){
                this.out = true;
                currentWorld.removeObject(this);
                destroyed = false;
            }
        }
        
        if (Greenfoot.isKeyDown("r")) {
            this.out = true;
        } 
        
        if (getWorld() != null){
            
            if (getOneIntersectingObject(Powerup.class) != null){
                Powerup powerup = (Powerup)getOneIntersectingObject(Powerup.class);
                this.score += 90*powerup.getPoints();
                powerup.remove();
            }
        }
    } 
    
    public  boolean isOut(){
        return this.out;
    }
    GameWorld currentWorld;
    public double currentTime;
    public boolean destroyed = false;
    public int i = 0;
    public int rotation;
    private String forwardKey;
    private String backKey;
    private String leftKey;
    private String rightKey;
    private double speed;
    public int imgWidth;
    public  int    score;
    private boolean out;
}
