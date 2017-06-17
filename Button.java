import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for all buttons, extends basic text
 * 
 * @author (Maddison Skorbinski) 
 */
public class Button extends Text
{
    private String  buttonKey;
    private boolean clicked;

    public Button(String buttonText, String buttonKey) {
        super(buttonText);
        
        this.buttonKey = buttonKey;
        
        setClicked(false);
    }
    
    public Button(String buttonText, String buttonKey, int carNumber) {
	    super(buttonText);
	    
	    this.buttonKey  = buttonKey;
	    
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

    public boolean getClicked() {
        return this.clicked;
    }

    private void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
      * Act - do whatever the Button wants to do. This method is called whenever
      * the 'Act' or 'Run' button gets pressed in the environment.
      */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown(this.buttonKey)) {
            setClicked(true);
        }
    }
}
