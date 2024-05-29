import greenfoot.*;  // World, Actor

public class TetrisWorld extends World {   
    private Piece currentPiece;
    private boolean[][] occupied;

    public TetrisWorld() {    
        super(15, 15, 30);
        showMainMenu();
    }

    public void showMainMenu() {
        removeObjects(getObjects(MenuOption.class));
        removeObjects(getObjects(Piece.class));
        addObject(new MenuOption("Un jugador", "onePlayer"), 7, 6);
        addObject(new MenuOption("Dos jugadores", "twoPlayers"), 7, 7);
    }

    public void showOnePlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Normal", "normal"), 7, 4);
        addObject(new MenuOption("Difícil", "dificil"), 7, 5);
        addObject(new MenuOption("Insano", "insano"), 7, 6);
        addObject(new MenuOption("Tutorial", "tutorialOnePlayer"), 7, 7);
        addObject(new MenuOption("Volver", "backToMain"), 7, 8);
    }

    public void showTwoPlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Nueva partida", "newGameTwoPlayers"), 7, 4);
        addObject(new MenuOption("Tutorial", "tutorialTwoPlayers"), 7, 5);
        addObject(new MenuOption("Volver", "backToMain"), 7, 6);
    }

    public void startNormalMode() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(1);
    }

    public void startDificilMode() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(2);    
    }

    public void startInsanoMode() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new Top(), 0, 0);
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        spawnNewPiece(3);
    }

    public void startTutorialOnePlayer() {
        // lógica para el tutorial de un jugador
    }

    public void startNewGameTwoPlayers() {
        // lógica para una nueva partida de dos jugadores
    }

    public void startTutorialTwoPlayers() {
        // lógica para el tutorial de dos jugadores
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
