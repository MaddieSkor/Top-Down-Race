import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author Maddy Thomson
 * @author Madison Skorbinski
 * @version 1.0
 */
public class EndWorld extends BaseWorld
{
    //List of all buttons used in this world
    private Button returnToStartButton;
    private Button returnToStoreButton;
    
    //Global Variables
    public int score;
    public int finalScore;
    public boolean player2;
     
    /**
     * Constructor for objects of class EndWorld.
     * @param score The first score to be displayed
     * @param score2 The second score (if any) to be displayed
     */
    public EndWorld(Integer score, Integer score2)
    {
        //sets score variables and determines if there was a second player
        finalScore = score;
        if(score2 != null){
            player2 = true;
        }else{
            player2 = false;
        }
        //loads and adds the inputted scores to the high scores list
        HighScores highscores = new HighScores();
        
        highscores.load();
        
        highscores.addScore(score);
         if (score2 != null) {
            highscores.addScore(score2);
        }
        highscores.save();
        //adds buttons for return to start and score
        returnToStartButton = new Button("Return to Start", " ");
        addObject( returnToStartButton, 300, 350);  
        
        if(score2 == null){
            returnToStoreButton = new Button("Go to the Store", " ");
            addObject( returnToStoreButton, 300, 400);  
        }
        //displays scores for player 1 and 2
        Text messageText = new Text("Player 1 Score: " + finalScore);
        addObject( messageText, 300, 40);  
        
        if (score2 != null) {
            Text messageText2 = new Text("Player 2 Score: " + score2);
            addObject( messageText2, 300, 60);
        }
        
        //displays high scores
        int[] scores = highscores.getScores();
        for (int i=0; i<scores.length; i++){
            Text highscoreText = new Text(new Integer(i+1).toString() + ": " + new Integer(scores[i]).toString());
            addObject( highscoreText, 300, 100+(i*20));
        }
    }
    
    /**
     * Act - do whatever the EndWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //goes to the correct world depending on clicked button
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
