package ohtaajat.bibtex.viitehallinta.data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.service.ArticleService;
import ohtaajat.bibtex.viitehallinta.service.JpaArticleService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JpaArticleServiceTest {

    private ArticleService service;
    private JpaArticleRepository arepo;

    @Before
    public void setUp() {
        arepo = new JpaArticleRepository();
        service = new JpaArticleService();
        Field field = null;
        try {
            field = service.getClass().getDeclaredField("arepo");
        } catch (NoSuchFieldException e) {
            System.out.println("Kenttää ei löydy");
        }
        field.setAccessible(true);
        try {
            field.set(service, arepo);
        } catch (IllegalAccessException e) {
            System.out.println("Ei oikeuksia");
        }

    }

    @Test
    public void createNewArticle() {

        Article article = new Article();


        article.setAuthor("Pekka Puupaa");
        article.setTitle("Pekka ja Patka");
        article.setYear("1989");
        article.setJournal("Otava");

        service.create(article);

        assertEquals(1, arepo.count());


    }

    @Test
    public void listArticleWorks() {
        Article article = new Article();

        article.setAuthor("Pekka Puupaa");
        article.setTitle("Pekka ja Patka");
        article.setYear("1989");
        article.setJournal("Otava");

        service.create(article);

        assertEquals(arepo.findAll(), service.list());

    }

    @Test
    public void findArticleByIdWorks() {
        Article article = new Article();
        
        article.setId((long) 1);
        article.setAuthor("Pekka Puupaa");
        article.setTitle("Pekka ja Patka");
        article.setYear("1989");
        article.setJournal("Otava");
        service.create(article);

        assertEquals(article, service.findById((long) 1));

    }
    @Test
    public void deleteArticleWorks(){
        Article article = new Article();
        
        article.setId((long) 1);
        article.setAuthor("Pekka Puupaa");
        article.setTitle("Pekka ja Patka");
        article.setYear("1989");
        article.setJournal("Otava");
        service.create(article);
        service.delete((long) 1);
        assertEquals(0, arepo.count());
    }

    
    @Test
    public void findBookByPartOfAuthorWorks(){
        Article article = new Article();
          
        article.setAuthor("Pekka Puupaa");
        article.setTitle("Pekka ja Patka");
        article.setYear("1989");
        article.setJournal("Otava");
        
        service.create(article);
        
        List<Article> list = new ArrayList<Article>();
        list = service.findByPartOfAuthor("Pekka Puupaa");
        String arvo = arepo.palautaArvo();
        
        assertEquals("%Pekka Puupaa%" , arvo);
    }
}
