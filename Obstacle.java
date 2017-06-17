import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Obstacles appear as a bomb randomly on the track
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
}
