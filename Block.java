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
    public void act()
    {
        setRotation(0);
        move(4);
                if (Greenfoot.isKeyDown("up")) {
            setRotation(90);
        }
        if (Greenfoot.isKeyDown("down")) {
            setRotation(-90);
        }
    }
}
