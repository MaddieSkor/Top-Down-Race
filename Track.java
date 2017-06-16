import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Track segments that are put together to make the racetrack.
 * 
 * @author Connor Brunt 
 * @version 1.0
 */
public class Track extends Actor
{
    //variable declaration
    int[] coords;
    int test;
    boolean generated = false;
    GameWorld currentWorld;
    /**
     * Generates a track piece with a specified rotation
     * @param rotation the rotation of the track in degrees (horizontal is 0, increases clockwise)
     */
    public Track(int rotation)
    {
        //initializes coords array and sets the image to a gray bar
        coords = new int[3];
        setImage(new GreenfootImage("track.jpg"));
        setRotation(rotation);
    }
    
    /**
     * Generates a track piece with a specified rotation, and if it is straight, adds black bars on wither side
     * @param rotation the rotation of the track in degrees (horizontal is 0, increases clockwise)
     * @param straight whether or not the track is straight
     */
    public Track(int rotation, boolean straight){
        //initializes coords array and sets image to track with black bars if it is straight
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
            //stores coordinates and track angle in coords array
            coords[0] = getX();
            coords[1] = getY();
            coords[2] = getRotation();
            //adds coords array to list of coords in GameWorld
            currentWorld = (GameWorld)getWorld();
            currentWorld.addCoords(coords);
            generated = true;
        }
    }    
}
