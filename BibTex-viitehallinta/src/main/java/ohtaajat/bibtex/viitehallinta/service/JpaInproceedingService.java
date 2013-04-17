package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import ohtaajat.bibtex.viitehallinta.repositories.InproceedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaInproceedingService implements InproceedingService {

    @Autowired
    private InproceedingRepository arepo;

    @Override
    @Transactional(readOnly = false)
    public void create(Inproceeding inproceeding) {
        arepo.save(inproceeding);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inproceeding> list() {
        return arepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Inproceeding findById(Long id) {
        return arepo.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        arepo.delete(id);
    }

    @Override
    public List<Inproceeding> findByAuthor(String author) {
        return arepo.findByAuthor(author);
    }
}
