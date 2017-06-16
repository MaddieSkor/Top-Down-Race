import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Madison Skorbinsky
 * @author Maddy Thompson
 * @version 1.0
 */
public class Button extends Text
{
    //variable declaration
    private String  buttonKey;
    private boolean clicked;
    /**
     * Generates a button with text
     * @param buttonText text to be displayed
     * @param buttonKey key that activates button
     */
    public Button(String buttonText, String buttonKey) {
        super(buttonText);
        
        this.buttonKey = buttonKey;
        
        setClicked(false);
    }
    
    /**
     * Generates a button with text or a specific car as an image
     * @param buttonText text to be displayed
     * @param buttonKey key to activate the button
     * @param carNumber number corresponding to car image to display
     */
    public Button(String buttonText, String buttonKey, int carNumber) {
        //sets image to specified text and activation key to specified key
        super(buttonText);
        
        this.buttonKey  = buttonKey;
        //sets car image depending on car number input
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

        setClicked(false);
    }
    /**
     * @return if the button is clicked or not
     */
    public boolean getClicked() {
        return this.clicked;
    }
    /**
     * Sets the clicked status of the button
     * @param clicked status to set "clicked" variable to
     */
    private void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
      * Act - do whatever the Button wants to do. This method is called whenever
      * the 'Act' or 'Run' button gets pressed in the environment.
      */
    public void act() 
    {
        //if the button is clicked or the correct key is pressed, activate it
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown(this.buttonKey)) {
            setClicked(true);
        }
    }
}
