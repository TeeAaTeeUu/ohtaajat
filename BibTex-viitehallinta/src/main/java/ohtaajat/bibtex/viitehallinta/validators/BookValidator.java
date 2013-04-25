package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "bookValidator")
public class BookValidator extends Reference implements Validator{

    public BookValidator() {
        this.saaSisaltaaVain.add("author");
        this.saaSisaltaaVain.add("editor");
        this.saaSisaltaaVain.add("title");
        this.saaSisaltaaVain.add("publisher");
        this.saaSisaltaaVain.add("year");
        this.saaSisaltaaVain.add("volume");
        this.saaSisaltaaVain.add("series");
        this.saaSisaltaaVain.add("address");
        this.saaSisaltaaVain.add("edition");
        this.saaSisaltaaVain.add("month");
        this.saaSisaltaaVain.add("note");
        this.saaSisaltaaVain.add("key");
        
        this.pitaaSisaltaaVainJokin.add("author");
        this.pitaaSisaltaaVainJokin.add("editor");

        this.pitaaSisaltaa.add("title");
        this.pitaaSisaltaa.add("publisher");
        this.pitaaSisaltaa.add("year");
    }

    @Override
    public boolean supports(Class<?> type) {
        return Book.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        onkoKaikkiOikein(book, errors);
    }
}
