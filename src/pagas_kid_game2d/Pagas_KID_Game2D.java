/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author pagas
 */
public class Pagas_KID_Game2D extends Application {

    Pagas ipagas;
    //Enemy killer;
    //handling movment 
    private boolean up, down, left, right, aKey, dKey, sKey, wKey; 
    // for the bonus eat
    //Projectile iBullet, iCheese;
    Prop iPR0, iPR1;
    PropH iPH0;
    PropV iPV0, iPV1;
    PropB iPB0;
    
    // for screen revolution 
    static final double WIDTH = 640, HEIGHT = 400;
    int gameScore = 0; /// score game strating at the zero
    private Scene scene;
    Group root;
     CatingDirector castDirector;
    //private StackPane root;
    // for the Horizontal Box Button container
    private HBox buttonContainer;
    Text scoreText , scoreLabel;  // txt for the view of score in the 
    Font scoreFont;   // for the font view 
    // for the button fornt Screen 
    private Button gameButton, helpButton, scoreButton, legalButton;
    // Image for the each layer
    private Image splashScreen, instructionLayer, legalLayer, scoreLayer, skyCloud;
    //for the image view
    private ImageView splashScreenBackplate, splashScreenTextArea;
    // for the insets
    private Insets buttonContainerPadding;
    // calling the gameplayloop
    private GamePlayLoop gamePlayLoop;
    private Image iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8,iP0, iT0, iT1, iE0, iC0, iC1;
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isaKey() {
        return aKey;
    }

    public void setaKey(boolean aKey) {
        this.aKey = aKey;
    }

    public boolean isdKey() {
        return dKey;
    }

    public void setdKey(boolean dKey) {
        this.dKey = dKey;
    }

    public boolean issKey() {
        return sKey;
    }

    public void setsKey(boolean sKey) {
        this.sKey = sKey;
    }

    public boolean iswKey() {
        return wKey;
    }

    public void setwKey(boolean wKey) {
        this.wKey = wKey;
    }

   
    
    

    @Override
    public void start(Stage primaryStage)  {
        
       
        primaryStage.setTitle("Pagas Kid Game2D");
         root = new Group();
        //root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT,Color.WHITE );
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //create the class method 
        createSplashScreenNodesButton();
        addNodeToStackPane();
        // for the load image 
        loadImageAssets();
        //lets create game\play to start
        createStartGameLoop();
        creataGameActors();
        // this the node for pagas attach to the scene
        createGameNode();
        // create for the handling event
        creatSceneEventHandling();
        createCastingDirection();
            
    }

    private void createSplashScreenNodesButton() {
        // for game counting the score 
        scoreText = new Text();
        scoreText.setText( String.valueOf(gameScore));
        scoreText.setLayoutX(522);
        scoreText.setLayoutY(385);
        scoreText.setFont(scoreFont); // calling the font of scorefont 
        scoreText.setFill(Color.BLUE);
        scoreFont = new Font("Verdana", 20);
        // for the score label of the text
       scoreLabel = new Text();
       scoreLabel.setText("SCORE:");
       scoreLabel.setLayoutX(385);
       scoreLabel.setLayoutY(445);
       scoreLabel.setFont(scoreFont);
       scoreLabel.setFill(Color.BLACK);             
        // for the horizontal container Box
        buttonContainer = new HBox(12);   // size the button of buttonConatiner
        buttonContainer.setLayoutY(365);  // setLayout Y going down of Y axis
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);
        // for the button conatiner 
        gameButton = new Button();
        gameButton.setLayoutX(0);
        gameButton.setText("PLAY GAME");
        gameButton.setOnAction((ActionEvent) ->{
            splashScreenBackplate.setVisible(true);
            splashScreenBackplate.setImage(skyCloud);
            splashScreenBackplate.toBack();
            splashScreenTextArea.setVisible(false);
            
        });
        // for the helpButton container
        helpButton = new Button();
        helpButton.setText("INSTRUCTION");
        helpButton.setOnAction((ActionEvent) ->{
            splashScreenBackplate.setVisible(true);
            splashScreenBackplate.setImage(splashScreen);
            splashScreenBackplate.toFront();
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(instructionLayer);
            splashScreenTextArea.toFront();
            buttonContainer.toFront();
            
            
        });
        // for the hight score game engine
        scoreButton = new Button();
        scoreButton.setText("HIGH SCORE");
        scoreButton.setOnAction((ActionEvent) ->{
            splashScreenBackplate.setVisible(true);
            splashScreenBackplate.setImage(splashScreen);
            splashScreenBackplate.toFront();
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(scoreLayer);
            splashScreenTextArea.toFront();
            buttonContainer.toFront();
            
            
        });
        // this the for the legal and credit
        legalButton = new  Button();
        legalButton.setText("LEGAL & CREDIT");
        legalButton.setOnAction((ActionEvent) ->{
            splashScreenBackplate.setVisible(true);
            splashScreenBackplate.setImage(splashScreen);
            splashScreenBackplate.toFront();
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(legalLayer);
            splashScreenTextArea.toFront();
            buttonContainer.toFront();
            
        });
        
        // call the method for the Buttoncontianer to all button into stackpane
        buttonContainer.getChildren().addAll(gameButton, helpButton, scoreButton, legalButton);
    
        splashScreenBackplate = new ImageView();
        splashScreenBackplate.setImage(splashScreen);
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayer);
    }

    private void addNodeToStackPane() {
       root.getChildren().add(splashScreenBackplate);
       root.getChildren().add(splashScreenTextArea);
       //connect to the root of stackpane
       root.getChildren().add(buttonContainer);
       //conect the score View in the game scene
       root.getChildren().add(scoreText);
       root.getChildren().add(scoreLabel);
               
         
        
    }

    private void loadImageAssets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        splashScreen = new Image("/invincibagelsplash.png",640,400, true , false ,true);
        instructionLayer = new Image("/invincibagelinstruct.png", 640, 400, true, false, true);
        legalLayer = new Image("invincibagelcreds.png", 640, 400, true , false, true);
        scoreLayer = new Image("invincibagelscores.png", 640, 400, true, false, true);
        skyCloud = new Image("skyCloud.png", 640, 400, true, false, true);
        // for the pagas Character
        iB0 = new Image ("sprite0.png ", 81, 81, true, false, true);
        iB1 = new Image ("sprite1.png ", 81, 81, true, false, true);
        iB2 = new Image ("sprite2.png ", 81, 81, true, false, true);
        iB3 = new Image ("sprite3.png ", 81, 81, true, false, true);
        iB4 = new Image ("sprite4.png ", 81, 81, true, false, true);
        iB5 = new Image ("sprite5.png ", 81, 81, true, false, true);
        iB6 = new Image ("sprite6.png ", 81, 81, true, false, true);
        iB7 = new Image ("sprite7.png ", 81, 81, true, false, true);
        iB8 = new Image ("sprite8.png ", 81, 81, true, false, true);
        iP0 = new Image("/prop0.png", 72, 32, true, false, true);

    }

    private void createStartGameLoop() {
    
        gamePlayLoop = new GamePlayLoop(this);
        gamePlayLoop.start();
    }

    private void creataGameActors() {
        ipagas = new Pagas(this, 
                "M58,8 L58,8 43,24 32,28 32,41 18,41 28,54 40,61 35,73 41,79 45,54 55,39 65,40 69,25 Z", 
                WIDTH/2, HEIGHT/2, iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8);

        iPR0 = new Prop("M0,0 L0,32 72,32 72,0 Z", 30, 48, iP0);
       //iPH0 = new PropH("M0,0 L0,32 72,32 72,0 Z", 172, 248, iP0);
        //iPV0 = new PropV("M0,0 L0,32 72,32 72,0 Z", 396, 116, iP0);
        //iPB0 = new PropB("M0,0 L0,32 72,32 72,0 Z", 512, 316, iP0);
    }

    private void createGameNode() {

        root.getChildren().add(ipagas.spriteFrame);
        root.getChildren().add(iPR0.spriteFrame);
    }

    private void creatSceneEventHandling() {
      // for the when key is press
        scene.setOnKeyPressed((KeyEvent event) ->{
            switch (event.getCode()){
                case W: wKey = true; break;
                case UP: up = true; break;
                case DOWN: down = true; break;
                case S: sKey = true; break;
                case A: aKey = true; break;
                case LEFT: left = true; break;
                case D: dKey = true; break;
                case RIGHT: right = true; break;
            }
            
        });
        // for the when key is release
        scene.setOnKeyReleased((KeyEvent event) ->{
            switch (event.getCode()){
                case W: wKey = false; break;
                case UP: up = false; break;
                case DOWN: down = false; break;
                case S: sKey = false; break;
                case A: aKey = false; break;
                case LEFT: left = false; break;
                case D: dKey = false; break;
                case RIGHT: right = false; break;
            }
            
        });
        
    }

    private void createCastingDirection() {

        castDirector = new CatingDirector();
        castDirector.addCurrentCast(iPR0);
    }

   
    
    
}
