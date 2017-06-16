import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author Maddy Thompson
 * @author Madison Skorbinsky
 * @version 1.0
 */
public class EndWorld extends BaseWorld
{
    //Global Variables
     private Button returnToStartButton;
     private Button returnToStoreButton;
     public int score;
     public int finalScore;
     public boolean player2;
     
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(Integer score, Integer score2)
    {
        finalScore = score;
        if(score2 != null){
            player2 = true;
        }else{
            player2 = false;
        }
        HighScores highscores = new HighScores();
        
        highscores.load();
        
        highscores.addScore(score);
         if (score2 != null) {
            highscores.addScore(score2);
        }
        highscores.save();

        returnToStartButton = new Button("Return to Start", " ");
        addObject( returnToStartButton, 300, 350);  
        
        if(score2 == null){
            returnToStoreButton = new Button("Go to the Store", " ");
            addObject( returnToStoreButton, 300, 400);  
        }
        
        Text messageText = new Text("Player 1 Score: " + finalScore);
        addObject( messageText, 300, 40);  
        
        if (score2 != null) {
            Text messageText2 = new Text("Player 2 Score: " + score2);
            addObject( messageText2, 300, 60);
        }
        
        int[] scores = highscores.getScores();
        for (int i=0; i<scores.length; i++){
            Text highscoreText = new Text(new Integer(i+1).toString() + ": " + new Integer(scores[i]).toString());
            addObject( highscoreText, 300, 100+(i*20));
        }
    }
    
    public void act()
    {
        if (returnToStartButton.getClicked()) {
            Greenfoot.setWorld(new StartWorld(finalScore));
        }
        if(player2 == false){
            if (returnToStoreButton.getClicked()) {
                Greenfoot.setWorld(new StoreWorld(finalScore));
            }
        }
   }
}
