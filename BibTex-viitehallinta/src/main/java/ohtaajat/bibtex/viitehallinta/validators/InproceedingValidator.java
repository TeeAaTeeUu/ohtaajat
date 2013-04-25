package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "inproceedingValidator")
public class InproceedingValidator extends Reference implements Validator {

    public InproceedingValidator() {
        this.saaSisaltaaVain.add("author");
        this.saaSisaltaaVain.add("title");
        this.saaSisaltaaVain.add("booktitle");
        this.saaSisaltaaVain.add("year");
        this.saaSisaltaaVain.add("editor");
        this.saaSisaltaaVain.add("pages");
        this.saaSisaltaaVain.add("organization");
        this.saaSisaltaaVain.add("publisher");
        this.saaSisaltaaVain.add("address");
        this.saaSisaltaaVain.add("month");
        this.saaSisaltaaVain.add("note");
        this.saaSisaltaaVain.add("key");

        this.pitaaSisaltaa.add("author");
        this.pitaaSisaltaa.add("title");
//        this.pitaaSisaltaa.add("booktitle");
        this.pitaaSisaltaa.add("year");
    }

    @Override
    public boolean supports(Class<?> type) {
        return Inproceeding.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Inproceeding julkaisu = (Inproceeding) o;
        onkoKaikkiOikein(julkaisu, errors);
    }
}
