package ohtaajat.bibtex.viitehallinta.data;

import java.lang.reflect.Field;
import ohtaajat.bibtex.viitehallinta.repositories.BookRepository;
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
    private JpaBookRepository brepo;
    @Before
    public void setUp() {
        brepo = new JpaBookRepository();
        service = new JpaBookService();
        Field field = null;
        try {
            field = service.getClass().getDeclaredField("brepo");
        } catch (NoSuchFieldException e) {
            System.out.println("Kenttää ei löydy");
        }
        field.setAccessible(true);
        try {
            field.set(service, brepo);
        } catch (IllegalAccessException e) {
            System.out.println("Ei oikeuksia");
        }
        
    }
    
    @Test
    public void createNewBook(){
         
        Book book = new Book();

        
        book.setAuthor("Pekka Puupaa");
        book.setTitle("Pekka ja Patka");
        book.setYear("1989");
        book.setPublisher("Otava");

        service.create(book);
        
        System.out.println(brepo.count());


    }
}