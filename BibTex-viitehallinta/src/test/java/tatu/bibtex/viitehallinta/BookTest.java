package tatu.bibtex.viitehallinta;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    
    Book kirja;

    @Before
    public void setUp() {
        kirja = new Book();
        
        kirja.tallennaAuthor("L. S. Vygotsky");
        kirja.tallennaTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.tallennaPublisher("Harvard University Press");
        kirja.tallennaYear(1978);
//        kirja.tallennaAddress("Cambridge, MA");
    }

    @Test
    public void eiTulostaJosEiKaikkiPakollinen() {
        assertEquals("", kirja.bookToBibTex());
    }
    
    @Test
    public void tulostaaOikein() {
        kirja.tallennaAddress("Cambridge, MA");
        System.out.println(kirja.bookToBibTex());
        
        assertEquals("@book{xd96\n" +
                    "author = {L. S. Vygotsky},\n" +
                    "title = {Mind in Society: The Development of Higher Psychological Processes},\n" +
                    "publisher = {Harvard University Press},\n" +
                    "year = {1978},\n" +
                    "address = {Cambridge, MA},\n" +
                    "}", kirja.bookToBibTex());
    }
}
