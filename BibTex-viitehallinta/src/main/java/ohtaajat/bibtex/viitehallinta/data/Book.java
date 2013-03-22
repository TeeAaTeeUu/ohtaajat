package tatu.bibtex.viitehallinta;

import java.util.ArrayList;

public class Book extends Simple {

    private BibTex bibTex;
    private String bookBibTex;
    ArrayList<String> bookPitaaSisaltaa = new ArrayList<String>();

    public Book() {
        this.bibTex = new BibTex();
        this.bookPitaaSisaltaa.add("author");
        this.bookPitaaSisaltaa.add("title");
        this.bookPitaaSisaltaa.add("publisher");
        this.bookPitaaSisaltaa.add("year");
        this.bookPitaaSisaltaa.add("address");

        for (String tarkistettava : this.bookPitaaSisaltaa) {
            this.asetettu.put(tarkistettava, false);
        }
    }

    public String bookToBibTex() {
        if (this.onKaikkipakollinen() == false) {
            return "";
        }
        this.bookBibTex = "@book{xd96" + "\n";
        this.bookBibTex += this.bibTex.authorToBibTex(this.palautaAuthor()) + "\n";
        this.bookBibTex += this.bibTex.titleToBibTex(this.palautaTitle()) + "\n";
        this.bookBibTex += this.bibTex.publisherToBibTex(this.palautaPublisher()) + "\n";
        this.bookBibTex += this.bibTex.yearToBibTex(this.palautaYear()) + "\n";
        this.bookBibTex += this.bibTex.addressToBibTex(this.palautaAddress()) + "\n";
        this.bookBibTex += "}";

        return this.bookBibTex;
    }

    public boolean onKaikkipakollinen() {
        for (String tarkistettava : this.bookPitaaSisaltaa) {
//            System.out.println(tarkistettava);
            if (this.asetettu.get(tarkistettava) == false) {
                return false;
            }
        }
        return true;
    }
}
