import greenfoot.*;
import java.util.Random;

public class Block extends Actor
{
    private static final String[] SPRITE = {"cube", "stick", "other"};
    private static final int FALL_DELAY = 30;
    
    private boolean canMove = true;
    private int fallCounter = 0;
    private int rotationCounter = 0;
    
    public Block() {
        String sprite = randomSprite();
        switch (sprite) {
            case "cube":
                setImage("images/sprites/cube.png");
                getImage().scale(40, 40);
                break;
            case "stick":
                setImage("images/sprites/stick.png");
                getImage().scale(80, 20); 
                break;
            case "other":
                setImage("images/sprites/other.png");
                getImage().scale(40, 60);
                break;
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
    }
    
    private void handleRotation() {
        if (Greenfoot.isKeyDown("up") && rotationCounter == 0) {
            setRotation(getRotation() + 90);
            rotationCounter = FALL_DELAY;
        } else if (Greenfoot.isKeyDown("down") && rotationCounter == 0) {
            setRotation(getRotation() - 90);
            rotationCounter = FALL_DELAY;
        }
    }
    
    private void fall() {
        setLocation(getX(), getY() + 1);
        checkCollision();
    }
    
    private void handleMovement() {
        if (rotationCounter == 0) {
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() - 1, getY());
                checkCollision();
            }
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() + 1, getY());
                checkCollision();
            }
        }
    }
    
    private void checkCollision() {
        if (isAtEdge() || isTouching(Block.class)) {
            if (getY() > 0) {
                setLocation(getX(), getY() - 1); // Revert last move
            }
            canMove = false;
        }
    }
    
    public boolean canMove() {
        return canMove;
    }
    
    private String randomSprite() {
        Random rand = new Random();
        return SPRITE[rand.nextInt(SPRITE.length)];
    }
}