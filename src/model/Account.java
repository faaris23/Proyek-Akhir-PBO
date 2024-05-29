package model;

public class Account {
    private int id;
    private String username;
    private String password;
    private boolean hasCharacter;

    //Contructors
    public Account(int id, String username, String password, boolean hasCharacter) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hasCharacter = hasCharacter;
    }

    //GETTER
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean isHasCharacter() {
        return hasCharacter;
    }

    //SETTER
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHasCharacter(boolean hasCharacter) {
        this.hasCharacter = hasCharacter;
    }

}
