import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends Actor
{
    int[] coords;
    int test;
    boolean generated = false;
    GameWorld currentWorld;
    public Track(int rotation)
    {
        coords = new int[3];
        setImage(new GreenfootImage("track.jpg"));
        setRotation(rotation);
    }
    
    public Track(int rotation, boolean straight){
        coords = new int[3];
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
        if (!generated){
            coords[0] = getX();
            coords[1] = getY();
            coords[2] = getRotation();
            currentWorld = (GameWorld)getWorld();
            currentWorld.addCoords(coords);
            generated = true;
        }
    }    
}
