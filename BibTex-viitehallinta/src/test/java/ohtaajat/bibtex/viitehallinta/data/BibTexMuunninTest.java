package ohtaajat.bibtex.viitehallinta.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTexMuunninTest {
    
    BibTexMuunnin bibTex;

    @Before
    public void setUp() {
        bibTex = new BibTexMuunnin();
    }

//    @Test
//    public void umlautDegeneratorToimii() {
//        String testi = bibTex.tagToBibTex("year", "tåsti nukke Änkö");
//        System.out.println(testi);
//        assertEquals("year = {t{\\aa}sti nukke {\\\"A}nk{\\\"o}}," + "\n", testi);
//    }
//    
//    @Test
//    public void umlautDegeneratorToimii2() {
//        String testi = bibTex.tagToBibTex("month", 8);
//        System.out.println(testi);
//        assertEquals("month" + " = {" + 8 + "}," + "\n", testi);
//    }
    @Test
    public void test(){
        
    }
}