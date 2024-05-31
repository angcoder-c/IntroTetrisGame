import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuOption extends Actor {
    private String action;
    
    public MenuOption(String text, String action) {
        this.action = action;
        
        // Cargar la imagen de fondo
        GreenfootImage backgroundImage = new GreenfootImage("images/sprites/button_background.png");
        
        // Crear una imagen con el texto
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.BLACK, new Color(0, 0, 0, 0)); // transparent
        
        backgroundImage.scale(textImage.getWidth() + 20, textImage.getHeight() + 10);
        
        // combinie
        GreenfootImage combinedImage = new GreenfootImage(backgroundImage);
        combinedImage.drawImage(textImage, 
            (backgroundImage.getWidth() - textImage.getWidth()) / 2, 
            (backgroundImage.getHeight() - textImage.getHeight()) / 2 
        );
        
        setImage(combinedImage);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            TetrisWorld world = (TetrisWorld) getWorld();
            switch (action) {
                case "onePlayer":
                    world.showOnePlayerMenu();
                    break;
                case "normal":
                    // Lógica para iniciar el juego en modo Normal
                    world.startNormalMode();
                    break;
                case "dificil":
                    // Lógica para iniciar el juego en modo Difícil
                    world.startDificilMode();
                    break;
                case "insano":
                    // Lógica para iniciar el juego en modo Insano
                    world.startInsanoMode();
                    break;
                case "backToMain":
                    Greenfoot.setWorld(new TetrisWorld());
                    break;
            }
        }
    }
}
