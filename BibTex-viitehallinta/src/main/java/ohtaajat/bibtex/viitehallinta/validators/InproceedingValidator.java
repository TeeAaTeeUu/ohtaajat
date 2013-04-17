package ohtaajat.bibtex.viitehallinta.validators;

import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "inproceedingValidator")
public class InproceedingValidator implements Validator{
    
    @Override
    public boolean supports(Class<?> type) {
        return Inproceeding.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        BookFormObject book = (BookFormObject) o;
//        onKaikkiPakollinen(book, errors);
    }

    public void onKaikkiPakollinen(Inproceeding inproceeding, Errors errors) {
//        if(book.getTitle().isEmpty()){
//            errors.rejectValue("title", "virheellinen_arvo", "virheellinen arvo");
//        }
    }
}
