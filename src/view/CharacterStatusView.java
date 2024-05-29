package view;

import model.Character;

import javax.swing.*;
import java.awt.*;

public class CharacterStatusView extends JPanel {
    private JLabel hpLabel;
    private JLabel defLabel;
    private JLabel atkLabel;
    private JLabel goldLabel;
    private JButton backButton;

    public CharacterStatusView(Character character) {
        setLayout(new GridLayout(5, 1));

        hpLabel = new JLabel("HP: " + character.getHp());
        defLabel = new JLabel("DEF: " + character.getDef());
        atkLabel = new JLabel("ATK: " + character.getAtk());
        goldLabel = new JLabel("Gold: " + character.getGold());
        backButton = new JButton("Back to Main Menu");

        add(hpLabel);
        add(defLabel);
        add(atkLabel);
        add(goldLabel);
        add(backButton);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
