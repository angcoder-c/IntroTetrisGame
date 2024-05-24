import greenfoot.*;
import java.util.Random;

public class Block extends Actor
{
    private static final String[] SPRITE = {"cube", "stick", "other"};
    private static final int FALL_DELAY = 30;
    
    private boolean canMove = true;
    private int fallCounter = 0;
    int rotationDelay = 10000;
    int rotationCounter = 0;
    
    public Block() {
        String sprite = randomSprite();
        if (sprite=="cube"){
            setImage("images/sprites/cube.png");
            getImage().scale(40, 40); 
        }
        if (sprite=="stick"){
            setImage("images/sprites/stick.png");
            getImage().scale(80, 20); 
        }
        if (sprite=="other"){
            setImage("images/sprites/other.png");
            getImage().scale(40, 60); 
        }
           
    }
    
    public void act() {
        if (canMove) {
            handleMovement();
            handleRotation();
            fallCounter++;
            if (fallCounter >= FALL_DELAY) {
                fall();
                fallCounter = 0;
            }
        }
        if (rotationCounter > 0) {
                rotationCounter--;
        }
        if (getY()>=getWorld().getHeight()-38) {
                canMove=false;
        }
        if (getX()>=getWorld().getWidth()-38) {
                canMove=false;
        }
    }
    private void handleRotation() {
        if (Greenfoot.isKeyDown("up")) {
            setRotation(getRotation() + 90);
        } else if (Greenfoot.isKeyDown("down")) {
            setRotation(getRotation() - 90);
        }
    }
    
    private void fall() {
        setLocation(getX(), getY() + 10);
        checkCollision();
    }
    
    private void handleMovement() {
        if (rotationCounter == 0){
        
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() - 10, getY());
            }
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() + 10, getY());
            }
            checkCollision();
        }
    }
    
    private void checkCollision() {
        if (isAtEdge() || isTouching(Block.class)) {
            canMove = false;
        }
    }
    
    private String randomSprite() {
        Random rand = new Random();
        return SPRITE[rand.nextInt(SPRITE.length)];
    }
}
