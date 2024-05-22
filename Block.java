import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int angle = 0;
    public void act()
    {
        setLocation(getX(), getY()+1);
        if (Greenfoot.isKeyDown("up")) {
            //angle = angle 
            setRotation(angle+90);
        }
        if (Greenfoot.isKeyDown("down")) {
            setRotation(angle-90);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX()-1, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX()+1, getY());
        }
    }
}
