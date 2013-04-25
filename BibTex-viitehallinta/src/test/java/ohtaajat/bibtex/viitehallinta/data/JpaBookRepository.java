/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.repositories.BookRepository;
import ohtaajat.bibtex.viitehallinta.service.JpaBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Tero
 */
public class JpaBookRepository implements BookRepository {

    private List<Book> lista = new ArrayList<Book>();
    String arvo;
    @Override
    public <S extends Book> S save(S s) {
        lista.add(s);
        return s;
    }

    @Override
    public <S extends Book> List<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String palautaArvo(){
        return arvo;
    }
    @Override
    public List<Book> findByPartOfAuthor(String author) {
        this.arvo = author;
        
        List<Book> list = new ArrayList<Book>();
        
        return list;
    }

    @Override
    public List<Book> findAll() {
        return lista;
    }

    @Override
    public List<Book> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book saveAndFlush(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Book> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Book> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book findOne(Long id) {
        for (Book book : lista) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Book> findAll(Iterable<Long> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        return lista.size();
    }

    @Override
    public void delete(Long id) {
        int index = 0;
        for (Book book : lista) {
            if (book.getId() == id) {
                lista.remove(index);
                return;
            }
            index++;
        }
    }

    @Override
    public void delete(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Book> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
