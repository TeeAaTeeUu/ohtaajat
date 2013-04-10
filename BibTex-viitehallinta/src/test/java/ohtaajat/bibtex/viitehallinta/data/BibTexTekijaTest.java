package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTexTekijaTest {
    
    BibTexTekija bibTex;
    Book book1;
    Book book2;
    Book book3;
    ArrayList<Book> books;

    @Before
    public void setUp() {
        bibTex = new BibTexTekija();
        books = new ArrayList<Book>();
        
        book1 = new Book();
        
        book1.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        book1.setAddress("Cambridge, MA");
        book1.setPublisher("Harvard University Press");
        book1.setYear(1978);
        book1.setAuthor("L. S. Vygotsky");

        book2 = new Book();

        book2.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        book2.setAddress("Cambridge, MA");
        book2.setPublisher("Harvard University Press");
        book2.setYear(1978);
        book2.setAuthor("L. S. Vygotsky");
        
        book3 = new Book();

        book3.setTitle("Mind in Society: The Development of Higher Psychological Processes");
        book3.setAddress("Cambridge, MA");
        book3.setPublisher("Harvard University Press");
        book3.setYear(1978);
        book3.setAuthor("L. S. Vygotsky");

        books.add(book1);
        books.add(book2);
        
        bibTex.lisaaBook(books);
        bibTex.lisaaBook(book3);
    }


    @Test
    public void bibTexTulostusToimii() {
        System.out.println(bibTex.palautaBibTex());
        
        assertEquals("@book{Vygotsky78,\n" +
"title = {Mind in Society: The Development of Higher Psychological Processes},\n" +
"year = {1978},\n" +
"author = {L. S. Vygotsky},\n" +
"publisher = {Harvard University Press},\n" +
"address = {Cambridge, MA},\n" +
"}\n" +
"\n" +
"@book{Vygotsky78a,\n" +
"title = {Mind in Society: The Development of Higher Psychological Processes},\n" +
"year = {1978},\n" +
"author = {L. S. Vygotsky},\n" +
"publisher = {Harvard University Press},\n" +
"address = {Cambridge, MA},\n" +
"}\n" +
"\n" +
"@book{Vygotsky78b,\n" +
"title = {Mind in Society: The Development of Higher Psychological Processes},\n" +
"year = {1978},\n" +
"author = {L. S. Vygotsky},\n" +
"publisher = {Harvard University Press},\n" +
"address = {Cambridge, MA},\n" +
"}\n" +
"\n", bibTex.palautaBibTex());
    }
}