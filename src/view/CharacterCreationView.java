package view;

import javax.swing.*;
import java.awt.*;

public class CharacterCreationView extends JPanel {
    private JRadioButton tankerButton;
    private JRadioButton mageButton;
    private JRadioButton berserkerButton;
    private JRadioButton paladinButton;
    private JButton createButton;
    private ButtonGroup jobGroup;

    public CharacterCreationView() {
        setLayout(new GridLayout(5, 1));

        tankerButton = new JRadioButton("Tanker (HP: 75, DEF: 50, ATK: 25)");
        mageButton = new JRadioButton("Mage (HP: 40, DEF: 30, ATK: 80)");
        berserkerButton = new JRadioButton("Berserker (HP: 75, DEF: 0, ATK: 75)");
        paladinButton = new JRadioButton("Paladin (HP: 50, DEF: 50, ATK: 50)");

        jobGroup = new ButtonGroup();
        jobGroup.add(tankerButton);
        jobGroup.add(mageButton);
        jobGroup.add(berserkerButton);
        jobGroup.add(paladinButton);

        add(tankerButton);
        add(mageButton);
        add(berserkerButton);
        add(paladinButton);

        createButton = new JButton("Create Character");
        add(createButton);
    }

    public String getSelectedJob() {
        if (tankerButton.isSelected()) {
            return "Tanker";
        } else if (mageButton.isSelected()) {
            return "Mage";
        } else if (berserkerButton.isSelected()) {
            return "Berserker";
        } else if (paladinButton.isSelected()) {
            return "Paladin";
        }
        return null;
    }

    public JButton getCreateButton() {
        return createButton;
    }
}
