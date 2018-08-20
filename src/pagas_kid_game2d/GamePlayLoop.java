/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;

import javafx.animation.AnimationTimer;

/**
 *
 * @author pagas
 */
public class GamePlayLoop extends AnimationTimer {
    
    protected Pagas_KID_Game2D pagas_KID_Game2D;
    
    public GamePlayLoop (Pagas_KID_Game2D ipagas){
       this.pagas_KID_Game2D = ipagas;
    }
            

    @Override
    public void handle(long now) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        pagas_KID_Game2D.ipagas.update();
 
       
    }

    @Override
    public void stop() {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
