import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Text
{
    private String  buttonKey;
   	private boolean clicked;

	public Button(String buttonText, String buttonKey) {
	    super(buttonText);
	    
		this.buttonKey  = buttonKey;

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
