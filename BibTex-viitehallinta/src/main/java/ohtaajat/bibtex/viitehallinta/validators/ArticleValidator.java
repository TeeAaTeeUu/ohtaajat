package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Article;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "articleValidator")
public class ArticleValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Article.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        BookFormObject book = (BookFormObject) o;
//        onKaikkiPakollinen(book, errors);
    }

    public void onKaikkiPakollinen(Article article, Errors errors) {
//        if(book.getTitle().isEmpty()){
//            errors.rejectValue("title", "virheellinen_arvo", "virheellinen arvo");
//        }
    }
}
