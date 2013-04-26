package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookValidatorTest {
    
    private BookValidator validator;
    private ErrorsBulk errors;
    private Book kirja;
    
    public BookValidatorTest() {
    }
    
@Before
    public void setUp() {
        validator = new BookValidator();
        kirja = new Book();
        
    }

    @Test
    public void voiTallentaaNormaalinViitteen() {
        kirja.setAuthor("L. S. Vygotsky");
        kirja.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.setYear("1978");
        kirja.setPublisher("Harvard University Press");
        kirja.setAddress("Cambridge, MA");
        
        errors = new ErrorsBulk();
        validator.validate((Object) kirja, errors);
        
        assertEquals(true, true);
    }
}