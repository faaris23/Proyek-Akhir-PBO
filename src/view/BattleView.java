package view;

import model.Character;
import model.Enemy;

import javax.swing.*;
import java.awt.*;

public class BattleView extends JPanel {
    private JLabel characterHpLabel;
    private JLabel enemyHpLabel;
    private JButton fightButton;
    private JButton healButton;
    private JButton runButton;

    public BattleView(Character character, Enemy enemy) {
        setLayout(new GridLayout(4, 1));

        characterHpLabel = new JLabel("Your HP: " + character.getHp());
        enemyHpLabel = new JLabel(enemy.getName() + " HP: " + enemy.getHp());
        fightButton = new JButton("Fight");
        healButton = new JButton("Heal");
        runButton = new JButton("Run");

        add(characterHpLabel);
        add(enemyHpLabel);
        add(fightButton);
        add(healButton);
        add(runButton);
    }

    public JButton getFightButton() {
        return fightButton;
    }

    public JButton getHealButton() {
        return healButton;
    }

    public JButton getRunButton() {
        return runButton;
    }

    public void updateCharacterHp(int hp) {
        characterHpLabel.setText("Your HP: " + hp);
    }

    public void updateEnemyHp(int hp) {
        enemyHpLabel.setText("HP: " + hp);
    }
}
