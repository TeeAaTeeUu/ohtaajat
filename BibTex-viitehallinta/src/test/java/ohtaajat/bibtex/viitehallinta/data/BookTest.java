package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    
    Book kirja;

    @Before
    public void setUp() {
        kirja = new Book();
    }

    
    @Test
    public void voiTallentaaPublisher() {
        kirja.addField(new Field("publisher", "Harvard University Press"));
        assertEquals("Harvard University Press", kirja.getFieldValue("publisher"));
    }
    
    @Test
    public void voiTallentaaMonth() {
        kirja.addField(new Field("month", "9"));
        assertEquals("9", kirja.getFieldValue("month"));
    }
    
    @Test
    public void voiTallentaaSeries() {
        kirja.addField(new Field("series", "kaljaasi reissu -julkaisu"));
        assertEquals("kaljaasi reissu -julkaisu", kirja.getFieldValue("series"));
    }
    
    @Test
    public void voiTallentaaEdition() {
        kirja.addField(new Field("edition", "third"));
        assertEquals("third",  kirja.getFieldValue("edition"));
    }
    
    @Test
    public void voiTallentaaNote() {
        kirja.addField(new Field("note", "tärkeä kirja, muista etenkin se"));
        assertEquals("tärkeä kirja, muista etenkin se",  kirja.getFieldValue("note"));
    }
    
    @Test
    public void voiTallentaaAddress() {
        kirja.addField(new Field("address", "Cambridge, MA"));
        assertEquals("Cambridge, MA", kirja.getFieldValue("address"));
    }
    
    @Test
    public void voiTallentaaEditor() {
        kirja.addField(new Field("editor", "mommo mies"));
        assertEquals("mommo mies",  kirja.getFieldValue("editor"));
    }
    
    @Test
    public void voiAsettaaID() {
        kirja.setId(0x7234bL);
        assertEquals(new Long(0x7234bL), kirja.getId());
    }
    
  
}
