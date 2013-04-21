package ohtaajat.bibtex.viitehallinta.repositories;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InproceedingRepository extends JpaRepository<Inproceeding, Long> {

    @Query("SELECT i FROM Inproceeding i WHERE i.author LIKE ?1")
    List<Inproceeding> findByPartOfAuthor(String author);
}
