package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleTest {
    
    Article artikkeli;

    @Before
    public void setUp() {
        artikkeli = new Article();
    }

    @Test
    public void voiTallentaaAuthor() {
        artikkeli.setAuthor("Harvard University Press");
        assertEquals("Harvard University Press", artikkeli.getAuthor());
    }
    
    @Test
    public void voiTallentaaMonth() {
        artikkeli.setMonth("9");
        assertEquals("9", artikkeli.getMonth());
    }
    
    @Test
    public void voiTallentaaTitle() {
        artikkeli.setTitle("kaljaasi reissu -julkaisu");
        assertEquals("kaljaasi reissu -julkaisu", artikkeli.getTitle());
    }
    
    @Test
    public void voiTallentaaJournal() {
        artikkeli.setJournal("third");
        assertEquals("third",  artikkeli.getJournal());
    }
    
    @Test
    public void voiTallentaaNote() {
        artikkeli.setNote("tärkeä kirja, muista etenkin se");
        assertEquals("tärkeä kirja, muista etenkin se",  artikkeli.getNote());
    }
    
    @Test
    public void voiTallentaaPages() {
        artikkeli.setPages("196 - 205");
        assertEquals("196 - 205", artikkeli.getPages());
    }
    
    @Test
    public void voiTallentaaNumber() {
        artikkeli.setNumber("76");
        assertEquals("76",  artikkeli.getNumber());
    }
    
    @Test
    public void voiAsettaaID() {
        artikkeli.setId(0x7234bL);
        assertEquals(new Long(0x7234bL), artikkeli.getId());
    }
    
  
}
