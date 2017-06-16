import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Write a description of class GameWorld here.
 * 
 * @author Connor Brunt
 * @author Madison Skorbinsky
 * @version 1.0
 */
public class GameWorld extends BaseWorld
{
    //variable declaration
    boolean rightTrack = true;
    boolean leftTrack = true;
    boolean straightTrack = true;
    
    int trackX = 100;
    int trackY = 180;
    int trackAngle = 0;
    int score1;
    int score2;
    int randNum;
    int[] incArray = {0, 0, 3, 4, 7, 7, 9, 0};

    int[] trackInfo;
    int[] trackInfo2;
    double gameTime = 0;
    double currentTime = 0;
    ArrayList<int[]> trackCoords = new ArrayList<int[]>();
    
    /**
     * Constructor for objects of class GameWorld.
     * @param numberOfPlayers the number of palyers in the game
     * @param carNumber the car type to be used for the cars in the game
     */
    public GameWorld(int numberOfPlayers, int carNumber)
    {    
        //generates track
        makeTrack();
        score1 = 0;
        score2 = 0;
        //generates cars based on number of players
         if(numberOfPlayers == 1){
            car = new Car("w", "s", "a", "d", carNumber);
            addObject(car, 100, 180);
        }
        if (numberOfPlayers == 2){
            car = new Car("w", "s", "a", "d", 1);
            addObject(car, 80, 180);
            car2 = new Car("i", "k", "j", "l", 1);
            addObject(car2, 120, 180);
            score2 = 0;
        } else {
            car2 = null;
        }
    }
    
    /**
     * Act - do whatever the GameWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        //displays countdown timer at beginning of game
        gameTime++;
        if (gameTime < 60){
            showText("3", 300, 225);
        }
        else if (gameTime < 120){
            showText("2", 300, 225);
        }
        else if (gameTime < 180){
            showText("1", 300, 225);
        }
        else{
            showText("", 300, 225);
        }
        //adds and displays score for all players on screen
        if (car2 == null){
            score1 = car.score/60;
            showText("Score: " + score1 + " Points", 300, 425);
        }
        else{
            if (car.isOut()){
                score2 = car2.score/60;
                showText("", 150, 425);
                showText("", 450, 425);
                showText("Player 2 Score: " + score2 + " Points", 300, 425);
            }
            else if (car2.isOut()){
                score1 = car.score/60;
                showText("", 150, 425);
                showText("", 450, 425);
                showText("Player 1 Score: " + score1 + " Points", 300, 425);
            }
            else{
                score1 = car.score/60;
                score2 = car2.score/60;
                showText("Player 1 Score: " + score1 + " Points", 150, 425);
                showText("Player 2 Score: " + score2 + " Points", 450, 425);
            }
        }
        //every 8 seconds or so, spawns an obstacle and a powerup
        if (gameTime - currentTime > 500){
            randNum = Greenfoot.getRandomNumber(trackCoords.size());
            
            trackInfo = trackCoords.get(randNum);
            //ensures the powerup doesn't spawn on top of an obstacle
            if (randNum < trackCoords.size() - 10){
                trackInfo2 = trackCoords.get(randNum + 10);
            }

            else{
                trackInfo2 = trackCoords.get(0);
            }
            //ensures the obstacle doesn;t spawn on top of a car
            if (!car.isOut()){
                while (Math.abs(trackInfo[0] - car.getX()) < 70 && Math.abs(trackInfo[1] - car.getY()) < 70){

                    if (randNum < trackCoords.size() - 1){
                        randNum++;
                    }
                    else{
                        randNum = 0;
                    }
                    trackInfo = trackCoords.get(randNum);
                }
            }
            if(car2 != null){
                if (!car2.isOut()){
                        while (Math.abs(trackInfo[0] - car2.getX()) < 70 && Math.abs(trackInfo[1] - car2.getY()) < 70){
                        if (randNum < trackCoords.size() - 1){
                            randNum++;
                        }
                        else{
                            randNum = 0;
                        }
                        trackInfo = trackCoords.get(randNum);
                    }
                }
            }
            
            //deploys an obstacle on a chosen track piece, and slides it along said piece so that not all obstacles are in the middle
            if (trackInfo[2] == 0 || trackInfo[2] == 180){
                    addObject(new Obstacle(), trackInfo[0] + Greenfoot.getRandomNumber(71)-35, trackInfo[1]);
            }
            else if (trackInfo[2] == 90 || trackInfo[2] == 270){
                addObject(new Obstacle(), trackInfo[0], trackInfo[1] + Greenfoot.getRandomNumber(71)-35);
            }
            else{
                addObject(new Obstacle(), trackInfo[0], trackInfo[1]);
            }
            addObject(new Powerup(), trackInfo2[0], trackInfo2[1]);
    
            currentTime = gameTime;
        }
        //if the cars are destroyed, go to end screen
        if (car2 == null) {
            if (car.isOut()){
                Greenfoot.setWorld (new EndWorld(score1, null));
            }
        } 
        else {
              if (car.isOut() && car2.isOut()){
                Greenfoot.setWorld (new EndWorld(score1, score2));
            }        
        } 
        
    }
    
    /**
     * Generates a straight section of track
     */
    public void straight()
    {
        if (trackAngle == 360){
            trackAngle = 0;
        }
        //generates 4 track pieces in a line
        for (int i = 0; i < 4; i++){
            if (trackAngle == 0){
                trackY -= 20;
                addObject(new Track(trackAngle, true), trackX, trackY);
            }
            else if (trackAngle == 90){
                trackX += 20;
                addObject(new Track(trackAngle, true), trackX, trackY);
            }
            else if (trackAngle == 180){
                trackY += 20;
                addObject(new Track(trackAngle, true), trackX, trackY);
            }
            else if (trackAngle == 270){
                trackX -= 20;
                addObject(new Track(trackAngle, true), trackX, trackY);
            }
        }
    }
    
    /**
     * Generates a right turn in the track
     */
    public void right()
    {
        if (trackAngle == 360){
            trackAngle = 0;
        }

        if (trackAngle == 0){
            trackY -= 20;
        }
        else if (trackAngle ==  90){
            trackX += 20;
        }
        else if (trackAngle == 180){
            trackY += 20;
        }
        else if (trackAngle == 270){
            trackX -= 20;
        }
        //generates a right turn in the track
        for (int i = 0; i < 7; i++){
            if (trackAngle == 0){
                trackX += incArray[i];
                trackY -= incArray[incArray.length - 1 - i];
            }
            else if (trackAngle == 90){
                trackX += incArray[incArray.length - 1 - i];
                trackY += incArray[i];
            }
            else if (trackAngle == 180){
                trackX -= incArray[i];
                trackY += incArray[incArray.length - 1 - i];
            }
            else if(trackAngle == 270){
                trackX -= incArray[incArray.length - 1 - i];
                trackY -= incArray[i];
            }
            addObject(new Track(trackAngle + i*15), trackX, trackY);
        }
        trackAngle += 90;
    }
    
    /**
     * Generates a left turn in the track
     */
    public void left()
    {
        if (trackAngle == 360){
            trackAngle = 0;
        }
        
        if (trackAngle == 0){
            trackY -= 20;
        }
        else if (trackAngle ==  90){
            trackX += 20;
        }
        else if (trackAngle == 180){
            trackY += 20;
        }
        else if (trackAngle == 270){
            trackX -= 20;
        }
        //generates a left turn in the track
        for (int i = 0; i < 7; i++){
            if (trackAngle == 0){
                trackX -= incArray[i];
                trackY -= incArray[incArray.length - 1 - i];
            }
            else if (trackAngle == 90){
                trackX += incArray[incArray.length - 1 - i];
                trackY -= incArray[i];
            }
            else if (trackAngle == 180){
                trackX += incArray[i];
                trackY += incArray[incArray.length - 1 - i];
            }
            else if(trackAngle == 270){
                trackX -= incArray[incArray.length - 1 - i];
                trackY += incArray[i];
            }
            addObject(new Track(trackAngle - i*15), trackX, trackY);
        }
        trackAngle -= 90;
    }
    
    /**
     * Randomly generates a track
     */
    public void makeTrack()
    {
        straight();
        right();
        //checks certain aspects of where the track is being placed to determine what track pieces are viable
        while (trackX < 450){
            double randNum = Math.random();
            if (trackY == 100 || trackY >= 240){
                straightTrack = false;
            }
            if (trackAngle == 0 || trackY < 80){
                leftTrack = false;
            }
            if (trackAngle == 180 || trackY >= 240){
                rightTrack = false;
            }
            
            if (!straightTrack){
                if (!leftTrack){
                    right();
                }
                else if (!rightTrack){
                    left();
                }
                else{
                    if (randNum > 0.5){
                        left();
                    }
                        else{
                        right();
                    }
                }
            }
            else if (!leftTrack){
                if (!rightTrack){
                    straight();
                }
                else if (!straightTrack){
                    right();
                }
                else{
                    if (randNum > 0.5){
                        straight();
                    }
                        else{
                        right();
                    }
                }
            }
            else if (!rightTrack){
                if (!straightTrack){
                    left();
                }
                else if (!leftTrack){
                    straight();
                }
                else{
                    if (randNum > 0.5){
                        straight();
                    }
                        else{
                        left();
                    }
                }
            }
            else if (straightTrack && leftTrack && rightTrack){
                if (randNum < 1 && randNum >= (2.0/3)){
                    right();
                }
                else if (randNum < (2.0/3) && randNum >= (1.0/3)){
                    left();
                }
                else if (randNum < (1.0/3)){
                    straight();
                }
            }
            rightTrack = true;
            leftTrack = true;
            straightTrack = true;
        }
        endTrack();
    }
    
    /**
     * Returns the track to the beginning after being generated
     */
    public void endTrack()
    {
        //turns the track down and back around to the beginning
        right();
        while (trackY < 290){
            straight();
        }
        right();
        for (int i = 0; i < 4; i++){
            straight();
        }
        right();
        straight();
        straight();
    }
    
    /**
     * Adds an array of coordinates to the list of coordinate arrays
     * @param coordsIn The coordinates to be added
     */
    public void addCoords(int[] coordsIn)
    {
        trackCoords.add(coordsIn); 
    }
    
    /**
     * @return the list of coordinates in use by the GameWorld
     */
    public ArrayList<int[]> getCoords()
    {
        return trackCoords;
    }
    
    /**
     * @return the current game time
     */
    public double getTime()
    {
        return gameTime;
    }
    //variable declaration
    private Car car;
    private Car car2;
}
