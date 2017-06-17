import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for all game worlds
 * 
 * @author Madison Skorbinski
 * @version 1.0
 */
public class BaseWorld extends World
{

    /**
     * Constructor f
     * or objects of class BaseWorld.
     * 
     * setting parameters for all the worlds
     */
    public BaseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1, false); 
    }
}
