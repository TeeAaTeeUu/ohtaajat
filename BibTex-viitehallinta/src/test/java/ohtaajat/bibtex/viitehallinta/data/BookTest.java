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
    public void voiTallentaaTitle() {
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        assertEquals("Mind in Society: The Development of Higher Psychological Processes", kirja.getTitle());
    }
    
    @Test
    public void voiTallentaaAuthor() {
        kirja.setAuthor("L. S. Vygotsky");
        assertEquals("L. S. Vygotsky", kirja.getAuthor());
    }
    
    @Test
    public void voiTallentaaPublisher() {
        kirja.setPublisher("Harvard University Press");
        assertEquals("Harvard University Press", kirja.getPublisher());
    }
    
    @Test
    public void voiTallentaaYear() {
        kirja.setYear(1978);
        assertEquals(1978, kirja.getYear());
    }
    
    @Test
    public void voiTallentaaAddress() {
        kirja.setAddress("Cambridge, MA");
        assertEquals("Cambridge, MA", kirja.getAddress());
    }
    
    @Test
    public void voiTallentaaEditor() {
        kirja.setEditor("mommo mies");
        assertEquals("mommo mies", kirja.getEditor());
    }
    
    @Test
    public void voiAsettaaID() {
        kirja.setId(567575);
        assertEquals(567575, kirja.getId());
    }
    
    @Test
    public void EiHyvaksyVajaata() {
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setAddress("Cambridge, MA");
        kirja.setPublisher("Harvard University Press");
        assertEquals(false, kirja.onKaikkipakollinen());
    }
    
    @Test
    public void onKaikkiPakollinenHyvaksyyKunnollisen() {
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setAddress("Cambridge, MA");
        kirja.setPublisher("Harvard University Press");
        kirja.setYear(1978);
        kirja.setAuthor("L. S. Vygotsky");
        assertEquals(true, kirja.onKaikkipakollinen());
    }
    
    @Test
    public void EiHyvaksyIlmanAuthorTaiEditor() {
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setAddress("Cambridge, MA");
        kirja.setPublisher("Harvard University Press");
        kirja.setYear(1978);
        assertEquals(false, kirja.onKaikkipakollinen());
    }
}
