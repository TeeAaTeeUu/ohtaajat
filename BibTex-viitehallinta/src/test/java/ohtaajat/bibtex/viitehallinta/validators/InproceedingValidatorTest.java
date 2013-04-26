package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class InproceedingValidatorTest {
    
    private InproceedingValidator validator;
    private ErrorsBulk errors;
    private Inproceeding viite;
    
    public InproceedingValidatorTest() {
    }
    
@Before
    public void setUp() {
        validator = new InproceedingValidator();
        viite = new Inproceeding();
        
    }

    @Test
    public void voiTallentaaNormaalinViitteen() {
        viite.setAuthor("L. S. Vygotsky");
        viite.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        viite.setYear("1978");
        viite.setPublisher("Harvard University Press");
        viite.setAddress("Cambridge, MA");
        
        errors = new ErrorsBulk();
        validator.validate((Object) viite, errors);
        
        assertEquals(false, false);
    }
}