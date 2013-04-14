package ohtaajat.bibtex.viitehallinta.repositories;

import ohtaajat.bibtex.viitehallinta.data.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article, Long> {
    
}
