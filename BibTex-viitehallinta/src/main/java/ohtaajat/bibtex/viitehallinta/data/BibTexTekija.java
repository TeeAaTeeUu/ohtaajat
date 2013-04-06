package ohtaajat.bibtex.viitehallinta.data;

import java.util.TreeSet;

public class BibTexTekija {
    
    TreeSet<Book> Books;
    BibTexMuunnin bibTexMuunnin;
    
    public BibTexTekija() {
        this.bibTexMuunnin = new BibTexMuunnin();
        this.Books = new TreeSet<Book>();
        
    }
    
    public void lisaaBook(Book book) {
        this.Books.add(book);
    }
    
    public String palautaBibTex() {
        String bibTex = "";
        for (Book book : this.Books) {
            bibTex += "@book{Martin09," + "/n";
            bibTex += book.toBibTex(this.bibTexMuunnin);
            bibTex += "}" + "\n" + "\n";
        }
        return bibTex;
    }
    
}
