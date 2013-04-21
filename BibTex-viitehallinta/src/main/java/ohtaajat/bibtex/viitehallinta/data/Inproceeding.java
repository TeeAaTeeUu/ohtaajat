package ohtaajat.bibtex.viitehallinta.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Inproceeding")
@Table(name = "Inproceeding")
public class Inproceeding extends Entry {

    public Inproceeding() {
    }

    @Override
    public String toBibTex(String otsikko) {
        return "@inproceedings{" + otsikko + "," + "\n" + toBibTex() + "}\n\n";
    }
}
