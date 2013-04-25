/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.repositories.InproceedingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Teemu
 */
public class JpaInproceedingRepository implements InproceedingRepository {

    private List<Inproceeding> lista = new ArrayList<Inproceeding>();
    String arvo;

    @Override
    public List<Inproceeding> findByPartOfAuthor(String author) {
        this.arvo = author;
        List<Inproceeding> list = new ArrayList<Inproceeding>();

        return list;
    }

    @Override
    public List<Inproceeding> findAll() {
        return lista;
    }

    @Override
    public List<Inproceeding> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Inproceeding> List<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inproceeding saveAndFlush(Inproceeding t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Inproceeding> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Inproceeding> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Inproceeding> S save(S s) {
        lista.add(s);
        return s;
    }

    @Override
    public Inproceeding findOne(Long id) {
        for (Inproceeding inproceeding : lista) {
            if (inproceeding.getId() == id) {
                return inproceeding;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Inproceeding> findAll(Iterable<Long> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        return lista.size();
    }

    @Override
    public void delete(Long id) {
        int index = 0;
        for (Inproceeding inproceeding : lista) {
            if (inproceeding.getId() == id) {
                lista.remove(index);
                return;
            }
            index++;
        }
    }

    @Override
    public void delete(Inproceeding t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Inproceeding> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String palautaArvo() {
        return arvo;
    }
}
