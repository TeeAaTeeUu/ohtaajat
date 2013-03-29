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
        String bibTex = "@book{Martin09," + "/n";
        for (Book book : this.Books) {
            bibTex += book.toBibTex(this.bibTexMuunnin);
        }
        return bibTex;
    }
    
}
