package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleTest {
    
    Simple simple;

    @Before
    public void setUp() {
        simple = new Simple();
    }

    @Test
    public void voiTallentaaTitle() {
        simple.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        assertEquals("Mind in Society: The Development of Higher Psychological Processes", simple.getTitle());
    }
    
    @Test
    public void voiTallentaaAuthor() {
        simple.setAuthor("L. S. Vygotsky");
        assertEquals("L. S. Vygotsky", simple.getAuthor());
    }
    
    @Test
    public void voiTallentaaYear() {
        simple.setYear(1976);
        assertEquals(1976, simple.getYear());
    }
    
    @Test
    public void TitlenTallennusRekisteroityy() {
        simple.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        assertEquals(true, simple.isTitleSet());
    }
    
    @Test
    public void AuthorinTallennusRekisteroityy() {
        simple.setAuthor("L. S. Vygotsky");
        assertEquals(true, simple.isAuthorSet());
    }
    
    @Test
    public void YearinTallennusRekisteroityy() {
        simple.setYear(1976);
        assertEquals(true, simple.isYearSet());
    }
    
    @Test
    public void TitleVakionaEiAsetettu() {
        simple.setAuthor("Mind in Society: The Development of Higher Psychological Processes");
        assertEquals(false, simple.isTitleSet());
    }
    
    @Test
    public void AuthorVakionaEiAsetettu() {
        simple.setTitle("L. S. Vygotsky");
        assertEquals(false, simple.isAuthorSet());
    }
    
    @Test
    public void YearVakionaEiAsetettu() {
        simple.setTitle("year of 1976");
        assertEquals(false, simple.isYearSet());
    }
}
