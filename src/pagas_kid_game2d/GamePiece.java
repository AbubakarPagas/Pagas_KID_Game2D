/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;

/**
 *
 * @author pagas
 */
public class GamePiece {
    private static final String FLAOR_OF_BAGEL = "Pumperinckel";    // Flavor (or type) of bagel
    private static final String SIZE_OF_BAGEL = "Mini Bagel";       //size (classification) of Bagel
    
    public int abubakarPagasX = 0;   // moving to the X direction
    public int abubakarPagasY = 0;  // moving to thr Y direction
    public String pagasOrientation = "side";  //oreintation side (front, side, top)
    public int lifeIndex = 1000;              //Define unite of lifespan
    public int hitsIndex = 0;                 //define of damage (hits take)
    public String directionFacing = "E";      //direction that the bagel object is facing 
    public String movementType = "idle";      // type of movment (idle, fly, run, jump)
    public boolean currentlyMoving = false;   //flag showing the  if the object is in motion
    
    // creating the piece constructor()
    GamePiece(){
        abubakarPagasX = 0;
        abubakarPagasY = 0;
        pagasOrientation = "side";
        lifeIndex = 1000;
        hitsIndex = 0;
        directionFacing = "E";
        movementType = "idle";
        currentlyMoving = false;
    }
    

    GamePiece(int x, int y, String orientation, int lifespan, String direction, String movement ){
        
        abubakarPagasX = x;
        abubakarPagasY = y;
        pagasOrientation = orientation;
        lifeIndex = lifespan;
        directionFacing = direction;
        movementType = movement;
        currentlyMoving = false;
    }
     // movement behavior
   public void moveInvinciBagel (int x, int y){
       currentlyMoving = true;
       abubakarPagasX = x;
       abubakarPagasY = y;
   }
   
   //Get method for orientation
   public String getInvinciBagelOrientation(){
       return pagasOrientation;
   }
   //set method for Orientation
   public void setInvinciBagelOrientation(String orientation){
       pagasOrientation = orientation;
   }
   //Get method for lifeSpan
   public int getInvinciBagelLifeIndex(){
       return lifeIndex;
   }
   //set method for lifespan
   public void setInvinciBagelLifeIndex(int lifespan ){
       lifeIndex = lifespan;
   }
   
   // get method for facing Direction 
   public String getInvinciBagelDirection(){
       return directionFacing;
   }
   //set method for facing Direction
   public void setInvinciBagelDirection(String direction){
       directionFacing = direction;
   }
   // get method for hit(damage)
   public int getInviciBagelHitsIndex(){
       return hitsIndex;
   }
   // set method for hit (damage)
   public void setInvinciBagelHitsIndex(int damage){
       hitsIndex = damage;
   }
   //Get method for movement jump , run , side, right, left,
   public String getInvinciBagelMovementType(){
       return movementType;
   }
   // set Method for movement jump , run , side, right, left,
   public void setInvinciBagelMovementType(String movement){
       movementType = movement;
   }
}

    

