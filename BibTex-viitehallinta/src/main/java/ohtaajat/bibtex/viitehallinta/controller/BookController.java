package ohtaajat.bibtex.viitehallinta.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtaajat.bibtex.viitehallinta.data.BibTexTekija;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.data.BookFormObject;
import ohtaajat.bibtex.viitehallinta.data.Field;
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
        List<Field> lista1 = new ArrayList<Field>();
        List<Field> lista2 = new ArrayList<Field>();

        lista1.add(new Field("author", "Pekka Puupaa"));
        lista1.add(new Field("title", "Pekka ja Patka"));
        lista1.add(new Field("year", "1989"));
        lista1.add(new Field("publisher", "Otava"));

        lista2.add(new Field("author", "Pekka Puupaa"));
        lista2.add(new Field("title", "Pekka ja Patka 2"));
        lista2.add(new Field("year", "1991"));
        lista2.add(new Field("publisher", "Otava"));

        Book book = new Book();
        book.setFields(lista1);
        Book book2 = new Book();
        book2.setFields(lista2);

        bookService.create(book);
        bookService.create(book2);


    }

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") BookFormObject bookFormObject,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {
        ValidationUtils.invokeValidator(bookValidator, bookFormObject, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book";
        }
        Book book = new Book(bookFormObject.getAll());
        bookService.create(book);
        redirectAttributes.addFlashAttribute("message", "New book created!");
        return "redirect:book";
    }

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("book") BookFormObject book) {
        return "book";
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.list());
        return "books";
    }

    @RequestMapping(value = "books/bibtex", method = RequestMethod.GET)
    public String listBibTex(Model model) {
        BibTexTekija BibTexTekija = new BibTexTekija();
        BibTexTekija.lisaaBook(bookService.list());
        String bibtex = BibTexTekija.palautaBibTex();
        model.addAttribute("books", bibtex);

        return "booksinbibtex";

    }
}
