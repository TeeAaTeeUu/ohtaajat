package ohtaajat.bibtex.viitehallinta.data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.util.ReflectionUtils;

@MappedSuperclass
public abstract class Entry {

    private static BibTexMuunnin bibTexMuunnin = new BibTexMuunnin();
    private static Map<String, String> metodienNimet = new HashMap<String, String>();

    {
        metodienNimet.put("getAuthor", "author");
        metodienNimet.put("getEditor", "editor");
        metodienNimet.put("getTitle", "title");
        metodienNimet.put("getPublisher", "publisher");
        metodienNimet.put("getYear", "year");
        metodienNimet.put("getVolume", "volume");
        metodienNimet.put("getSeries", "series");
        metodienNimet.put("getAddress", "address");
        metodienNimet.put("getEdition", "edition");
        metodienNimet.put("getMonth", "month");
        metodienNimet.put("getNote", "note");
        metodienNimet.put("getKey", "key");
        metodienNimet.put("getBookTitle", "booktitle");
        metodienNimet.put("getPages", "pages");
        metodienNimet.put("getOrganization", "organization");
        metodienNimet.put("getJournal", "journal");
        metodienNimet.put("getNumber", "number");
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "editor")
    private String editor;
    @Column(name = "title")
    private String title;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year")
    private String year;
    @Column(name = "volume")
    private String volume;
    @Column(name = "series")
    private String series;
    @Column(name = "address")
    private String address;
    @Column(name = "edition")
    private String edition;
    @Column(name = "month")
    private String month;
    @Column(name = "note")
    private String note;
    @Column(name = "key")
    private String key;
    @Column(name = "booktitle")
    private String booktitle;
    @Column(name = "pages")
    private String pages;
    @Column(name = "organization")
    private String organization;
    @Column(name = "journal")
    private String journal;
    @Column(name = "number")
    private String number;
    @Column(name = "cite")
    private String cite;

    public String getCite() {
        return this.cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public abstract String toBibTex(String otsikko);

    String toBibTex() {
        Method[] metodit = Entry.class.getMethods();
        String bibtex = "";
        for (Method method : metodit) {
            if (metodienNimet.containsKey(method.getName())) {
                String arvo = (String) ReflectionUtils.invokeMethod(method, this);
                if (arvo != null && !arvo.trim().isEmpty()) {
                    bibtex += bibTexMuunnin.tagToBibTex(metodienNimet.get(method.getName()), arvo);
                }
            }
        }
        return bibtex;
    }

    @Override
    public String toString() {
        Method[] metodit = Entry.class.getMethods();
        String bibtex = "<div><table>" + "\n";
        bibtex += "<tr><td>ID</td><td>:</td><td>" + id + "</td></tr>" + "\n";
        for (Method method : metodit) {
            if (metodienNimet.containsKey(method.getName())) {
                String arvo = (String) ReflectionUtils.invokeMethod(method, this);
                if (arvo != null && !arvo.trim().isEmpty()) {
                    bibtex += "<tr><td>" + metodienNimet.get(method.getName()) + "</td><td>:</td><td>" + arvo + "</td></tr>" + "\n";
                }
            }
        }
        bibtex += "</table></div>" + "\n";
        return bibtex;
    }
}
