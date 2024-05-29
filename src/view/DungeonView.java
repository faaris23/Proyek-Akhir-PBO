package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DungeonView extends JPanel {
    private Map<String, JButton> enemyButtons;
    private JButton backButton;

    public DungeonView() {
        setLayout(new GridLayout(6, 1));

        enemyButtons = new HashMap<>();
        String[] enemies = {"Goblin", "Wild Boar", "Slime", "Ghoul", "Dragon"};

        for (String enemy : enemies) {
            JButton button = new JButton(enemy);
            enemyButtons.put(enemy, button);
            add(button);
        }

        backButton = new JButton("Back to Main Menu");
        add(backButton);
    }

    public JButton getEnemyButton(String enemy) {
        return enemyButtons.get(enemy);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
