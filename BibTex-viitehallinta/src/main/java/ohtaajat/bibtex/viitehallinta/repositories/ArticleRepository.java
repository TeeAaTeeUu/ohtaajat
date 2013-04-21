package ohtaajat.bibtex.viitehallinta.repositories;

import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository  extends JpaRepository<Article, Long> {
    
    @Query("SELECT a FROM Article a WHERE a.author LIKE ?1")
    List<Article> findByPartOfAuthor(String author);
}
