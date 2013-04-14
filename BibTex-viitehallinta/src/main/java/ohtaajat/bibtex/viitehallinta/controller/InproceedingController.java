package ohtaajat.bibtex.viitehallinta.controller;

import javax.validation.Valid;
import ohtaajat.bibtex.viitehallinta.data.BibTexTekija;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;
import ohtaajat.bibtex.viitehallinta.service.InproceedingService;
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
public class InproceedingController {

    @Autowired
    private InproceedingService inproceedingService;
    @Autowired
    @Qualifier("inproceedingValidator")
    private Validator inproceedingValidator;

    @RequestMapping(value = "inproceedings/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("inproceeding") Inproceeding inproceeding,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        ValidationUtils.invokeValidator(inproceedingValidator, inproceeding, bindingResult);
        if (bindingResult.hasErrors()) {
            return "inproceedingform";
        }
        inproceedingService.create(inproceeding);
        redirectAttributes.addFlashAttribute("message", "New inproceeding created!");
        return "redirect:new";
    }

    @RequestMapping(value = "inproceedings/new", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("inproceeding") Inproceeding inproceeding) {
        return "inproceedingform";
    }

    @RequestMapping(value = "inproceedings", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("inproceedings", inproceedingService.list());
        return "inproceedings";
    }

    @RequestMapping(value = "inproceedings/bibtex", method = RequestMethod.GET)
    public String listBibTex(Model model) {
        BibTexTekija bibTexTekija = new BibTexTekija();
        for (Inproceeding inproceeding : inproceedingService.list()) {
            bibTexTekija.lisaaEntry(inproceeding);
        }
        String bibtex = bibTexTekija.palautaBibTex();
        bibtex = bibtex.replaceAll("\n", "<br />");
        model.addAttribute("inproceedings", bibtex);
        return "inproceedingsinbibtex";
    }
}
