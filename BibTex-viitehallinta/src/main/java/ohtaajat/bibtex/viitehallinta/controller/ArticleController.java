package ohtaajat.bibtex.viitehallinta.controller;


import javax.validation.Valid;
import ohtaajat.bibtex.viitehallinta.data.Article;
import ohtaajat.bibtex.viitehallinta.data.BibTexTekija;
import ohtaajat.bibtex.viitehallinta.service.ArticleService;
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
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    @Qualifier("articleValidator")
    private Validator articleValidator;

    @RequestMapping(value = "articles/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("article") Article article,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        ValidationUtils.invokeValidator(articleValidator, article, bindingResult);
        if (bindingResult.hasErrors()) {
            return "article/articleform";
        }
        articleService.create(article);
        redirectAttributes.addFlashAttribute("message", "New article created!");
        return "redirect:new";
    }

    @RequestMapping(value = "articles/new", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("article") Article article) {
        return "articleform";
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("articles", articleService.list());
        return "article/articles";
    }

    @RequestMapping(value = "articles/bibtex", method = RequestMethod.GET)
    public String listBibTex(Model model) {
        BibTexTekija bibTexTekija = new BibTexTekija();
        for (Article article : articleService.list()) {
            bibTexTekija.lisaaEntry(article);
        }
        String bibtex = bibTexTekija.palautaBibTex();
        bibtex = bibtex.replaceAll("\n", "<br />");
        model.addAttribute("articles", bibtex);
        return "article/articlesinbibtex";
    }
}
