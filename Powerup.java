import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author Connor Brunt
 * @version 1.0
 */
public class Powerup extends Actor
{
    //variable declaration
    int imgSize = 30;
    int randNum;
    int points;
    boolean generated = false;
    Text text;
    /**
     * generates a blank powerup
     */
    public Powerup()
    {
        //sets the image to a white circle with a black border
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
        //adds a 3, 5, or 7 point value to the powerup
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
    
    /**
     * @return the amount of points that the powerup is worth
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Removes the powerup
     */
    public void remove()
    {
        getWorld().removeObject(text);
        getWorld().removeObject(this);
    }
}
