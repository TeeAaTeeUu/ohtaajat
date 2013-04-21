package ohtaajat.bibtex.viitehallinta.controller;

import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.data.BibTexTekija;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.data.Entry;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import ohtaajat.bibtex.viitehallinta.service.ArticleService;
import ohtaajat.bibtex.viitehallinta.service.BookService;
import ohtaajat.bibtex.viitehallinta.service.InproceedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EntryController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private InproceedingService inproceedingService;

    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public String list(@RequestParam(required = false) String author, Model model) {
        List<Book> books;
        List<Article> articles;
        List<Inproceeding> inproceedings;
        if (author == null || author.isEmpty()) {
            books = bookService.list();
            articles = articleService.list();
            inproceedings = inproceedingService.list();
            model.addAttribute("title", "List of all entries");
        } else {
            books = bookService.findByPartOfAuthor(author);
            articles = articleService.findByPartOfAuthor(author);
            inproceedings = inproceedingService.findByPartOfAuthor(author);

            model.addAttribute("title", "List of entryes with author name " + author);
        }

        model.addAttribute("entries", joinEntryLists(books, articles, inproceedings));
        return "entry/list";
    }

    @RequestMapping(value = "entries/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@RequestParam String name) throws Exception {
        List<Book> books = bookService.list();
        List<Article> articles = articleService.list();
        List<Inproceeding> inproceedings = inproceedingService.list();
         BibTexTekija bibTexTekija = new BibTexTekija();
        for (Book book : books) {
            bibTexTekija.lisaaEntry(book);
        }
        for (Article article : articles) {
             bibTexTekija.lisaaEntry(article);
        }
        for (Inproceeding inproceeding : inproceedings) {
             bibTexTekija.lisaaEntry(inproceeding);
        }
        String bibtex = bibTexTekija.palautaBibTex();
        byte[] content = bibtex.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/html;charset=UTF-8"));
        headers.setContentLength(content.length);
        headers.set("Content-Disposition", "attachment; filename=\""+name+"\".bib");
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
    }

    private List<Entry> joinEntryLists(List<Book> books, List<Article> articles, List<Inproceeding> inproceedings) {
        List<Entry> entries = new ArrayList<Entry>();
        for (Book book : books) {
            entries.add(book);
        }
        for (Article article : articles) {
            entries.add(article);
        }
        for (Inproceeding inproceeding : inproceedings) {
            entries.add(inproceeding);
        }
        
        return entries;

    }
}
