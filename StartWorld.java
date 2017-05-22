import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends BaseWorld
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {  
        startButton = new Button("Start", " ");
        addObject( startButton, 300, 200);  
        
        twoStartButton = new Button("2 Players", "2");
        addObject(twoStartButton, 300, 250);
        
        Text messageText = new Text("The goal is to stay alive for as long as possible. Yes, the game will keep track :)");
        addObject( messageText, 300, 100);  
    }
    
    public void act()
    {
        if (startButton.getClicked()) {
            Greenfoot.setWorld(new GameWorld(1));
        }
         if (twoStartButton.getClicked()) {
            Greenfoot.setWorld(new GameWorld(2));
        }  
    }
    
    private Button startButton;
    private Button twoStartButton;
}
