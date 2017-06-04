import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends BaseWorld
{
    boolean rightTrack = true;
    boolean leftTrack = true;
    boolean straightTrack = true;
    
    int trackX = 100;
    int trackY = 180;
    int trackAngle = 0;
    int[] incArray = {0, 0, 3, 4, 7, 7, 9, 0};
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(int numberOfPlayers, int carNumber)
    {    
        makeTrack();
         if(numberOfPlayers == 1){
            car = new Car("w", "s", "a", "d", carNumber);
            addObject(car, 300, 200);
        }
        if (numberOfPlayers == 2){
            car = new Car("w", "s", "a", "d", 1);
            addObject(car, 300, 200);
            car2 = new Car("i", "k", "j", "l", 1);
            addObject(car2, 400, 200);
        } else {
            car2 = null;
        }
        
        
    }
    
    public void act(){
        if (car2 == null) {
            if (car.isOut()){
                Greenfoot.setWorld (new EndWorld(car.score, null));
            }
        } else {
              if (car.isOut() && car2.isOut()){
                Greenfoot.setWorld (new EndWorld(car.score, car2.score));
            }        
        } 
    }
    
    public void straight()
    {
        if (trackAngle == 360){
            trackAngle = 0;
        }
        
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
    
    public void makeTrack()
    {
        straight();
        right();
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
    
    public void endTrack()
    {
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
    private Car car;
    private Car car2;
}
