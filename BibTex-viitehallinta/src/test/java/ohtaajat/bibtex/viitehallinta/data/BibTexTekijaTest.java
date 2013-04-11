//package ohtaajat.bibtex.viitehallinta.data;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class BibTexTekijaTest {
//
//    BibTexTekija bibTex;
//    Book book1;
//    Book book2;
//    Book book3;
//    ArrayList<Book> books;
//
//    @Before
//    public void setUp() {
//        bibTex = new BibTexTekija();
//        books = new ArrayList<Book>();
//
//        List<Field> lista1 = new ArrayList<Field>();
//        List<Field> lista2 = new ArrayList<Field>();
//        List<Field> lista3 = new ArrayList<Field>();
//
//
//
//        lista1.add(new Field("author", "L. S. Vygotsky"));
//        lista1.add(new Field("title", "Mind in Society: The Development of Higher Psychological Processes"));
//        lista1.add(new Field("year", "1978"));
//        lista1.add(new Field("publisher", "Harvard University Press"));
//        lista1.add(new Field("address", "Cambridge, MA"));
//
//        book1 = new Book();
//        book1.setFields(lista1);
//
//        lista2.add(new Field("author", "L. S. Vygotsky"));
//        lista2.add(new Field("title", "Mind in Society: The Development of Higher Psychological Processes"));
//        lista2.add(new Field("year", "1978"));
//        lista2.add(new Field("publisher", "Harvard University Press"));
//        lista2.add(new Field("address", "Cambridge, MA"));
//
//        book2 = new Book();
//        book2.setFields(lista2);
//
//        lista3.add(new Field("author", "L. S. Vygotsky"));
//        lista3.add(new Field("title", "Mind in Society: The Development of Higher Psychological Processes"));
//        lista3.add(new Field("year", "1978"));
//        lista3.add(new Field("publisher", "Harvard University Press"));
//        lista3.add(new Field("address", "Cambridge, MA"));
//
//        book3 = new Book();
//        book3.setFields(lista3);
//
//        books.add(book1);
//        books.add(book2);
//
//        bibTex.lisaaBook(books);
//        bibTex.lisaaBook(book3);
//    }
//
//    @Test
//    public void bibTexTulostusToimii() {
//        System.out.println(bibTex.palautaBibTex());
//
//        assertEquals("@book{Vygotsky78,\n"
//                + "title = {Mind in Society: The Development of Higher Psychological Processes},\n"
//                + "year = {1978},\n"
//                + "author = {L. S. Vygotsky},\n"
//                + "publisher = {Harvard University Press},\n"
//                + "address = {Cambridge, MA},\n"
//                + "}\n"
//                + "\n"
//                + "@book{Vygotsky78a,\n"
//                + "title = {Mind in Society: The Development of Higher Psychological Processes},\n"
//                + "year = {1978},\n"
//                + "author = {L. S. Vygotsky},\n"
//                + "publisher = {Harvard University Press},\n"
//                + "address = {Cambridge, MA},\n"
//                + "}\n"
//                + "\n"
//                + "@book{Vygotsky78b,\n"
//                + "title = {Mind in Society: The Development of Higher Psychological Processes},\n"
//                + "year = {1978},\n"
//                + "author = {L. S. Vygotsky},\n"
//                + "publisher = {Harvard University Press},\n"
//                + "address = {Cambridge, MA},\n"
//                + "}\n"
//                + "\n", bibTex.palautaBibTex());
//    }
//}