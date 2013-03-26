package ohtaajat.bibtex.viitehallinta.data;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Simple implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "author")
    private String author;
    @Column(name = "editor")
    private String editor;
    @Column(name = "title")
    private String title;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year")
    private int year;
    @Column(name = "address")
    private String address;
    HashMap<String, Boolean> asetettu = new HashMap<String, Boolean>();

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
        this.asetettu.put("author", true);
    }

    public void setTitle(String title) {
        this.title = title;
        this.asetettu.put("title", true);
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        this.asetettu.put("publisher", true);
    }

    public void setYear(int year) {
        this.year = year;
        this.asetettu.put("year", true);
    }

    public void setAddress(String address) {
        this.address = address;
        this.asetettu.put("address", true);
    }

    public void setEditor(String editor) {
        this.editor = editor;
        this.asetettu.put("editor", true);
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public String getEditor() {
        return editor;
    }
}
