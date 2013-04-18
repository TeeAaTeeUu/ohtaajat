package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InproceedingTest {
    
    Inproceeding konferenssiJulkaisu;

    @Before
    public void setUp() {
        konferenssiJulkaisu = new Inproceeding();
    }

    @Test
    public void voiTallentaaBookTitle() {
        konferenssiJulkaisu.setBooktitle("Harvard University Press");
        assertEquals("Harvard University Press", konferenssiJulkaisu.getBooktitle());
    }
    
    @Test
    public void voiTallentaaOrganization() {
        konferenssiJulkaisu.setOrganization("Harvard University Press");
        assertEquals("Harvard University Press", konferenssiJulkaisu.getOrganization());
    } 
  
}
