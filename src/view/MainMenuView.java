package view;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JPanel {
    private JButton characterButton;
    private JButton shopButton;
    private JButton dungeonButton;
    private JButton exitButton;

    public MainMenuView() {
        setLayout(new GridLayout(4, 1));

        characterButton = new JButton("Character");
        shopButton = new JButton("Shop");
        dungeonButton = new JButton("Dungeon");
        exitButton = new JButton("Exit");

        add(characterButton);
        add(shopButton);
        add(dungeonButton);
        add(exitButton);
    }

    public JButton getCharacterButton() {
        return characterButton;
    }

    public JButton getShopButton() {
        return shopButton;
    }

    public JButton getDungeonButton() {
        return dungeonButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
