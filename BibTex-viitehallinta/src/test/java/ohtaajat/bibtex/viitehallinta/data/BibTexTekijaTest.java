package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.matchers.JUnitMatchers;

public class BibTexTekijaTest {

    BibTexTekija bibTex;
    String koodi;
    Book kirja1;
    Book kirja2;
    Book kirja3;
    Article artikkeli1;
    Article artikkeli2;
    ArrayList<Entry> viitteet;

    @Before
    public void setUp() {
        bibTex = new BibTexTekija();
        viitteet = new ArrayList<Entry>();

        kirja1 = new Book();    

        kirja1.setAuthor("L. S. Vygotsky");
        kirja1.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja1.setYear("1978");
        kirja1.setPublisher("Harvard University Press");
        kirja1.setAddress("Cambridge, MA");

        kirja2 = new Book();    

        kirja2.setAuthor("L. S. Vygotsky");
        kirja2.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja2.setYear("1978");
        kirja2.setPublisher("Harvard University Press");
        kirja2.setAddress("Cambridge, MA");
        
        artikkeli1 = new Article();

        artikkeli1.setAuthor("L. S. Vygotsky");
        artikkeli1.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        artikkeli1.setYear("1978");
        artikkeli1.setJournal("Harvard University Press journal");
        artikkeli1.setVolume("76th");
        
        artikkeli2 = new Article();

        artikkeli1.setAuthor("L. S. Vygotsky");
        artikkeli1.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        artikkeli1.setYear("1978");
        artikkeli1.setJournal("Harvard University Press journal");
        artikkeli1.setVolume("76th");

        kirja3 = new Book();

        kirja3.setAuthor("L. S. Vygotsky");
        kirja3.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja3.setYear("1978");
        kirja3.setPublisher("Harvard University Press");
        kirja3.setAddress("Cambridge, MA");

        viitteet.add(kirja1);
        viitteet.add(artikkeli1);
        
        bibTex.lisaaEntry(viitteet);
        
        bibTex.lisaaEntry(kirja2);
        bibTex.lisaaEntry(kirja3);
        
        
        koodi = bibTex.palautaBibTex();
    }

    @Test
    public void kirjanotsikotLoytyy() {     
        System.out.println(bibTex.palautaBibTex());

        assertThat(koodi, JUnitMatchers.containsString("@book{Vygotsky78"));
    }
    
    @Test
    public void  loytyyMyosArtikkeli() {     
        assertThat(koodi, JUnitMatchers.containsString("@article{Vygotsky78"));
    }
    
    @Test
    public void  nimiOtsikotOvatuniikkeja() {     
        assertThat(koodi, JUnitMatchers.containsString("Vygotsky78,"));
        assertThat(koodi, JUnitMatchers.containsString("Vygotsky78a,"));
        assertThat(koodi, JUnitMatchers.containsString("Vygotsky78b,"));
        assertThat(koodi, JUnitMatchers.containsString("Vygotsky78c,"));
    }
    
    @Test
    public void LoytyyKaikkiLaitetutTiedot() {
        assertThat(koodi, JUnitMatchers.containsString("year = {1978}"));
        assertThat(koodi, JUnitMatchers.containsString("author = {L. S. Vygotsky}"));
        assertThat(koodi, JUnitMatchers.containsString("title = {Mind in Society: The Development of Higher Psychological Processes}"));
        assertThat(koodi, JUnitMatchers.containsString("publisher = {Harvard University Press}"));
        assertThat(koodi, JUnitMatchers.containsString("address = {Cambridge, MA}"));
    }
}