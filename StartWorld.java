import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the beginning screen for the game.  The user can select 1 or two players and is redirected to a new world depending on their selection.
 * 
 * @author (Maddy Thomson) 
 * @author (Madison Skorbinski) 
 */
public class StartWorld extends BaseWorld
{
    //Lists all buttons used in this world
    private Button startButton;
    private Button twoStartButton;
    
    //Global Variables
    int score;
    
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {  
        //Start Screen Text
        Text messageText = new Text("Main Menu", 80, false);
        addObject( messageText, 300, 75);  
        
        Text messageText1 = new Text("The goal is to stay alive for as long as possible", 30, false);
        addObject( messageText1, 300, 150); 
        
        Text messageText2 = new Text("Yes, the game will keep track :)", 30, false);
        addObject( messageText2, 300, 200);  
        
        //Single player and Mutiplayer buttons
        startButton = new Button("1 Player", "1");
        addObject( startButton, 200, 300);  
        
        twoStartButton = new Button("2 Players", "2");
        addObject(twoStartButton, 400, 300);
        
        setBackground(new GreenfootImage("sandstone.jpg"));
    }
    
    public StartWorld(int scoreIn)
    {   
        score = scoreIn;
        
        //Start Screen Text
        Text messageText = new Text("Main Menu", 80, false);
        addObject( messageText, 300, 75);  
        
        Text messageText1 = new Text("The goal is to stay alive for as long as possible", 30, false);
        addObject( messageText1, 300, 150); 
        
        Text messageText2 = new Text("Yes, the game will keep track :)", 30, false);
        addObject( messageText2, 300, 200);  
        
        //Single player and Mutiplayer buttons
        startButton = new Button("1 Player", "1");
        addObject( startButton, 200, 300);  
        
        twoStartButton = new Button("2 Players", "2");
        addObject(twoStartButton, 400, 300);
        
        setBackground(new GreenfootImage("sandstone.jpg"));
    }
    
    public void act()
    {
        //If user selects "Start", they will be sent to the store
        if (startButton.getClicked()) {
            Greenfoot.setWorld(new StoreWorld(score));
        }
        //If user selects "2 Players" they will be sent to the mutiplayer game
         if (twoStartButton.getClicked()) {
            Greenfoot.setWorld(new GameWorld(2, 1));
        } 
    }
}
