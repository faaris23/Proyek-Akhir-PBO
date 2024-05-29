package model;

public class Character {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int accountId;
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    private String job;
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private int hp;
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private int def;
    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    private int atk;
    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    private int gold;
    
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Character(int id, int accountId, String job, int hp, int def, int atk, int gold) {
        this.id = id;
        this.accountId = accountId;
        this.job = job;
        this.hp = hp;
        this.def = def;
        this.atk = atk;
        this.gold = gold;
    }

}
