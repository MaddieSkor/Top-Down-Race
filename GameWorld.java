import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends BaseWorld
{
    int trackX = 100;
    int trackY = 200;
    int trackAngle = 0;
    int[] incArray = {0, 0, 3, 4, 7, 7, 9, 0};
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(int numberOfPlayers)
    {    
        car = new Car("w", "s", "a", "d");
        addObject(car, 300, 200);  
        if (numberOfPlayers == 2){
            car2 = new Car("i", "k", "j", "l");
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
        for (int i = 0; i < 3; i++){
            if (trackAngle == 0){
                trackY -= 20;
                addObject(new Track(trackAngle), trackX, trackY);
            }
            else if (trackAngle == 90){
                trackX += 20;
                addObject(new Track(trackAngle), trackX, trackY);
            }
            else if (trackAngle == 180){
                trackY += 20;
                addObject(new Track(trackAngle), trackX, trackY);
            }
            else if (trackAngle == 270){
                trackX -= 20;
                addObject(new Track(trackAngle), trackX, trackY);
            }
        }
    }
    
    public void right()
    {
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
    private Car car;
    private Car car2;
}
