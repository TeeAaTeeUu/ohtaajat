package ohtaajat.bibtex.viitehallinta.controller;

import javax.validation.Valid;
import ohtaajat.bibtex.viitehallinta.data.Book;
import ohtaajat.bibtex.viitehallinta.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book";
        }
        bookService.create(book);
        return "redirect:book";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@ModelAttribute("book") Book book) {
        return "book";
    }
}
