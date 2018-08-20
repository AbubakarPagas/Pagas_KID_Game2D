/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;


import javafx.scene.image.Image;


/**
 *
 * @author pagas
 */
public  abstract class Hero extends Actor {
    
    protected double vX, vY, lifeSpan, damage, offsetX, offsetY;
    protected float boundScale, boundRot, friction, Gravity, bounce;
    
    public Hero(String SVGdata, double xLocation, double yLocation, Image... spriteCels) {
        super(SVGdata, xLocation, yLocation, spriteCels);
        // for the speed 
        vX = 2;  // speed move in the x axise;
        vY = 2; //speed move in the y axise;
        lifeSpan = 1000;   // life index
    }

    @Override
    public abstract void update();
    
    public boolean collide(Actor object){
        return false;
    }
     

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public float getBoundScale() {
        return boundScale;
    }

    public void setBoundScale(float boundScale) {
        this.boundScale = boundScale;
    }

    public float getBoundRot() {
        return boundRot;
    }

    public void setBoundRot(float boundRot) {
        this.boundRot = boundRot;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public float getGravity() {
        return Gravity;
    }

    public void setGravity(float Gravity) {
        this.Gravity = Gravity;
    }

    public float getBounce() {
        return bounce;
    }

    public void setBounce(float bounce) {
        this.bounce = bounce;
    }

    
    
}
