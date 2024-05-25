import greenfoot.*;  // World, Actor

public class TetrisWorld extends World
{
    private Block currentPiece;
    
    public TetrisWorld()
    {    
        super(600, 400, 1);
        spawnNewPiece();
    }
    
    public void act() {
        if (currentPiece != null && !currentPiece.canMove()) {
            currentPiece = null;
            spawnNewPiece();
        }
    }
    
    private void spawnNewPiece() {
        currentPiece = new Block();
        addObject(currentPiece, getWidth() / 2, 0);
    }
}