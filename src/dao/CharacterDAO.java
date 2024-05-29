package dao;

import model.Character;
import utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterDAO {

    public void createCharacter(Character character) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "INSERT INTO karakter_db (account_id, job, hp, def, atk, gold) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, character.getAccountId());
            stmt.setString(2, character.getJob());
            stmt.setInt(3, character.getHp());
            stmt.setInt(4, character.getDef());
            stmt.setInt(5, character.getAtk());
            stmt.setInt(6, 0);  // Initial gold value
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Character getCharacterByAccountId(int accountId) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "SELECT * FROM karakter_db WHERE account_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                int nid  = rs.getInt("id");
                int naid = rs.getInt("account_id");
                String njob = rs.getString("job");
                int nhp = rs.getInt("hp");
                int ndef = rs.getInt("def");
                int natk = rs.getInt("atk");
                int ngold = rs.getInt("gold");
                Character character = new Character(nid, naid, njob, nhp, ndef, natk, ngold);
                return character;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCharacter(Character character) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "UPDATE karakter_db SET hp = ?, def = ?, atk = ?, gold = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, character.getHp());
            stmt.setInt(2, character.getDef());
            stmt.setInt(3, character.getAtk());
            stmt.setInt(4, character.getGold());
            stmt.setInt(5, character.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
