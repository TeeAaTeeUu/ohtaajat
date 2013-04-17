package ohtaajat.bibtex.viitehallinta.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtaajat.bibtex.viitehallinta.data.BibTexTekija;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    @Qualifier("bookValidator")
    private Validator bookValidator;

    @PostConstruct
    public void init() {
        Book book = new Book();
        Book book2 = new Book();
        
        book.setAuthor("Pekka Puupaa");
        book.setTitle("Pekka ja Patka");
        book.setYear("1989");
        book.setPublisher("Otava");

        book2.setAuthor("Pekka Puupaa");
        book2.setTitle("Pekka ja Patka 2");
        book2.setYear("1991");
        book2.setPublisher("Otava");



        bookService.create(book);
        bookService.create(book2);


    }

    @RequestMapping(value = "books/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        ValidationUtils.invokeValidator(bookValidator, book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book/bookform";
        }
        bookService.create(book);
        redirectAttributes.addFlashAttribute("message", "New book created!");
        return "redirect:new";
    }

    @RequestMapping(value = "books/new", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("book") Book book) {
        return "book/bookform";
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.list());
        return "book/books";
    }

    @RequestMapping(value = "books/bibtex", method = RequestMethod.GET)
    public String listBibTex(Model model) {
        BibTexTekija bibTexTekija = new BibTexTekija();
        for (Book book : bookService.list()) {
            bibTexTekija.lisaaEntry(book);
        }
        String bibtex = bibTexTekija.palautaBibTex();
        bibtex = bibtex.replaceAll("\n", "<br />");
        model.addAttribute("books", bibtex);

        return "book/booksinbibtex";

    }
}
