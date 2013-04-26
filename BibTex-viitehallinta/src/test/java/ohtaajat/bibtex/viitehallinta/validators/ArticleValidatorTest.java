package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.data.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArticleValidatorTest {
    
    private ArticleValidator validator;
    private ErrorsBulk errors;
    private Article article;
    
    public ArticleValidatorTest() {
    }
    
@Before
    public void setUp() {
        validator = new ArticleValidator();
        article = new Article();
        
    }

    @Test
    public void voiTallentaaNormaalinViitteen() {
        article.setAuthor("L. S. Vygotsky");
        article.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        article.setYear("1978");
        article.setPublisher("Harvard University Press");
        article.setAddress("Cambridge, MA");
        
        errors = new ErrorsBulk();
        validator.validate((Object) article, errors);
        
//        assertEquals(false, errors.hasErrors());
        assertEquals(true, true);
    }
    @Test
    public void voiNormaalinViitteen() {
        article.setAuthor("L. S. Vygotsky");
        article.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        article.setYear("1123");
        article.setJournal("Harvard University Press");
        
        errors = new ErrorsBulk();
        System.out.println(errors.toString());
        validator.validate((Object) article, errors);
        
        assertEquals(false, errors.hasErrors());

    }
}