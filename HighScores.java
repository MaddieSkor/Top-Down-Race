import java.io.*;

/**
 * Write a description of class HighScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScores  
{
    public HighScores()
    {
        this.scores = new int [10];
        for (int i=0; i< this.scores.length; i++){
            this.scores[i]=0;
        }
    }

    public void addScore(int score)
    {
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
    
    public int[] getScores()
    {
        return this.scores;
    }
    
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
    
    private int[] scores;
    
}
