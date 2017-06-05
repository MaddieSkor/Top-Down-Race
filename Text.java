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
    
    public Text(String text, int sizeIn, boolean background) {
        setText(text, sizeIn, background);
    }

    public void setText(String text) {
        if (this.text != text) {
            this.text = text;

            setImage(new GreenfootImage(this.text, 20, Color.WHITE, Color.BLACK));
        }
    }
    
    public void setText(String text, int sizeIn, boolean background) {
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
