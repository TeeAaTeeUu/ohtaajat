package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTexTest {
    
    BibTex bibTex;

    @Before
    public void setUp() {
        bibTex = new BibTex();
    }

    @Test
    public void umlautDegeneratorToimii() {
        String testi = bibTex.umlautDegenerator("tåsti nukke Änkö");
        System.out.println(testi);
        assertEquals("t{\\aa}sti nukke {\\\"A}nk{\\\"o}", testi);
    }
}