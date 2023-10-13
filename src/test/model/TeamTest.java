package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private Team t;

    @BeforeEach
    void runBefore() {
        t = new Team("Atlanta Hawks");
    }

    @Test
    void testConstructor() {
        assertEquals("Atlanta Hawks", t.getTeamName());
        assertEquals(0, t.getPlayers().size());
        assertEquals(0, t.getTotalSalary());
        assertEquals(165.294, t.getTaxLine());
    }

    @Test
    void testAddPlayerOnce() {
        Player p = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        t.addPlayer(p);
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(p);
        assertEquals(1,t.getPlayers().size());
        assertEquals(p,t.getPlayers().get(0));
    }

    @Test
    void testAddPlayerMultipleTimes() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.addPlayer(p1);
        t.addPlayer(p2);
        assertEquals(2,t.getPlayers().size());
        assertEquals(p1,t.getPlayers().get(0));
        assertEquals(p2,t.getPlayers().get(1));
    }

    @Test
    void testRemovePlayerOnce() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        t.removePlayer(p1);
        assertEquals(1,t.getPlayers().size());
        assertEquals(p2,t.getPlayers().get(0));
    }

    @Test
    void testRemovePlayerMultipleTimes() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        t.removePlayer(p1);
        t.removePlayer(p2);
        assertEquals(0,t.getPlayers().size());
    }

    @Test
    void testGetPlayer() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        assertEquals(p1, t.getPlayer(0));
        assertEquals(p2, t.getPlayer(1));
    }

    @Test
    void testGetTeamSize() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        assertEquals(2, t.getTeamSize());
    }

    @Test
    void testCalculateTotalSalaryOnePlayer() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        t.getPlayers().add(p1);
        t.calculateTotalSalary();
        assertEquals(40.064, t.getTotalSalary());
    }

    @Test
    void testCalculateTotalSalaryMultiplePlayers() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,40.064);
        Player p2 = new Player("Atlanta Hawks","Onyeka Okongwu","PF",
                22,206,108.9,8.109);
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        t.calculateTotalSalary();
        assertEquals(48.173, t.getTotalSalary());
    }

    @Test
    void testIsSalaryAboveTaxLineFalse() {
        Player p1 = new Player("Atlanta Hawks","Trae Young","PG",
                25,185,74.4,165.294);
        t.getPlayers().add(p1);
        t.calculateTotalSalary();
        assertFalse(t.isSalaryAboveTaxLine());
    }

    @Test
    void testIsSalaryAboveTaxLineTrue() {
        Player p1 = new Player("Atlanta Hawks", "Trae Young", "PG",
                25, 185, 74.4, 165.295);
        t.getPlayers().add(p1);
        t.calculateTotalSalary();
        assertTrue(t.isSalaryAboveTaxLine());
    }
}