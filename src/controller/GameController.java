package controller;

import dao.AccountDAO;
import dao.CharacterDAO;
import model.Account;
import model.Character;
import model.Enemy;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private AccountDAO accountDAO;
    private CharacterDAO characterDAO;
    private Account currentAccount;
    private Character currentCharacter;

    public GameController() {
        accountDAO = new AccountDAO();
        characterDAO = new CharacterDAO();
        showLoginView();
    }

    private void showLoginView() {
        JFrame frame = new JFrame("Login");
        LoginView loginView = new LoginView();

        loginView.getLoginButton().addActionListener(e -> {
            String username = loginView.getUsernameField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            currentAccount = accountDAO.getAccount(username, password);
            if (currentAccount != null) {
                if (currentAccount.isHasCharacter()) {
                    currentCharacter = characterDAO.getCharacterByAccountId(currentAccount.getId());
                    showMainMenuView();
                } 
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginView.getRegisterButton().addActionListener(e -> {
            String username = loginView.getUsernameField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            accountDAO.createAccount(username, password);
            JOptionPane.showMessageDialog(frame, "Account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(loginView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
/*
    private void showCharacterCreationView() {
        JFrame frame = new JFrame("Create Character");
        CharacterCreationView characterCreationView = new CharacterCreationView();

        characterCreationView.getCreateButton().addActionListener(e -> {
            String selectedJob = characterCreationView.getSelectedJob();
            Character newCharacter = new Character();
            newCharacter.setAccountId(currentAccount.getId());
            newCharacter.setJob(selectedJob);

            switch (selectedJob) {
                case "Tanker":
                    newCharacter.setHp(75);
                    newCharacter.setDef(50);
                    newCharacter.setAtk(25);
                    break;
                case "Mage":
                    newCharacter.setHp(40);
                    newCharacter.setDef(30);
                    newCharacter.setAtk(80);
                    break;
                case "Berserker":
                    newCharacter.setHp(75);
                    newCharacter.setDef(0);
                    newCharacter.setAtk(75);
                    break;
                case "Paladin":
                    newCharacter.setHp(50);
                    newCharacter.setDef(50);
                    newCharacter.setAtk(50);
                    break;
            }

            characterDAO.createCharacter(newCharacter);
            accountDAO.updateHasCharacter(currentAccount.getId(), true);
            currentCharacter = newCharacter;
            frame.dispose();
            showMainMenuView();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(characterCreationView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/

    private void showMainMenuView() {
        JFrame frame = new JFrame("Main Menu");
        MainMenuView mainMenuView = new MainMenuView();

        mainMenuView.getCharacterButton().addActionListener(e -> {
            showCharacterStatusView();
            frame.dispose();
        });

        mainMenuView.getShopButton().addActionListener(e -> {
            showShopView();
            frame.dispose();
        });

        mainMenuView.getDungeonButton().addActionListener(e -> {
            showDungeonView();
            frame.dispose();
        });

        mainMenuView.getExitButton().addActionListener(e -> {
            System.exit(0);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainMenuView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showCharacterStatusView() {
        JFrame frame = new JFrame("Character Status");
        CharacterStatusView characterStatusView = new CharacterStatusView(currentCharacter);

        characterStatusView.getBackButton().addActionListener(e -> {
            showMainMenuView();
            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(characterStatusView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showShopView() {
        JFrame frame = new JFrame("Shop");
        ShopView shopView = new ShopView(currentCharacter);

        shopView.getBackButton().addActionListener(e -> {
            characterDAO.updateCharacter(currentCharacter);
            showMainMenuView();
            frame.dispose();
        });

        shopView.getUpgradeButton().addActionListener(e -> {
            String stat = shopView.getSelectedStat();
            int amount = Integer.parseInt(shopView.getAmountField().getText());
            int cost = amount * 10;  // Example cost formula

            if (currentCharacter.getGold() >= cost) {
                currentCharacter.setGold(currentCharacter.getGold() - cost);

                switch (stat) {
                    case "HP":
                        currentCharacter.setHp(currentCharacter.getHp() + amount);
                        break;
                    case "DEF":
                        currentCharacter.setDef(currentCharacter.getDef() + amount);
                        break;
                    case "ATK":
                        currentCharacter.setAtk(currentCharacter.getAtk() + amount);
                        break;
                }

                shopView.updateCharacterStatus(currentCharacter);
            } else {
                JOptionPane.showMessageDialog(frame, "Not enough gold", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(shopView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showDungeonView() {
        JFrame frame = new JFrame("Dungeon");
        DungeonView dungeonView = new DungeonView();

        dungeonView.getEnemyButton("Goblin").addActionListener(e -> startBattle("Goblin"));
        dungeonView.getEnemyButton("Wild Boar").addActionListener(e -> startBattle("Wild Boar"));
        dungeonView.getEnemyButton("Slime").addActionListener(e -> startBattle("Slime"));
        dungeonView.getEnemyButton("Ghoul").addActionListener(e -> startBattle("Ghoul"));
        dungeonView.getEnemyButton("Dragon").addActionListener(e -> startBattle("Dragon"));

        dungeonView.getBackButton().addActionListener(e -> {
            showMainMenuView();
            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(dungeonView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startBattle(String enemyName) {
        Enemy enemy = new Enemy("Goblin", 75, 30, 20, 3);

    

        JFrame frame = new JFrame("Battle");
        BattleView battleView = new BattleView(currentCharacter, enemy);

        battleView.getFightButton().addActionListener(e -> {
            int damageToEnemy = currentCharacter.getAtk() - (int)(enemy.getDef() * 0.5);
            int damageToCharacter = enemy.getAtk() - (int)(currentCharacter.getDef() * 0.4);

            enemy.setHp(enemy.getHp() - damageToEnemy);
            if (enemy.getHp() <= 0) {
                JOptionPane.showMessageDialog(frame, "You Kill " + enemy.getName());
                currentCharacter.setGold(currentCharacter.getGold() + enemy.getGold());
                characterDAO.updateCharacter(currentCharacter);
                frame.dispose();
                showMainMenuView();
                return;
            }

            JOptionPane.showMessageDialog(frame, "Enemy Attack, HP - " + damageToCharacter);
            currentCharacter.setHp(currentCharacter.getHp() - damageToCharacter);
            if (currentCharacter.getHp() <= 0) {
                JOptionPane.showMessageDialog(frame, "You Died");
                currentCharacter.setGold(0);
                characterDAO.updateCharacter(currentCharacter);
                frame.dispose();
                showMainMenuView();
                return;
            }
        });

        battleView.getHealButton().addActionListener(e -> {
            int healAmount = 5;
            if (currentCharacter.getHp() + healAmount > currentCharacter.getHp()) {
                currentCharacter.setHp(currentCharacter.getHp());
            } else {
                currentCharacter.setHp(currentCharacter.getHp() + healAmount);
            }
            JOptionPane.showMessageDialog(frame, "You Heal, HP + " + healAmount);
        });

        battleView.getRunButton().addActionListener(e -> {
            if (currentCharacter.getHp() >= 20) {
                showMainMenuView();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "You Can't Run");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(battleView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
