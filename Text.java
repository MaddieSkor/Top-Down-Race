import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class designs all the text used in the game.
 * 
 * @author (Madison Skorbinski) 
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
    //setting text for worlds
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
