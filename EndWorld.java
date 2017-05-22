import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends BaseWorld
{

    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(Integer score, Integer score2)
    {
        returnToStartButton = new Button("Return to Start", " ");
        addObject( returnToStartButton, 300, 200);  
        
        
        Text messageText = new Text("Score:" + score.toString());
        addObject( messageText, 300, 100);  
        
        if (score2 != null) {
            Text messageText2 = new Text("Score:" + score2.toString());
            addObject( messageText2, 300, 120);
        }
    }
    
    public void act()
    {
        if (returnToStartButton.getClicked()) {
            Greenfoot.setWorld(new StartWorld());
        }
    }
    
     private Button returnToStartButton;
}
