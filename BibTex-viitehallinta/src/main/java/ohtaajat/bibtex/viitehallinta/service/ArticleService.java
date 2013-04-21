package ohtaajat.bibtex.viitehallinta.service;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;

public interface ArticleService {

    void create(Article article);

    List<Article> list();
    
    List<Article> findByPartOfAuthor(String author);

    Article findById(Long id);

    void delete(Long id);
}
