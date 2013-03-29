package ohtaajat.bibtex.viitehallinta.data;

import java.util.HashMap;
import java.util.Map;

public class BibTex {

    HashMap<String, String> umlauts = new HashMap<String, String>();

    public BibTex() {
        this.umlauts.put("ä", "{\\\\\"a}");
        this.umlauts.put("Ä", "{\\\\\"A}");
        this.umlauts.put("ö", "{\\\\\"o}");
        this.umlauts.put("Ö", "{\\\\\"O}");
        this.umlauts.put("å", "{\\\\aa}");
        this.umlauts.put("Å", "{\\\\aA}");
    }

    public String authorToBibTex(String author) {
        author = this.umlautDegenerator(author);
        return ("author = {" + author + "},");
    }

    public String titleToBibTex(String title) {
        return ("title = {" + title + "},");
    }

    public String publisherToBibTex(String publisher) {
        return ("publisher = {" + publisher + "},");
    }

    public String yearToBibTex(int year) {
        return ("year = {" + year + "},");
    }

    public String addressToBibTex(String address) {

        return ("address = {" + address + "},");
    }

    protected String umlautDegenerator(String sisalto) {

        for (Map.Entry tarkistettavaKirjain : this.umlauts.entrySet()) {
            sisalto = sisalto.replaceAll((String)tarkistettavaKirjain.getKey(), (String)tarkistettavaKirjain.getValue());
        }
        return sisalto;
    }
}
