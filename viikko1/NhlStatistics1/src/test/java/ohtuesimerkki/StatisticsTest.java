/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lbsarast
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchTest() {
        Player testplayer = new Player("Semenko", "EDM", 4, 12 );
        assertEquals("EDM", stats.search("Semenko").getTeam());
        assertEquals(12, stats.search("Semenko").getAssists());
        
        assertEquals(null, stats.search("Null"));
    }
    
    @Test
    public void teamTest() {
        assertEquals("Lemieux", stats.team("PIT").get(0).getName());
        
        assertEquals("Semenko", stats.team("EDM").get(0).getName());
        assertEquals("Kurri", stats.team("EDM").get(1).getName());
        assertEquals("Gretzky", stats.team("EDM").get(2).getName());
        
        //assertEquals(null, stats.search("Null"));
    }
    
    @Test
    public void topScorersTest() {
        List<Player> test_array = stats.topScorers(1);
        assertEquals(124, test_array.get(0).getPoints());
        
        List<Player> test_array2 = stats.topScorers(4);
        assertEquals(124, test_array2.get(0).getPoints());
        assertEquals(99, test_array2.get(1).getPoints());
        assertEquals(98, test_array2.get(2).getPoints());
        assertEquals(90, test_array2.get(3).getPoints());
        
        //assertEquals(null, stats.search("Null"));
    }
}
