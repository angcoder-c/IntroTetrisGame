import greenfoot.*;  // World, Actor

public class TetrisWorld extends World {   
    private Piece currentPiece;
    private boolean[][] occupied;
    private GreenfootImage mainMenuBackground;
    private GreenfootImage normalModeBackground;
    private GreenfootImage dificilModeBackground;
    private GreenfootImage insanoModeBackground;
    public GreenfootSound backgroundMusic;

    public TetrisWorld() {
        super(15, 15, 30);
        
        mainMenuBackground = new GreenfootImage("images/backgrounds/background-menu.png");
        normalModeBackground = new GreenfootImage("images/backgrounds/background-normal.png");
        dificilModeBackground = new GreenfootImage("images/backgrounds/background-hard.png");
        insanoModeBackground = new GreenfootImage("images/backgrounds/background-insane.png");
        
        // play music
        backgroundMusic = new GreenfootSound("sounds/background_music.wav");
        backgroundMusic.playLoop();
        showMainMenu();
    }

    public void showMainMenu() {
        setBackground(mainMenuBackground);
        removeObjects(getObjects(MenuOption.class));
        removeObjects(getObjects(Piece.class));
        addObject(new MenuOption("Start", "onePlayer"), 7, 7);
        addObject(new Credits(), 7, 10);
    }

    public void showOnePlayerMenu() {
        setBackground(mainMenuBackground);
        removeObjects(getObjects(MenuOption.class));
        removeObjects(getObjects(Credits.class));
        addObject(new MenuOption("Normal", "normal"), 7, 5);
        addObject(new MenuOption("Difícil", "dificil"), 7, 7);
        addObject(new MenuOption("Insano", "insano"), 7, 9);
        addObject(new MenuOption("Volver", "backToMain"), 2, 13);
    }

    public void startNormalMode() {
        setBackground(normalModeBackground);
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(1);
    }

    public void startDificilMode() {
        setBackground(dificilModeBackground);
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(2);    
    }

    public void startInsanoMode() {
        setBackground(insanoModeBackground);
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(3);
    }

    public void act() {
        // Aquí podemos manejar la lógica global del juego
    }

    public void spawnNewPiece(int speed) {
        currentPiece = new Piece(speed);
        currentPiece.world = this;
        addObject(currentPiece, 5, 0);
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
    
    private void checkGameOver() {
        for (int x = 0; x < getWidth(); x++) {
            if (isOccupied(x, 0)) {
                Greenfoot.setWorld(new TetrisWorld());
            }
        }
    }

}
