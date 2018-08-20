/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;


import static pagas_kid_game2d.Pagas_KID_Game2D.HEIGHT;
import static pagas_kid_game2d.Pagas_KID_Game2D.WIDTH;
import javafx.scene.image.Image;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
// * @author pagas
 */
public class Pagas extends Hero {
    
    protected static final double SPRITE_PIXELS_X = 81;
    protected static final double SPRITE_PIXELS_Y = 81;
    protected static final double rightBoundary = WIDTH - SPRITE_PIXELS_X;
    protected static final double leftBoundary = 0;
    protected static final double bottomBoundary = HEIGHT - SPRITE_PIXELS_Y;
    protected static final double topBoundary = 0;
    protected Pagas_KID_Game2D pagas_kid_game2d;
    private byte framecounter = 0;
    private byte runningspeed = 6;
    
    private boolean animator = false;
    

    public Pagas(Pagas_KID_Game2D ipagas, String SVGdata, double xLocation, double yLocation, Image... spriteCels) {
        super(SVGdata, xLocation, yLocation, spriteCels);
        this.pagas_kid_game2d = ipagas;
    }

    @Override
    public void update() {
       setXYlocation();
        setBoundaries();
        movePagas_KID_Game2D(iX, iY);
        setImageState();
       checkCollision(); 
      

    }
    
    @Override
    public boolean collide(Actor object) {
        boolean collisionDetect = false;
        
        if(pagas_kid_game2d.ipagas.spriteFrame.getBoundsInParent().intersects(object.getSpriteFrame().getBoundsInParent())) {
            Shape intersection = SVGPath.intersect(pagas_kid_game2d.ipagas.getSpriteBound(), object.getSpriteBound());
            if(intersection.getBoundsInLocal().getWidth() != -1) {
                collisionDetect = true;
            }
        }
        
        return collisionDetect;
    }

    private void setXYlocation() {

        if (pagas_kid_game2d.isRight()){ iX += vX * 2; }
          if (pagas_kid_game2d.isLeft()){ iX -= vX * 2; }
            if (pagas_kid_game2d.isDown()){ iY += vY * 2; }
              if (pagas_kid_game2d.isUp()){ iY -= vY * 2; }
            
        
    }

    private void setBoundaries() {

      if (iX > rightBoundary) { iX = rightBoundary; }
        if (iX < leftBoundary) { iX = leftBoundary; }
        if (iY > bottomBoundary) { iY = bottomBoundary; }
        if (iY < topBoundary) { iY = topBoundary; }

        
    }

    private void movePagas_KID_Game2D(double x, double y) {

        spriteFrame.setTranslateX(x);
        spriteFrame.setTranslateY(y);
    }

    private void setImageState() {

        // for the idiel animation conner
        if (!pagas_kid_game2d.isDown() && 
                !pagas_kid_game2d.isUp() && 
                !pagas_kid_game2d.isRight() && 
                !pagas_kid_game2d.isLeft()){
            spriteFrame.setImage(imageState.get(0));
           animator = false;
        }
        // for the right bottom coner 
        if(pagas_kid_game2d.isRight()){
            spriteFrame.setScaleX(1);
            this.setIsFlipH(false);
            if (!pagas_kid_game2d.isUp() && !pagas_kid_game2d.isDown()){
                if (animator){
                    spriteFrame.setImage(imageState.get(2));
                    
                }else{
                    spriteFrame.setImage(imageState.get(1));
                }
                if (framecounter >= runningspeed){
                    animator = !animator;
                    framecounter = 0;
                } else{
                    framecounter += 1;
                }
                
            }
        }
        // for the left bottom 
        if (pagas_kid_game2d.isLeft()){
            spriteFrame.setScaleX(-1);
            this.setIsFlipH(true);
            if(!pagas_kid_game2d.isUp() && !pagas_kid_game2d.isDown()){
                if (animator){
                    spriteFrame.setImage(imageState.get(2));
                } else {
                    spriteFrame.setImage(imageState.get(1));
                }
                if (framecounter >= runningspeed){
                    animator = !animator;
                    framecounter = 0;
                } else {
                    framecounter += 1;
                }
            }
        }
        if (pagas_kid_game2d.isDown()){
            spriteFrame.setImage(imageState.get(6));
        }
        if (pagas_kid_game2d.isUp()) { spriteFrame.setImage(imageState.get(4)); }
        if (pagas_kid_game2d.iswKey()) { spriteFrame.setImage(imageState.get(5)); }
        if (pagas_kid_game2d.issKey()) { spriteFrame.setImage(imageState.get(8)); }
    }

    private void checkCollision() {
       for(int i = 0; i< pagas_kid_game2d.castDirector.getCurrentCast().size(); i++) {
            Actor object = pagas_kid_game2d.castDirector.getCurrentCast().get(i);
            
            if(collide(object)) {
                pagas_kid_game2d.castDirector.addRemovedActors(object);
                pagas_kid_game2d.root.getChildren().remove(object.getSpriteFrame());
                pagas_kid_game2d.castDirector.resetRemoveActors();
               
            }
        }    
   }

    private void scoringEngine(Actor object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (object instanceof Prop){
        pagas_kid_game2d.gameScore -= 10;
    }
    pagas_kid_game2d.scoreText.setText(String.valueOf(pagas_kid_game2d.gameScore));
    }
}
    

