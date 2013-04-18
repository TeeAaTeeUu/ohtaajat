package ohtaajat.bibtex.viitehallinta.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "inproceeding")
@Table(name = "inproceeding")
public class Inproceeding extends Entry {

    public Inproceeding() {
    }

    @Override
    public String toBibTex(String otsikko) {
        return "@inproceedings{" + otsikko + "," + "\n" + toBibTex() + "}\n\n";
    }
}
