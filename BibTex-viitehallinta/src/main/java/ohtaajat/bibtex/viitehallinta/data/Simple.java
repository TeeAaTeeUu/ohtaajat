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
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "yeara")
    private int yeara;
    HashMap<String, Boolean> asetettu;

    public Simple() {
        this.asetettu = new HashMap<String, Boolean>();
    }

    public void setId(Long id) {
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

    public void setYeara(int yeara) {
        this.yeara = yeara;
        this.asetettu.put("yeara", true);
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYeara() {
        return yeara;
    }
    
    public boolean isAuthorSet() {
        return this.asetettu.get("author");
    }

    public boolean isTitleSet() {
        return this.asetettu.get("title");
    }

    public boolean isYearaSet() {
        return this.asetettu.get("yeara");
    }
}
