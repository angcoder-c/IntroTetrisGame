import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuOption extends Actor {
    private String action;
    
    public MenuOption(String text, String action) {
        this.action = action;
        GreenfootImage image = new GreenfootImage(text, 24, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            MenuWorld world = (MenuWorld) getWorld();
            switch (action) {
                case "onePlayer":
                    world.showOnePlayerMenu();
                    break;
                case "twoPlayers":
                    world.showTwoPlayerMenu();
                    break;
                case "normal":
                    // Lógica para iniciar el juego en modo Normal
                    break;
                case "dificil":
                    // Lógica para iniciar el juego en modo Difícil
                    break;
                case "insano":
                    // Lógica para iniciar el juego en modo Insano
                    break;
                case "tutorialOnePlayer":
                    // Lógica para iniciar el tutorial para un jugador
                    break;
                case "newGameTwoPlayers":
                    // Lógica para iniciar una nueva partida para dos jugadores
                    break;
                case "tutorialTwoPlayers":
                    // Lógica para iniciar el tutorial para dos jugadores
                    break;
                case "backToMain":
                    world.showMainMenu();
                    break;
            }
        }
    }
}

