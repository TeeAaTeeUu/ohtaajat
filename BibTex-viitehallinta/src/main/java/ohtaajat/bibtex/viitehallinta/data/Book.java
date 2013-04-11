package ohtaajat.bibtex.viitehallinta.data;

import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Book")
@Table(name = "Book")
public class Book extends Entry {

    public Book() {
    }

    public Book(Map<String, String> fields) {
        this.addFields(fields);
    }

    public String toBibTex(BibTexMuunnin bibTexMuunnin) {
        String bibTexKoodi = "";
        for (Field field : this.getFields()) {
            bibTexKoodi += bibTexMuunnin.tagToBibTex(field.getName(), field.getValue());
        }
        return bibTexKoodi;

    }
}