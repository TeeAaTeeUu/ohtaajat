package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;

public interface BookService {
    void create(Book book);

    List<Book> list();

    Book findById(Long id);

    List<Book> findByAuthor(String author);
    
    void delete(Long id);
}
