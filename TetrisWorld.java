import greenfoot.*;  // World, Actor

public class TetrisWorld extends World
{   
    private Block currentPiece;
    
    public TetrisWorld()
    {    
        super(600, 400, 1);
        showMainMenu();
    }
    
    public void showMainMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Un jugador", "onePlayer"), 300, 200);
        addObject(new MenuOption("Dos jugadores", "twoPlayers"), 300, 250);
    }
    
    public void showOnePlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Normal", "normal"), 300, 150);
        addObject(new MenuOption("Difícil", "dificil"), 300, 200);
        addObject(new MenuOption("Insano", "insano"), 300, 250);
        addObject(new MenuOption("Tutorial", "tutorialOnePlayer"), 300, 300);
        addObject(new MenuOption("Volver", "backToMain"), 300, 350);
    }
    
    public void showTwoPlayerMenu() {
        removeObjects(getObjects(MenuOption.class));
        addObject(new MenuOption("Nueva partida", "newGameTwoPlayers"), 300, 200);
        addObject(new MenuOption("Tutorial", "tutorialTwoPlayers"), 300, 250);
        addObject(new MenuOption("Volver", "backToMain"), 300, 300);
    }

    public void startNormalMode() {
        removeObjects(getObjects(MenuOption.class));
        spawnNewPiece();
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
