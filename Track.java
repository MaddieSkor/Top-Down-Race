import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends Actor
{
    public Track(int rotation)
    {
        setImage(new GreenfootImage("track.jpg"));
        setRotation(rotation);
    }
    
    public Track(int rotation, boolean straight){
        if (straight){
            setImage(new GreenfootImage("straight track.jpg"));
            setRotation(rotation);
        }
    }
    
    /**
     * Act - do whatever the track wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
