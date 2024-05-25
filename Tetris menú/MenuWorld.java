import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuWorld extends World {
    public MenuWorld() {    
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
}
