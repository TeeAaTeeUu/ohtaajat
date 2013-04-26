package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class InproceedingValidatorTest {
    
    private InproceedingValidator validator;
    private ErrorsBulk errors;
    private Inproceeding inproceeding;
    
    public InproceedingValidatorTest() {
    }
    
@Before
    public void setUp() {
        validator = new InproceedingValidator();
        inproceeding = new Inproceeding();
        
    }

    @Test
    public void voiTallentaaNormaalinViitteen() {
        inproceeding.setAuthor("L. S. Vygotsky");
        inproceeding.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        inproceeding.setYear("1978");
        inproceeding.setPublisher("Harvard University Press");
        inproceeding.setAddress("Cambridge, MA");
        
        errors = new ErrorsBulk();
        validator.validate((Object) inproceeding, errors);
        
        assertEquals(false, false);
    }
}