package ohtaajat.bibtex.viitehallinta.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import ohtaajat.bibtex.viitehallinta.data.Entry;
import org.springframework.validation.Errors;

public abstract class Reference {

    ArrayList<String> pitaaSisaltaa;
    ArrayList<String> pitaaSisaltaaVainJokin;
    ArrayList<String> saaSisaltaaVain;

    public Reference() {
        this.pitaaSisaltaaVainJokin = new ArrayList<String>();
        this.pitaaSisaltaa = new ArrayList<String>();
        this.saaSisaltaaVain = new ArrayList<String>();
    }

    protected void onkoKaikkiOikein(Entry entry, Errors errors) {
        HashMap<String, String> kaikkiEntryt = entry.toMap();

        this.tarkistaPitaaSisaltaa(kaikkiEntryt, errors);
        this.tarkistaVainJokuSaaOlla(kaikkiEntryt, errors);
        this.tarkistaEtteiYlimaaraisia(kaikkiEntryt, errors);
    }

    private void tarkistaPitaaSisaltaa(HashMap<String, String> kaikkiEntryt, Errors errors) {
        for (String tarkistettava : this.pitaaSisaltaa) {
            if (kaikkiEntryt.containsKey(tarkistettava) == false || kaikkiEntryt.get(tarkistettava).length() == 0) {
                errors.rejectValue(tarkistettava, "virheellinen_arvo", tarkistettava + " oli tyhjä.");
            }
        }
    }

    private void tarkistaVainJokuSaaOlla(HashMap<String, String> kaikkiEntryt, Errors errors) {
        if (this.pitaaSisaltaaVainJokin.isEmpty() == false) {
            int kuinkaMontaLoytyy = 0;
            for (String tarkistettava : this.pitaaSisaltaaVainJokin) {
                if (kaikkiEntryt.containsKey(tarkistettava) == true && kaikkiEntryt.get(tarkistettava).length() > 0) {
                    ++kuinkaMontaLoytyy;
                }
            }
            if (kuinkaMontaLoytyy != 1) {
                this.generoiVainJokuErrorViesti(errors);
            }
        }
    }

    private void generoiVainJokuErrorViesti(Errors errors) {
        String mitaVainYksi = "";
        boolean ekaKerta = true;
        for (String entry : pitaaSisaltaaVainJokin) {
            if (ekaKerta == false) {
                mitaVainYksi += " tai ";
            } else {
                ekaKerta = false;
            }
            mitaVainYksi += entry;
        }

        String errorViesti = "Vain jokin näistä voidaan asettaa yhdelle viitteelle: " + mitaVainYksi;
        errors.rejectValue(this.pitaaSisaltaaVainJokin.get(0), "virheellinen_arvo", errorViesti);
    }

    private void tarkistaEtteiYlimaaraisia(HashMap<String, String> kaikkiEntryt, Errors errors) {   
        Set<String> kaikkiEntryOtsikot = kaikkiEntryt.keySet();        
        for (String entry : kaikkiEntryOtsikot) {
            if(this.saaSisaltaaVain.contains(entry) == false)
                errors.reject("Sisältää jotain, mitä ei saisi sisältää: " + entry);
        }
    }
}
