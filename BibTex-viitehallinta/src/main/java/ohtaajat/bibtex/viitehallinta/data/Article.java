package ohtaajat.bibtex.viitehallinta.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Article")
@Table(name = "Article")
public class Article extends Entry {

    public Article() {
    }

    @Override
    public String toBibTex(String otsikko) {
        return "@article{" + otsikko + "," + "\n" + toBibTex() + "}\n\n";
    }
}
