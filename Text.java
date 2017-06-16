import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author Madison Skorbinsky
 * @author Maddy Thompson
 * @version 1.0
 */
public class Text extends Actor
{
    //variable declaration
    private String text;
    
    /**
     * sets text to input string
     * @param text string to set text to
     */
    public Text(String text) {
        setText(text);
    }
    
    /**
     * sets text to specified string, along with specified size and background
     * @param text string to set text to
     * @param sizeIn size of text
     * @param background whether or not the text has a background
     */
    public Text(String text, int sizeIn, boolean background) {
        setText(text, sizeIn, background);
    }
    
    /**
     * sets the text to a specified string once
     * @param text string for text to be set to
     */
    public void setText(String text) {
        //if the text isn't already set, set it to the specified string
        if (this.text != text) {
            this.text = text;

            setImage(new GreenfootImage(this.text, 20, Color.WHITE, Color.BLACK));
        }
    }
    
    /**
     * sets the text to the specified string, size, and background once
     * @param text string to set text to
     * @param sizeIn size of text
     * @param background whether or not the text has a background
     */
    public void setText(String text, int sizeIn, boolean background) {
        //if the text isn't already set, set it to the specified string and size, and with a background or not
        if (this.text != text) {
            this.text = text;
            if(background == false){
                setImage(new GreenfootImage(this.text, sizeIn, Color.BLACK, new Color(0,0,0,0)));
            }else if(background == true){
                setImage(new GreenfootImage(this.text, sizeIn, Color.WHITE, Color.BLACK));
            }
        }
    }
}
