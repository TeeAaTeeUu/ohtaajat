package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.matchers.JUnitMatchers;

public class BookTest {
    
    Book kirja;

    @Before
    public void setUp() {
        kirja = new Book();
    }

    
    @Test
    public void voiTallentaaPublisher() {
        kirja.setPublisher("Harvard University Press");
        assertEquals("Harvard University Press", kirja.getPublisher());
    }
    
    @Test
    public void voiTallentaaMonth() {
        kirja.setMonth("9");
        assertEquals("9", kirja.getMonth());
    }
    
    @Test
    public void voiTallentaaSeries() {
        kirja.setSeries("kaljaasi reissu -julkaisu");
        assertEquals("kaljaasi reissu -julkaisu", kirja.getSeries());
    }
    
    @Test
    public void voiTallentaaEdition() {
        kirja.setEdition("third");
        assertEquals("third",  kirja.getEdition());
    }
    
    @Test
    public void voiTallentaaNote() {
        kirja.setNote("tärkeä kirja, muista etenkin se");
        assertEquals("tärkeä kirja, muista etenkin se",  kirja.getNote());
    }
    
    @Test
    public void voiTallentaaAddress() {
        kirja.setAddress("Cambridge, MA");
        assertEquals("Cambridge, MA", kirja.getAddress());
    }
    
    @Test
    public void voiTallentaaEditor() {
        kirja.setEditor("mommo mies");
        assertEquals("mommo mies",  kirja.getEditor());
    }
    
    @Test
    public void voiTallentaaKey() {
        kirja.setKey("Cambridge news");
        assertEquals("Cambridge news",  kirja.getKey());
    }
    
    @Test
    public void voiAsettaaID() {
        kirja.setId(0x7234bL);
        assertEquals(new Long(0x7234bL), kirja.getId());
    }
    
    @Test
    public void toStringToimii() {
        kirja.setAuthor("L. S. Vygotsky");
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setYear("1978");
        kirja.setPublisher("Harvard University Press");
        kirja.setAddress("Cambridge, MA");
        
        assertThat(kirja.toString(), JUnitMatchers.containsString("<tr><td>author</td><td>:</td><td>L. S. Vygotsky</td></tr>"));
    }
    
  
}
