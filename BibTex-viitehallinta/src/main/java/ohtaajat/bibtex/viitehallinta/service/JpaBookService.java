package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaBookService implements BookService {
    
    @Autowired
    private BookRepository brepo;

    @Override
    @Transactional(readOnly = false)
    public void create(Book book) {
        brepo.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> list() {
        return brepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return brepo.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        brepo.delete(id);
    }
    
    
}
