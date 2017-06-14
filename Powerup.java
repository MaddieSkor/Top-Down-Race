import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Actor
{
    int imgSize = 30;
    int randNum;
    int points;
    boolean generated = false;
    Text text;
    public Powerup()
    {
        GreenfootImage image = new GreenfootImage(imgSize, imgSize);
        image.drawOval(0, 0, imgSize, imgSize);
        image.setColor(Color.BLACK);
        image.fillOval(0, 0, imgSize, imgSize);
        image.setColor(Color.WHITE);
        image.fillOval(1, 1, imgSize-2, imgSize-2);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!generated){
            randNum = Greenfoot.getRandomNumber(3);
            if (randNum == 0){
                points = 3;
            }
            else if (randNum == 1){
                points = 5;
            }
            else if (randNum == 2){
                points = 7;
            }
            text = new Text(Integer.toString(points));
            getWorld().addObject(text, getX(), getY());
            generated = true;
        }
    }    
    
    public int getPoints()
    {
        return points;
    }
    
    public void remove()
    {
        getWorld().removeObject(text);
        getWorld().removeObject(this);
    }
}
