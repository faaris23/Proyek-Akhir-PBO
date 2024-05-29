package view;

import model.Character;

import javax.swing.*;
import java.awt.*;

public class ShopView extends JPanel {
    private JLabel goldLabel;
    private JComboBox<String> statComboBox;
    private JTextField amountField;
    private JButton upgradeButton;
    private JButton backButton;

    public ShopView(Character character) {
        setLayout(new GridLayout(5, 1));

        goldLabel = new JLabel("Gold: " + character.getGold());
        String[] stats = {"HP", "DEF", "ATK"};
        statComboBox = new JComboBox<>(stats);
        amountField = new JTextField();
        upgradeButton = new JButton("Upgrade");
        backButton = new JButton("Back to Main Menu");

        add(goldLabel);
        add(statComboBox);
        add(amountField);
        add(upgradeButton);
        add(backButton);
    }

    public String getSelectedStat() {
        return (String) statComboBox.getSelectedItem();
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getUpgradeButton() {
        return upgradeButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void updateCharacterStatus(Character character) {
        goldLabel.setText("Gold: " + character.getGold());
    }
}
