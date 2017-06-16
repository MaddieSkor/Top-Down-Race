import java.io.*;

/**
 * Write a description of class HighScores here.
 * 
 * @author Madison Skorbinsky
 * @version 1.0
 */
public class HighScores  
{
    /**
     * constructor for highscores class, generates high score list
     */
    public HighScores()
    {
        //initializes list and fills it with 0 values
        this.scores = new int [10];
        for (int i=0; i< this.scores.length; i++){
            this.scores[i]=0;
        }
    }
    
    /**
     * Adds scores to highscore list
     * @param score score amount to be added to list
     */
    public void addScore(int score)
    {
        //adds score and sorts it to its proper place in the list
       int insertPoint = -1;
       for (int i=0; i< this.scores.length; i++){
            if (score > this.scores[i]){
                insertPoint=i;
                break;
            }                    
        }
       if (insertPoint != -1){
           for (int i= this.scores.length-1; i>insertPoint; i--){
               this.scores[i]=this.scores[i-1];
            }
           this.scores[insertPoint] = score;
        }   
    }
    
    /**
     * @return the high score list
     */
    public int[] getScores()
    {
        return this.scores;
    }
    
    /**
     * loads highscores from text file
     */
    public void load()
    {
        try {
            InputStream is = new FileInputStream("highscores.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            reader.close();
            
            String[] numbers = line.split(",");
            for (int i=0; i< numbers.length; i++){
                this.scores[i] = Integer.parseInt(numbers[i]);
            }
        } catch (Exception e) {
        }
    }
    
    /**
     * saves highscores to text file
     */
    public void save()
    {
        try {
            String line = "";
            for (int i=0; i< this.scores.length; i++){
                if (i > 0) {
                    line += ",";
                }
                line += new Integer(this.scores[i]).toString();
            }

            OutputStream os = new FileOutputStream("highscores.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(line);
            writer.close();
        } catch (Exception e) {
        }
    }
    //variable declaration
    private int[] scores;
    
}
