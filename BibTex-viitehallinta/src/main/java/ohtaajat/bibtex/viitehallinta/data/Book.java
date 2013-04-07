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
    @Column(name = "month")
    private int month;
    @Column(name = "note")
    private String note;
    ArrayList<String> pitaaSisaltaa;
    ArrayList<String> pitaaSisaltaaVainJokin;

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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        this.asetettu.put("montha", true);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
        this.asetettu.put("note", true);
    }

    public Book() {
        super();
        this.alustaPitaaSisaltaa();
        this.alustaAsetettu();
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

    public String toBibTex(BibTexMuunnin bibTexMuunnin) {

        if (this.onKaikkipakollinen() == true) {
            String bibTexKoodi = "";

            if (isTitleSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("title", this.getTitle());
            }
            if (isYearSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("year", Integer.toString(this.getYear()));
            }
            if (isAuthorSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("author", this.getAuthor());
            }
            if (isPublisherSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("publisher", this.getPublisher());
            }
            if (isEditorSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("editor", this.getEditor());
            }
            if (isAddressSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("address", this.getAddress());
            }
            if (isSeriesSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("series", this.getSeries());
            }
            if (isEditionSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("edition", this.getEdition());
            }
            if (isMonthSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("month", Integer.toString(this.getMonth()));
            }
            if (isNoteSet() == true) {
                bibTexKoodi += bibTexMuunnin.tagToBibTex("note", this.getNote());
            }
            return bibTexKoodi;
        }
        return "";
        
    }

    public boolean isPublisherSet() {
        return this.asetettu.get("publisher");
    }

    public boolean isEditorSet() {
        return this.asetettu.get("editor");
    }

    public boolean isAddressSet() {
        return this.asetettu.get("address");
    }

    public boolean isSeriesSet() {
        return this.asetettu.get("series");
    }

    public boolean isEditionSet() {
        return this.asetettu.get("edition");
    }

    public boolean isMonthaSet() {
        return this.asetettu.get("montha");
    }

    public boolean isMonthSet() {
        return this.isMonthaSet();
    }

    public boolean isNoteSet() {
        return this.asetettu.get("note");
    }

    private void alustaPitaaSisaltaa() {
        this.pitaaSisaltaaVainJokin = new ArrayList<String>();
        this.pitaaSisaltaa = new ArrayList<String>();

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

    private void alustaAsetettu() {
        this.asetettu.put("publisher", false);
        this.asetettu.put("editor", false);
        this.asetettu.put("address", false);
        this.asetettu.put("series", false);
        this.asetettu.put("edition", false);
        this.asetettu.put("montha", false);
        this.asetettu.put("note", false);
    }
}