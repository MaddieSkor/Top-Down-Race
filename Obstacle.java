import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author Connor Brunt 
 * @version 1.0
 */
public class Obstacle extends Actor
{
    /**
     * Generates an obstacle with a bomb image for the cars to avoid
     */
    public Obstacle()
    {
        //gets the preset image and scales it down so it fits better in the game
        GreenfootImage currentImage = getImage();
        currentImage.scale(20, 20);
        setImage(currentImage);
    }
    
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
