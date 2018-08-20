/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author pagas
 */
public abstract class Actor {
    
    // this the image state
    protected List<Image> imageState = new ArrayList<>();
    protected ImageView spriteFrame;
    protected SVGPath spriteBound;
    protected double iX;
    protected double iY;
    protected double pX;
    protected double pY;
    protected boolean isAlive;
    protected boolean isFixed;
    protected boolean isBound;
    protected boolean hasValu;
    protected boolean isFlipV;
    protected boolean isFlipH;
    
    public Actor (String SVGdata, double xLocation, double yLocation, Image... spriteCels){
      spriteBound = new SVGPath();
      spriteBound.setContent(SVGdata);
      spriteFrame = new ImageView(spriteCels[0]);
      imageState.addAll(Arrays.asList(spriteCels));
      
      // constructing 
      iX = xLocation;
      iY = yLocation;
      pX = 0;
      pY = 0;
      isAlive = false;
      isFixed = true;
      isBound = false;
      hasValu = false;
      isFlipV = false;
      isFlipH = false;
      
    }

    public List<Image> getImageState() {
        return imageState;
    }

    public void setImageState(List<Image> imageState) {
        this.imageState = imageState;
    }

    public ImageView getSpriteFrame() {
        return spriteFrame;
    }

    public void setSpriteFrame(ImageView spriteFrame) {
        this.spriteFrame = spriteFrame;
    }

    public SVGPath getSpriteBound() {
        return spriteBound;
    }

    public void setSpriteBound(SVGPath spriteBound) {
        this.spriteBound = spriteBound;
    }

    public double getiX() {
        return iX;
    }

    public void setiX(double iX) {
        this.iX = iX;
    }

    public double getiY() {
        return iY;
    }

    public void setiY(double iY) {
        this.iY = iY;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isIsFixed() {
        return isFixed;
    }

    public void setIsFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }

    public boolean isIsBound() {
        return isBound;
    }

    public void setIsBound(boolean isBound) {
        this.isBound = isBound;
    }

    public boolean isHasValu() {
        return hasValu;
    }

    public void setHasValu(boolean hasValu) {
        this.hasValu = hasValu;
    }

    public boolean isIsFlipV() {
        return isFlipV;
    }

    public void setIsFlipV(boolean isFlipV) {
        this.isFlipV = isFlipV;
    }

    public boolean isIsFlipH() {
        return isFlipH;
    }

    public void setIsFlipH(boolean isFlipH) {
        this.isFlipH = isFlipH;
    }
    
    public abstract void update();
    
}
