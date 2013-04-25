package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Article;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "articleValidator")
public class ArticleValidator extends Reference implements Validator {
    
    public ArticleValidator() {
        this.saaSisaltaaVain.add("author");
        this.saaSisaltaaVain.add("title");
        this.saaSisaltaaVain.add("journal");
        this.saaSisaltaaVain.add("year");
        this.saaSisaltaaVain.add("volume");
        this.saaSisaltaaVain.add("number");
        this.saaSisaltaaVain.add("pages");
        this.saaSisaltaaVain.add("month");
        this.saaSisaltaaVain.add("note");
        this.saaSisaltaaVain.add("key");

        this.pitaaSisaltaa.add("author");
        this.pitaaSisaltaa.add("title");
        this.pitaaSisaltaa.add("journal");
        this.pitaaSisaltaa.add("year");
    }

    @Override
    public boolean supports(Class<?> type) {
        return Article.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Article artikkeli = (Article) o;
        onkoKaikkiOikein(artikkeli, errors);
    }
}
