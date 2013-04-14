package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;

public interface BookService {
    void create(Book book);

    List<Book> list();

    Book findById(Long id);

    void delete(Long id);
}
