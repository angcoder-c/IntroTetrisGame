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
        addObject(new MenuOption("Un jugador", "onePlayer"), 5, 6);
        addObject(new MenuOption("Dos jugadores", "twoPlayers"), 5, 7);
    }

    public void showOnePlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Normal", "normal"), 5, 4);
        addObject(new MenuOption("Difícil", "dificil"), 5, 5);
        addObject(new MenuOption("Insano", "insano"), 5, 6);
        addObject(new MenuOption("Tutorial", "tutorialOnePlayer"), 5, 7);
        addObject(new MenuOption("Volver", "backToMain"), 5, 8);
    }

    public void showTwoPlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Nueva partida", "newGameTwoPlayers"), 5, 4);
        addObject(new MenuOption("Tutorial", "tutorialTwoPlayers"), 5, 5);
        addObject(new MenuOption("Volver", "backToMain"), 5, 6);
    }

    public void startNormalMode() {
        removeObjects(getObjects(MenuOption.class));
        // Inicializar la matriz occupied antes de usarla
        occupied = new boolean[getWidth()][getHeight()];
        if (!checkGameOver()){
            spawnNewPiece();    
        }

    }

    public void startDificilMode() {
        // lógica para el modo difícil
    }

    public void startInsanoMode() {
        // lógica para el modo insano
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

    public void spawnNewPiece() {
        currentPiece = new Piece();
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
    
    private boolean checkGameOver() {
        for (int x = 0; x < getWidth(); x++) {
            if (isOccupied(x, 0)) {
                return true;
            }
        }
        return false;
    }
}
