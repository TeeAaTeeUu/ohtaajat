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
    HashMap<String, String> kaikkiEntryt;
    ArrayList<String> numerollisetOtsikot;
    Set<String> kaikkiEntryOtsikot;
    Errors errors;

    public Reference() {
        this.pitaaSisaltaaVainJokin = new ArrayList<String>();
        this.pitaaSisaltaa = new ArrayList<String>();
        this.saaSisaltaaVain = new ArrayList<String>();
    }

    protected void onkoKaikkiOikein(Entry entry, Errors errors) {
        this.kaikkiEntryt = entry.toMap();
        this.errors = errors;
        this.kaikkiEntryOtsikot = kaikkiEntryt.keySet();

        this.tarkistaPitaaSisaltaa();
        this.tarkistaVainJokuSaaOlla();
        this.tarkistaEtteiYlimaaraisia();
        this.tiedotSisaltavatJarkevaaDataa();
    }

    private void tarkistaPitaaSisaltaa() {
        for (String tarkistettava : this.pitaaSisaltaa) {
            if (kaikkiEntryt.containsKey(tarkistettava) == false || kaikkiEntryt.get(tarkistettava).length() == 0) {
                errors.rejectValue(tarkistettava, "virheellinen_arvo", tarkistettava + " oli tyhjä.");
            }
        }
    }

    private void tarkistaVainJokuSaaOlla() {
        if (this.pitaaSisaltaaVainJokin.isEmpty() == false) {
            int kuinkaMontaLoytyy = 0;
            for (String tarkistettava : this.pitaaSisaltaaVainJokin) {
                if (kaikkiEntryt.containsKey(tarkistettava) == true && kaikkiEntryt.get(tarkistettava).length() > 0) {
                    ++kuinkaMontaLoytyy;
                }
            }
            if (kuinkaMontaLoytyy != 1) {
                this.generoiVainJokuErrorViesti();
            }
        }
    }

    private void tiedotSisaltavatJarkevaaDataa() {
        this.tarkistaNumerollisetTiedot();
        this.tarkistaSyotteidenPituudet();
    }

    private void generoiVainJokuErrorViesti() {
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

    private void tarkistaEtteiYlimaaraisia() {
        for (String entry : kaikkiEntryOtsikot) {
            if (this.saaSisaltaaVain.contains(entry) == false) {
                errors.reject("Sisältää jotain, mitä ei saisi sisältää: " + entry);
            }
        }
    }

    private void tarkistaNumerollisetTiedot() {

        numerollisetOtsikot = new ArrayList<String>();

        numerollisetOtsikot.add("year");
        numerollisetOtsikot.add("month");

        for (String numerollinen : numerollisetOtsikot) {
            if (kaikkiEntryt.containsKey(numerollinen)) {
                tarkistaNumerot(numerollinen);
            }
        }
    }

    //http://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java/5439547#5439547
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    private void kuukausiOnOikeanlainen(String numerollinen) {
        int numero = palautaNumero(numerollinen);
        if (numero > 12 || numero < 1) {
            errors.rejectValue(numerollinen, "virheellinen_arvo", "Oletko varma, että kuukausi meni oikein?");
        }
    }

    private void vuosiOnOikeanlainen(String numerollinen) {
        int numero = palautaNumero(numerollinen);
        if (numero >= 3000 || numero < 0) {
            errors.rejectValue(numerollinen, "virheellinen_arvo", "Oletko varma, että vuosi meni oikein?" + numero);
        }
    }

    private void tarkistaNumerot(String numerollinen) {
        if (Reference.isInteger(kaikkiEntryt.get(numerollinen)) == false) {
            errors.rejectValue(numerollinen, "virheellinen_arvo", "Tämän pitäisi olla vain numeroita");
        } else if (numerollinen.equals("year")) {
            vuosiOnOikeanlainen(numerollinen);
        } else if (numerollinen.equals("month")) {
            kuukausiOnOikeanlainen(numerollinen);
        }
    }

    private int palautaNumero(String numerollinen) {
        if (Reference.isInteger(kaikkiEntryt.get(numerollinen))) {
            return Integer.parseInt(kaikkiEntryt.get(numerollinen));
        }
        return -99999;
    }

    private void tarkistaSyotteidenPituudet() {
        for (String tarkistettava : this.pitaaSisaltaa) {
            if (kaikkiEntryt.containsKey(tarkistettava)) {
                String sisalto = kaikkiEntryt.get(tarkistettava);
                if (sisalto.length() > 100) {
                    errors.rejectValue(tarkistettava, "virheellinen_arvo", tarkistettava + " oli yli 100 merkkiä pitkä.");
                }
            }
        }
    }
}
