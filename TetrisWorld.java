import greenfoot.*;

public class TetrisWorld extends World {
    private boolean[][] occupied;

    public TetrisWorld() {    
        super(10, 15, 30);
        setPaintOrder(Piece.class, Block.class);
        occupied = new boolean[10][20];
        Piece tetromino = new Piece();
        addObject(tetromino, 5, 0);
    }

    public boolean isOccupied(int x, int y) {
        if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
            return true;
        }
        return occupied[x][y];
    }

    public void occupy(int x, int y) {
        occupied[x][y] = true;
    }
}
