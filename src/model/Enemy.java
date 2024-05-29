package model;

public class Enemy {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Enemy(String name, int hp, int def, int atk, int gold) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.atk = atk;
        this.gold = gold;
    }

    
}
