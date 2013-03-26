package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "BookObject")
@Table(name = "BookObject")
public class Book extends Simple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    ArrayList<String> pitaaSisaltaa = new ArrayList<String>();
    ArrayList<String> pitaaSisaltaaVainJokin = new ArrayList<String>();

    public Book() {
        this.pitaaSisaltaaVainJokin.add("author");
        this.pitaaSisaltaaVainJokin.add("editor");

        this.pitaaSisaltaa.add("title");
        this.pitaaSisaltaa.add("publisher");
        this.pitaaSisaltaa.add("year");

        for (String tarkistettava : this.pitaaSisaltaa) {
            this.asetettu.put(tarkistettava, false);
        }

        for (String tarkistettava : this.pitaaSisaltaaVainJokin) {
            this.asetettu.put(tarkistettava, false);
        }
    }

    public boolean onKaikkipakollinen() {
        for (String tarkistettava : this.pitaaSisaltaa) {
            if (this.asetettu.get(tarkistettava) == false) {
                return false;
            }
        }

        int kuinkaMontaLoytyy = 0;
        for (String tarkistettava : this.pitaaSisaltaaVainJokin) {
            if (this.asetettu.get(tarkistettava) == true) {
                ++kuinkaMontaLoytyy;
            }
        }
        if (kuinkaMontaLoytyy != 1) {
            return false;
        }
        return true;
    }
}
