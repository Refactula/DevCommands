package com.refactula.devcmd;

public class Player {

    public static final int MAX_HEALTH = 100;

    private final String name;

    private int health;

    private double stamina;

    private final DevCommands devCommands = new MyDevCommands();

    public Player(String name) {
        this.name = name;
    }

    void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, MAX_HEALTH));
    }

    void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public int getHealth() {
        return health;
    }

    public double getStamina() {
        return stamina;
    }

    public void say(String chatMessage) {
        if (devCommands.handle(chatMessage)) {
            return;
        }
        System.out.println(name + " says: " + chatMessage);
    }

    private class MyDevCommands extends DevCommands {

        public void heal() {
            heal(MAX_HEALTH);
        }

        public void heal(int amount) {
            Player.this.setHealth(health + amount);
        }

        public void setStamina(double value) {
            Player.this.setStamina(value);
        }

    }

}
