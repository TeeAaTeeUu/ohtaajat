package ohtaajat.bibtex.viitehallinta.repositories;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByAuthor(String author);
}
