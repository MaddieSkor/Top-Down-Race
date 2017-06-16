import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * In this world, the user has an option to use the points that they have earned in the game to purchase new cars with different features.
 * 
 * @author Maddy Thomson 
 * @version 1.0
 */
public class StoreWorld extends BaseWorld
{
    //List of all buttons in this world
    public Button redCar;
    public Button blueCar;
    public Button greyCar;
    public Button classyRedCar;
    public Button whiteCar;
    public Button mysteryMachine;
    public Button policeCar;
    public Button taxi;
    public Button yellowCar;
    public Button herbie;
    
    //Global Variables
    public int carNumber = 1;
    public int score;
    
    /**
     * Constructor for objects of class StoreWorld.
     * 
     */
    public StoreWorld(int scoreIn)
    {
        //sets score equal to the input score
        score = scoreIn;
        
        //welcome message
        Text messageText = new Text("Welcome to the Store!", 30, false);
        addObject( messageText, 300, 50);  
        Text messageText2 = new Text("Use your points to make purchases!",30, false);
        addObject( messageText2, 300, 75);  
        
        //car option 1
        redCar = new Button("", "1", 1);
        addObject(redCar, 115, 150);
        Text costText = new Text("0 Points", 20, false);
        addObject(costText, 115, 200);
        
        //car option 2
        blueCar = new Button("", "2", 2);
        addObject(blueCar, 215, 150);
        Text costText2 = new Text("10 Points", 20, false);
        addObject(costText2, 215, 200);
        
        //car option 3
        greyCar = new Button("", "3", 3);
        addObject(greyCar, 315, 150);
        Text costText3 = new Text("20 Points", 20, false);
        addObject(costText3, 315, 200);  
        
        //car option 4
        classyRedCar = new Button("", "4", 4);
        addObject(classyRedCar, 415, 150);
        Text costText4 = new Text("30 Points", 20, false);
        addObject(costText4, 415, 200);  
        
        //car option 5
        herbie = new Button("", "5", 5);
        addObject(herbie, 515, 150);
        Text costText5 = new Text("40 Points", 20, false);
        addObject(costText5, 515, 200);
        
        //car option 6
        mysteryMachine = new Button("", "6", 6);
        addObject(mysteryMachine, 115, 300);
        Text costText6 = new Text("50 Points", 20, false);
        addObject(costText6, 115, 350);
        
        //car option 7
        policeCar = new Button("", "7", 7);
        addObject(policeCar, 215, 300);
        Text costText7 = new Text("60 Points", 20, false);
        addObject(costText7, 215, 350);
        
        //car option 8
        taxi = new Button("", "8", 8);
        addObject(taxi, 315, 300);
        Text costText8 = new Text("70 Points", 20, false);
        addObject(costText8, 315, 350);
        
        //car option 9
        yellowCar = new Button("", "9", 9);
        addObject(yellowCar, 415, 300);
        Text costText9 = new Text("80 Points", 20, false);
        addObject(costText9, 415, 350); 
        
        //car option 10
        whiteCar = new Button("", "0", 10);
        addObject(whiteCar, 515, 300);
        Text costText10 = new Text("90 Points", 20, false);
        addObject(costText10, 515, 350); 
        
        //Display the players score
        Text scoreText = new Text("Score: " + score + " Points", 25, false);
        addObject(scoreText, 300, 425);  
    }
    
    /**
     * Act - do whatever the StoreWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        //when a car is clicked, it send the user to the game world using the car that they chose if they have enough points
        if(redCar.getClicked()){
                  Greenfoot.setWorld(new GameWorld(1, 1));
        }
        if(score >= 10){
            if(blueCar.getClicked()){
                      Greenfoot.setWorld(new GameWorld(1, 2));
            }
            if(score >= 20){
                if(greyCar.getClicked()){
                          Greenfoot.setWorld(new GameWorld(1, 3));
                }
                if(score >=  30){
                    if(classyRedCar.getClicked()){
                              Greenfoot.setWorld(new GameWorld(1, 4));
                    }
                    if(score >= 40){
                        if(herbie.getClicked()){
                                  Greenfoot.setWorld(new GameWorld(1, 5));
                        }
                        if(score >= 50){
                            if(mysteryMachine.getClicked()){
                                          Greenfoot.setWorld(new GameWorld(1, 6));
                            }
                            if(score >= 60){
                                if(policeCar.getClicked()){
                                          Greenfoot.setWorld(new GameWorld(1, 7));
                                }
                                if(score >= 70){
                                    if(taxi.getClicked()){
                                              Greenfoot.setWorld(new GameWorld(1, 8));
                                    }
                                    if(score >= 80){
                                        if(yellowCar.getClicked()){
                                                  Greenfoot.setWorld(new GameWorld(1, 9));
                                        }
                                        if(score >= 90){
                                            if(whiteCar.getClicked()){
                                                      Greenfoot.setWorld(new GameWorld(1, 10));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
