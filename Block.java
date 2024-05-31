import greenfoot.*;

public class Block extends Actor
{
    public Block(int color) {
        String path = "images/sprites/block-red.png";
        
        if (color == 1){
            path = "images/sprites/block-red.png";
        }
        if (color == 2){
            path = "images/sprites/block-green.png";
        }
        if (color == 3){
            path = "images/sprites/block-yellow.png";
        }
        GreenfootImage img = new GreenfootImage(path);
        img.scale(20, 20);
        setImage(img);
    }
}