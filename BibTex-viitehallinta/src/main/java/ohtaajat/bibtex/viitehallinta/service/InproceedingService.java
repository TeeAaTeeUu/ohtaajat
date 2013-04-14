package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;

public interface InproceedingService {

    void create(Inproceeding inproceeding);

    List<Inproceeding> list();

    Inproceeding findById(Long id);

    void delete(Long id);
}
