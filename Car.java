import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author Madison Skorbinski
 * @author Connor Brunt
 * @author Maddy Thompson
 * @version 1.0
 */
public class Car extends Actor
{
    public Car(String forwardKey, String backKey, String leftKey, String rightKey, int carNumber)
    {
        //variable initialization;
        this.forwardKey = forwardKey;
        this.backKey = backKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;   
        this.speed = 1;
        this.score = 0;
        this.out = false;
        //generates sounds
        accelerate = new GreenfootSound("accelerate.wav");
        brake = new GreenfootSound("brake.wav");
        explode = new GreenfootSound("Explosion.wav");
        powerup = new GreenfootSound("Powerup.wav");
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
        //scales the image and rotates the actor to the correct starting direction
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
        //variable initialization 
        final double MAX_SPEED    = 4.0;
        final double SPEED_CHANGE = 0.05;
        //accelerates the car and palys acceleration sound
        if (Greenfoot.isKeyDown(this.forwardKey)) {
            speed += SPEED_CHANGE;
            if (!accelerate.isPlaying()){
                accelerate.play();
            }
            if (speed > MAX_SPEED) {
                speed = MAX_SPEED;
                accelerate.stop();
            }
        }
        else{
            if (accelerate.isPlaying()){
                accelerate.stop();
            }
        }
        //decelerates the car and plays braking sound
        if (Greenfoot.isKeyDown(this.backKey)) {
            speed -= SPEED_CHANGE;
            if (!brake.isPlaying()){
                brake.play();
            }
            if (speed < 1) {
                speed = 1;
                brake.stop();
            }
        }
        else{
            if (brake.isPlaying()){
                brake.stop();
            }
        }
        
        //turn the car left or right
        if (Greenfoot.isKeyDown(this.leftKey)) {
            turn(-7);
        }
        
        if (Greenfoot.isKeyDown(this.rightKey)) {
            turn(7);
        } 
        //stops the car for 3 seconds at the beginning for the countdown
        if (!generated){
            if (currentTime == -1){
                currentTime = currentWorld.getTime();
            }
            if (currentWorld.getTime() - currentTime < 180){
                speed = 0;
                accelerate.stop();
                brake.stop();
            }
            else{
                generated = true;
            }
        }
        //move
        move((int)speed);
        //increases score
        if (generated){
            this.score++;
        }
        //if car hits a bomb or runs off track, destroy it
        if ((getOneIntersectingObject(Obstacle.class) != null || getOneIntersectingObject(Track.class) == null) && !destroyed){
            destroyed = true;
            currentTime = currentWorld.getTime();
            rotation = getRotation();
            explode.play();
            accelerate.setVolume(0);
        }
        //if the car is destroyed, set image to explosion and play explosion noise
        if (destroyed){
            imgWidth = getImage().getWidth();
            GreenfootImage explosion = new GreenfootImage("explosion.png");
            explosion.scale(imgWidth, imgWidth);
            setImage(explosion);
            speed = 0;
            setRotation(rotation);
            //remove destroyed car after 0.5s
            if (currentWorld.getTime() - currentTime > 30){
                this.out = true;
                brake.stop();
                accelerate.stop();
                currentWorld.removeObject(this);
                destroyed = false;
            }
        }
        //option to manually remove the car
        if (Greenfoot.isKeyDown("r")) {
            this.out = true;
        } 
        //if the car is still in the world, add powerup score when it hits one
        if (getWorld() != null){
            if (getOneIntersectingObject(Powerup.class) != null){
                powerup.play();
                Powerup powerup = (Powerup)getOneIntersectingObject(Powerup.class);
                this.score += 90*powerup.getPoints();
                powerup.remove();
            }
        }
    } 
    /**
     * @return whether or not the car is "out" (not in the world)
     */
    public  boolean isOut(){
        return this.out;
    }
    //variable declaration
    GameWorld currentWorld;
    public GreenfootSound explode;
    public GreenfootSound powerup;
    public GreenfootSound accelerate;
    public GreenfootSound brake;
    public double currentTime = -1;
    public boolean destroyed = false;
    public boolean generated = false;
    public int i = 0;
    public int rotation;
    private String forwardKey;
    private String backKey;
    private String leftKey;
    private String rightKey;
    private double speed = 1;
    public int imgWidth;
    public  int    score;
    private boolean out;
}
