import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends BaseWorld
{
    
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
private Car car;
private Car car2;
}
