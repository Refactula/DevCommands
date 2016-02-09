package com.refactula.devcmd;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCommandsTest {

    private final Player player = new Player("Tester");

    @Test
    public void testHeal() {
        player.setHealth(45);
        assertEquals(45, player.getHealth());

        player.say("/heal");
        assertEquals(Player.MAX_HEALTH, player.getHealth());
    }

    @Test
    public void testHealAmount() {
        player.setHealth(5);
        assertEquals(5, player.getHealth());

        player.say("/heal 1");
        assertEquals(6, player.getHealth());
    }

    @Test
    public void testSetStamina() {
        player.setStamina(0.4);
        assertEquals(0.4, player.getStamina(), 0.0001);

        player.say("/set stamina 0.7");
        assertEquals(0.7, player.getStamina(), 0.0001);
    }

}
