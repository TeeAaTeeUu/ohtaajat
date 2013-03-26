package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaBookService implements BookService {
    
    @Autowired
    private BookRepository brepo;

    @Override
    public void create(Book book) {
        brepo.save(book);
    }

    @Override
    public List<Book> list() {
        return brepo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return brepo.findOne(id);
    }

    @Override
    public void delete(Long id) {
        brepo.delete(id);
    }
    
    
}
