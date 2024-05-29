package dao;

import model.Account;
import utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    
    int id;
    String nusername;
    String npassword;
    boolean hasCharacter;
    
    public Account getAccount(String username, String password) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "SELECT * FROM akun_db WHERE username = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                id = rs.getInt("id");
                nusername = rs.getString("username");
                npassword = rs.getString("password");
                hasCharacter = rs.getBoolean("has_character");
                Account account = new Account(id, nusername, npassword, hasCharacter);
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createAccount(String username, String password) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "INSERT INTO akun_db (username, password) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHasCharacter(int accountId, boolean hasCharacter) {
        try (Connection connection = DBConnector.getConnection()) {
            String query = "UPDATE akun_db SET has_character = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setBoolean(1, hasCharacter);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
