package ohtaajat.bibtex.viitehallinta.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ohtaajat.bibtex.viitehallinta.data.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "bookValidator")
public class BookValidator implements Validator {

    ArrayList<String> pitaaSisaltaa;
    ArrayList<String> pitaaSisaltaaVainJokin;
    HashMap<String, Boolean> asetettu;

    public BookValidator() {
        this.asetettu = new HashMap<String, Boolean>();
        this.pitaaSisaltaaVainJokin = new ArrayList<String>();
        this.pitaaSisaltaa = new ArrayList<String>();
        
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
        onKaikkiPakollinen(book, errors);
    }

    private void onKaikkiPakollinen(Book book, Errors errors) {
        

        HashMap<String, String> kaikkiEntryt = book.toMap();

        for (String tarkistettava : this.pitaaSisaltaa) {
            if (kaikkiEntryt.containsKey(tarkistettava) == false || kaikkiEntryt.get(tarkistettava).length() == 0) {
                errors.rejectValue(tarkistettava, "virheellinen_arvo", tarkistettava + " oli tyhjä.");
            }
        }

        int kuinkaMontaLoytyy = 0;
        for (String tarkistettava : this.pitaaSisaltaaVainJokin) {
            if (kaikkiEntryt.containsKey(tarkistettava) == true && kaikkiEntryt.get(tarkistettava).length() > 0) {
                ++kuinkaMontaLoytyy;
            }
        }
        if (kuinkaMontaLoytyy != 1) {
            String errorTuloste = "";
            boolean ekaKerta = true;
            for (String entry : pitaaSisaltaaVainJokin) {
                if (ekaKerta == false) {
                    errorTuloste += " tai ";
                } else {
                    ekaKerta = false;
                }
                errorTuloste += entry;
            }

            errors.rejectValue(this.pitaaSisaltaaVainJokin.get(0), "virheellinen_arvo", "Vain jokin näistä voidaan asettaa kerrallaan: " + errorTuloste);
        }
    }
}
