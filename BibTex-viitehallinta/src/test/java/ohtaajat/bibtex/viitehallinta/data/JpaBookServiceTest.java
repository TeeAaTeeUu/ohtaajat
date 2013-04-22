package ohtaajat.bibtex.viitehallinta.data;

import java.lang.reflect.Field;
import ohtaajat.bibtex.viitehallinta.service.BookService;
import ohtaajat.bibtex.viitehallinta.service.JpaBookService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JpaBookServiceTest {

    private BookService service;

    @Before
    public void setUp() {
        System.out.println("jep");
        service = new JpaBookService();
        Field field = null;
        try {
            field = service.getClass().getDeclaredField("brepo");
        } catch (NoSuchFieldException e) {
            System.out.println("Kenttää ei löydy");
        }
        field.setAccessible(true);
        try {
            field.set(service, new JpaBookRepository());
        } catch (IllegalAccessException e) {
            System.out.println("Ei oikeuksia");
        }
        System.out.println("ok");
    }
    
    @Test
    public void testaa(){
        
    }
}