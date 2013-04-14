package ohtaajat.bibtex.viitehallinta.repositories;

import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InproceedingRepository  extends JpaRepository<Inproceeding, Long> {
    
}
