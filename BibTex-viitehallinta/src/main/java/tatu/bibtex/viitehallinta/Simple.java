package tatu.bibtex.viitehallinta;

import java.util.HashMap;

public class Simple {

    private String author;
    private String title;
    private String publisher;
    private int year;
    private String address;
    HashMap<String, Boolean> asetettu = new HashMap<String, Boolean>();

    public boolean tallennaAuthor(String author) {
        this.author = author;
        this.asetettu.put("author", true);
        return true;
    }

    public boolean tallennaTitle(String title) {
        this.title = title;
        this.asetettu.put("title", true);
        return true;
    }

    public boolean tallennaPublisher(String publisher) {
        this.publisher = publisher;
        this.asetettu.put("publisher", true);
        return true;
    }

    public boolean tallennaYear(int year) {
        this.year = year;
        this.asetettu.put("year", true);
        return true;
    }

    public boolean tallennaAddress(String address) {
        this.address = address;
        this.asetettu.put("address", true);
        return true;
    }

    public String palautaAuthor() {
        return this.author;
    }

    public String palautaTitle() {
        return this.title;
    }

    public String palautaPublisher() {
        return this.publisher;
    }

    public int palautaYear() {
        return this.year;
    }

    public String palautaAddress() {
        return this.address;
    }
}
