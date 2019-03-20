package model.role;

public abstract class Role {
    private String name;
    private int hitPoint;
    private int defense;
    private int damage;

    public Role(String name, int hitPoint, int defense, int damage) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.defense = defense;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
