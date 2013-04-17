package ohtaajat.bibtex.viitehallinta.repositories;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InproceedingRepository extends JpaRepository<Inproceeding, Long> {

    List<Inproceeding> findByAuthor(String author);
}
