import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
   	private String text;

	public Text(String text) {
        setText(text);
	}

    public void setText(String text) {
        if (this.text != text) {
            this.text = text;

            setImage(new GreenfootImage(this.text, 20, Color.WHITE, Color.BLACK));
        }
    }
}
