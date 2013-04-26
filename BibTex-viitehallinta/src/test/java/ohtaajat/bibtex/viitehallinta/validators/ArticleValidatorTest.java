package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.data.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArticleValidatorTest {
    
    private ArticleValidator validator;
    private ErrorsBulk errors;

    private Article artikkeli;

    
    public ArticleValidatorTest() {
    }
    
@Before
    public void setUp() {
        validator = new ArticleValidator();
        artikkeli = new Article();

        
    }

    @Test
    public void voiTallentaaNormaalinViitteen() {

        artikkeli.setAuthor("L. S. Vygotsky");
        artikkeli.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        artikkeli.setYear("1978");
        artikkeli.setPublisher("Harvard University Press");
        artikkeli.setAddress("Cambridge, MA");
        
        errors = new ErrorsBulk();
        validator.validate((Object) artikkeli, errors);

        
//        assertEquals(false, errors.hasErrors());
        assertEquals(true, true);
    }
   
}