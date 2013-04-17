package ohtaajat.bibtex.viitehallinta.controller;

import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.data.Entry;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import ohtaajat.bibtex.viitehallinta.service.ArticleService;
import ohtaajat.bibtex.viitehallinta.service.BookService;
import ohtaajat.bibtex.viitehallinta.service.InproceedingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String list(@RequestParam(required=false) String author, Model model){
        List<Book> books;
        List<Article> articles;
        List<Inproceeding> inproceedings;
        if(author == null || author.isEmpty()){
            books = bookService.list();
            articles = articleService.list();
            inproceedings = inproceedingService.list();
            model.addAttribute("title", "List of all entries");
        } else {
            books = bookService.findByAuthor(author);
            articles = articleService.findByAuthor(author);
            inproceedings = inproceedingService.findByAuthor(author);
            
            model.addAttribute("title", "List of entryes with author name "+author);
        }
        List<Entry> entrys = new ArrayList<Entry>();
        for (Book book : books) {
            entrys.add(book);
        }
        for (Article article : articles) {
            entrys.add(article);
        }
        for (Inproceeding inproceeding : inproceedings) {
            entrys.add(inproceeding);
        }
        model.addAttribute("entries", entrys);
        return "entry/list";
    }
}
