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
        kirja.setPublisher("Harvard University Press");
        assertEquals("Harvard University Press", kirja.getPublisher());
    }
    
    @Test
    public void voiTallentaaMonth() {
        kirja.setMonth(9);
        assertEquals(9, kirja.getMonth());
    }
    
    @Test
    public void voiTallentaaSeries() {
        kirja.setSeries("kaljaasi reissu -julkaisu");
        assertEquals("kaljaasi reissu -julkaisu", kirja.getSeries());
    }
    
    @Test
    public void voiTallentaaEdition() {
        kirja.setEdition("third");
        assertEquals("third", kirja.getEdition());
    }
    
    @Test
    public void voiTallentaaNote() {
        kirja.setNote("tärkeä kirja, muista etenkin se");
        assertEquals("tärkeä kirja, muista etenkin se", kirja.getNote());
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
        kirja.setId(0x7234bL);
        assertEquals(new Long(0x7234bL), kirja.getId());
    }
    
    @Test
    public void eiHyvaksyVajaata() {
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
    public void eiHyvaksyIlmanAuthorTaiEditor() {
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setAddress("Cambridge, MA");
        kirja.setPublisher("Harvard University Press");
        kirja.setYear(1978);
        assertEquals(false, kirja.onKaikkipakollinen());
    }
    
    @Test
    public void addressinTallennusRekisteroityy() {
        kirja.setAddress("Hienon miehen tie 3 ??");
        assertEquals(true, kirja.isAddressSet());
    }

    @Test
    public void editionTallennusRekisteroityy() {
        kirja.setEdition("3th");
        assertEquals(true, kirja.isEditionSet());
    }

    @Test
    public void editorTallennusRekisteroityy() {
        kirja.setEditor("Mestarilaulaja Seppo");
        assertEquals(true, kirja.isEditorSet());
    }
    
    @Test
    public void monthinTallennusRekisteroityy() {
        kirja.setMonth(7);
        assertEquals(true, kirja.isMonthSet());
    }

    @Test
    public void notenTallennusRekisteroityy() {
        kirja.setNote("3th");
        assertEquals(true, kirja.isNoteSet());
    }

    @Test
    public void publisherinTallennusRekisteroityy() {
        kirja.setPublisher("Mestarijulkaisija Tapio");
        assertEquals(true, kirja.isPublisherSet());
    }
    
    @Test
    public void seriesinTallennusRekisteroityy() {
        kirja.setSeries("kalajulkaisut");
        assertEquals(true, kirja.isSeriesSet());
    }

    @Test
    public void publisherVakionaEiAsetettu() {
        kirja.setTitle("Mestarijulkaisija Tapio");
        assertEquals(false, kirja.isPublisherSet());
    }
    
    @Test
    public void addressVakionaEiAsetettu() {
        kirja.setPublisher("Hienon miehen tie 3 ??");
        assertEquals(false, kirja.isAddressSet());
    }

    @Test
    public void editionVakionaEiAsetettu() {
        kirja.setEditor("3th");
        assertEquals(false, kirja.isEditionSet());
    }

    @Test
    public void editorVakionaEiAsetettu() {
        kirja.setEdition("Mestarilaulaja Seppo");
        assertEquals(false, kirja.isEditorSet());
    }
    
    @Test
    public void monthVakionaEiAsetettu() {
        kirja.setYear(7);
        assertEquals(false, kirja.isMonthSet());
    }

    @Test
    public void noteVakionaEiAsetettu() {
        kirja.setPublisher("3th");
        assertEquals(false, kirja.isNoteSet());
    }
    
    @Test
    public void seriesVakionaEiAsetettu() {
        kirja.setNote("kalajulkaisut");
        assertEquals(false, kirja.isSeriesSet());
    }
}
