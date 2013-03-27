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
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "editor")
    private String editor;
    @Column(name = "address")
    private String address;
    @Column(name = "series")
    private String series;
    @Column(name = "edition")
    private String edition;
    @Column(name = "montha")
    private int montha;
    @Column(name = "note")
    private String note;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
        this.asetettu.put("series", true);
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
        this.asetettu.put("edition", true);
    }

    public int getMontha() {
        return montha;
    }

    public void setMontha(int montha) {
        this.montha = montha;
        this.asetettu.put("montha", true);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
        this.asetettu.put("note", true);
    }

    ArrayList<String> pitaaSisaltaa = new ArrayList<String>();
    ArrayList<String> pitaaSisaltaaVainJokin = new ArrayList<String>();

    public Book() {
        this.pitaaSisaltaaVainJokin.add("author");
        this.pitaaSisaltaaVainJokin.add("editor");

        this.pitaaSisaltaa.add("title");
        this.pitaaSisaltaa.add("publisher");
        this.pitaaSisaltaa.add("yeara");

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

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        this.asetettu.put("publisher", true);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setEditor(String editor) {
        this.editor = editor;
        this.asetettu.put("editor", true);
    }

    public String getEditor() {
        return editor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.asetettu.put("address", true);
    }
}
