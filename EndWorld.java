import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends BaseWorld
{
    //Global Variables
     private Button returnToStartButton;
     private Button returnToStoreButton;
     public int score;
     public int finalScore;
     
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(Integer score, Integer score2)
    {
        finalScore = score;
        
        HighScores highscores = new HighScores();
        
        highscores.load();
        
        highscores.addScore(score);
         if (score2 != null) {
            highscores.addScore(score2);
        }
        highscores.save();

        returnToStartButton = new Button("Return to Start", " ");
        addObject( returnToStartButton, 300, 350);  
        
        returnToStoreButton = new Button("Go to the Store", " ");
        addObject( returnToStoreButton, 300, 400);  
        
        Text messageText = new Text("Player 1 Score:" + score.toString());
        addObject( messageText, 300, 40);  
        
        if (score2 != null) {
            Text messageText2 = new Text("Player 2 Score:" + score2.toString());
            addObject( messageText2, 300, 60);
        }
        
        int[] scores = highscores.getScores();
        for (int i=0; i<scores.length; i++){
            Text highscoreText = new Text(new Integer(i).toString() + ": " + new Integer(scores[i]).toString());
            addObject( highscoreText, 300, 100+(i*20));
        }
    }
    
    public void act()
    {
        if (returnToStartButton.getClicked()) {
            Greenfoot.setWorld(new StartWorld(finalScore));
        }
        if (returnToStoreButton.getClicked()) {
            Greenfoot.setWorld(new StoreWorld(finalScore));
        }
    }
}
