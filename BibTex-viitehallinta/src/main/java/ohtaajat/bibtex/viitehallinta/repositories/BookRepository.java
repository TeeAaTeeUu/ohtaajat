package ohtaajat.bibtex.viitehallinta.repositories;

import ohtaajat.bibtex.viitehallinta.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    
}
