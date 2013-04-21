package ohtaajat.bibtex.viitehallinta.repositories;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b WHERE b.author LIKE ?1")
    List<Book> findByPartOfAuthor(String author);
}
