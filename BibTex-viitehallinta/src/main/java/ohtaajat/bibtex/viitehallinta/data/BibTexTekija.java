package ohtaajat.bibtex.viitehallinta.data;

import java.util.HashSet;
import java.util.List;

public class BibTexTekija {

    HashSet<Book> Books;
    BibTexMuunnin bibTexMuunnin;
    HashSet<String> otsikot;

    public BibTexTekija() {
        this.bibTexMuunnin = new BibTexMuunnin();
        this.Books = new HashSet<Book>();
    }

    public void lisaaBook(Book book) {
        this.Books.add(book);
    }
    
    public void lisaaBook(List<Book> books) {
        for(Book book : books) {
            this.lisaaBook(book);
        }
    }

    public String palautaBibTex() {
        this.otsikot = new HashSet<String>();
        
        String bibTex = "";
        for (Book book : this.Books) {
            if (book.onKaikkipakollinen() == true) {
                bibTex += "@book{" + this.palautaOtsikko(book) + "," + "\n";
                bibTex += book.toBibTex(this.bibTexMuunnin);
                bibTex += "}" + "\n" + "\n";
            }
        }
        return bibTex;
    }

    private String palautaOtsikko(Book book) {
        String tekija = this.getBookAuthorOrEditor(book);
        int vuosi = this.getYear(book);
        String otsikko = tekija + Integer.toString(vuosi);

        return tarkistaJaPalautaUniikkiOtsikko(otsikko);
    }

    private String getBookAuthorOrEditor(Book book) {
        String[] nimet = getSplittedAuthorOrEditor(book);

        for (String sana : nimet) {
            if (sana.length() >= 4) {
                return sana;
            }
        }
        return nimet[0];
    }

    private int getYear(Book book) {
        int vuosi = book.getYear();

        if (vuosi >= 2000 && vuosi < 2100) {
            vuosi -= 2000;
        } else if (vuosi >= 1900 && vuosi < 2000) {
            vuosi -= 1900;
        }

        return vuosi;
    }

    private String[] getSplittedAuthorOrEditor(Book book) {
        String[] nimet;
        if (book.isAuthorSet() == true) {
            nimet = book.getAuthor().split(" ");
        } else {
            nimet = book.getEditor().split(" ");
        }
        return nimet;
    }

    private String tarkistaJaPalautaUniikkiOtsikko(String otsikko) {
        if (this.otsikot.contains(otsikko) == false) {
            this.otsikot.add(otsikko);
        } else {
            otsikko = this.lisaaSeuraavaKirjainLoppuun(otsikko);
            otsikko = this.tarkistaJaPalautaUniikkiOtsikko(otsikko);
        }
        return otsikko;
    }

    private String lisaaSeuraavaKirjainLoppuun(String otsikko) {
        char loppukirjain;
        loppukirjain = otsikko.charAt(otsikko.length() - 1);
        
        if  (Character.isDigit(loppukirjain) == true) {
            otsikko += "a";
        } else {
            loppukirjain++;
            otsikko = otsikko.substring(0, otsikko.length() - 1);
            otsikko += loppukirjain;
        }
        return otsikko;
    }
}