package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaArticeService implements ArticleService{

    @Autowired
    private ArticleRepository arepo;

    @Override
    @Transactional(readOnly = false)
    public void create(Article article) {
        arepo.save(article);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> list() {
        return arepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Article findById(Long id) {
        return arepo.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        arepo.delete(id);
    }

    @Override
    public List<Article> findByPartOfAuthor(String author) {
        return arepo.findByPartOfAuthor("%"+author+"%");
    }
}
