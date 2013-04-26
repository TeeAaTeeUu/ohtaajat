package ohtaajat.bibtex.viitehallinta.service;

import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.repositories.ArticleRepository;
import ohtaajat.bibtex.viitehallinta.service.JpaArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 *
 * @author Teemu
 */
public class JpaArticleRepository implements ArticleRepository {
    
    private List<Article> lista = new ArrayList<Article>();
    String arvo;
    public String palautaArvo(){
        return arvo;
    }
    @Override
    public <S extends Article> S save(S s) {
        lista.add(s);
        return s;
    }
    @Override
    public List<Article> findByPartOfAuthor(String author) {
        List<Article> lista = new ArrayList<Article>();
        this.arvo=author;
        return lista;
    }

    @Override
    public List<Article> findAll() {
        return lista;
        
    }

    @Override
    public List<Article> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public <S extends Article> List<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article saveAndFlush(Article t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Article> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Article> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Article findOne(Long id) {
        for (Article article : lista) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Article> findAll(Iterable<Long> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        return lista.size();
    }

    @Override
    public void delete(Long id) {
        int index = 0;
        for (Article article : lista) {
            if (article.getId() == id) {
                lista.remove(index);
                return;
            }
            index++;
        }
    }

    @Override
    public void delete(Article t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Article> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
