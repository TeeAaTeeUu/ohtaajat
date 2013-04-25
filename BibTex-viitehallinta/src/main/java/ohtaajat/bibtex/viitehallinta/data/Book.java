package ohtaajat.bibtex.viitehallinta.data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "Book")
@Table(name = "Book")
public class Book extends Entry {

    public Book() {
    }

    @Override
    public String toBibTex(String otsikko) {
        return "@book{"+otsikko+","+"\n"+ toBibTex()+"}\n\n";
    }
}