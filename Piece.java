import greenfoot.*;

public class Piece extends Actor {
    private Block[] blocks;
    private int[][] shape;
    private int color;
    public TetrisWorld world;

    // piezas
    private static final int[][][] SHAPES = {
        // Stick
        {
            {1, 1, 1, 1}
        },
        // Cube
        {
            {1, 1},
            {1, 1}
        },
        // L
        {
            {1, 0},
            {1, 0},
            {1, 1}
        }
    };
    
    private int[] COLORS = {1,2,3};

    public Piece() {
        blocks = new Block[4];
        shape = SHAPES[Greenfoot.getRandomNumber(SHAPES.length)];
        color = COLORS[Greenfoot.getRandomNumber(3)];
        
    }

    protected void addedToWorld(World world) {
        createShape();
        world = world;
    }

    private void createShape() {
        int index = 0;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    Block block = new Block(color=color);
                    blocks[index++] = block;
                    getWorld().addObject(block, getX() + j, getY() + i);
                }
            }
        }
    }

    public void act() {
        if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        } else if (Greenfoot.isKeyDown("right")) {
            moveRight();
        } else if (Greenfoot.isKeyDown("down")) {
            rotate();
        } else if (Greenfoot.isKeyDown("up")) {
            rotate();
        } else {
            fall();
        }
    }

    private void moveLeft() {
        if (canMove(-1, 0)) {
            setLocation(getX() - 1, getY());
            updateBlockPositions(-1, 0);
        }
        
        moveDown();
    }

    private void moveRight() {
        if (canMove(1, 0)) {
            setLocation(getX() + 1, getY());
            updateBlockPositions(1, 0);
        }
        
        moveDown();
    }

    private void moveDown() {
        if (canMove(0, 1)) {
            setLocation(getX(), getY() + 1);
            updateBlockPositions(0, 1);
        } else {
            placeBlocks();
            World currentWorld = getWorld();
            if (currentWorld instanceof TetrisWorld) {
                ((TetrisWorld) currentWorld).addObject(new Piece(), 5, 0);
            }
        }
    }

    private void rotate() {
        int[][] rotatedShape = rotateMatrixClockwise(shape);
        if (canRotate(rotatedShape)) {
            shape = rotatedShape;
            updateBlockPositionsAfterRotation();
        }
    }

    private int[][] rotateMatrixClockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    private boolean canRotate(int[][] rotatedShape) {
        int offsetX = getX();
        int offsetY = getY();
        for (int i = 0; i < rotatedShape.length; i++) {
            for (int j = 0; j < rotatedShape[i].length; j++) {
                if (rotatedShape[i][j] == 1) {
                    int newX = offsetX + j;
                    int newY = offsetY + i;
                    if (newX < 0 || newX >= getWorld().getWidth() || newY >= getWorld().getHeight()) {
                        return false;
                    }
                    if (((TetrisWorld) getWorld()).isOccupied(newX, newY)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void updateBlockPositionsAfterRotation() {
        for (Block block : blocks) {
            getWorld().removeObject(block);
        }
        createShape();
    }

    private void fall() {
        if (Greenfoot.getRandomNumber(100) < 10) {
            if (canMove(0, 1)) {
                setLocation(getX(), getY() + 1);
                updateBlockPositions(0, 1);
            } else {
                placeBlocks();
                world.spawnNewPiece();
            }
        }
    }

    public boolean canMove(int dx, int dy) {
        for (Block block : blocks) {
            int newX = getX() + block.getX() - getX() + dx;
            int newY = getY() + block.getY() - getY() + dy;
            if (newX < 0 || newX >= getWorld().getWidth() || newY >= getWorld().getHeight()) {
                return false;
            }
            if (((TetrisWorld) getWorld()).isOccupied(newX, newY)) {
                return false;
            }
        }
        return true;
    }

    private void updateBlockPositions(int dx, int dy) {
        for (Block block : blocks) {
            block.setLocation(block.getX() + dx, block.getY() + dy);
        }
    }

    private void placeBlocks() {
        TetrisWorld world = (TetrisWorld) getWorld();
        for (Block block : blocks) {
            int x = getX() + block.getX() - getX();
            int y = getY() + block.getY() - getY();
            block.setLocation(x, y);
            world.occupy(x, y);
        }
        getWorld().removeObject(this);
    }
}