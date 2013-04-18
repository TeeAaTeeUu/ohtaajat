package ohtaajat.bibtex.viitehallinta.data;

import java.util.HashSet;
import java.util.List;

public class BibTexTekija {

    HashSet<Entry> entrys;
    BibTexMuunnin bibTexMuunnin;
    HashSet<String> otsikot;

    public BibTexTekija() {
        this.bibTexMuunnin = new BibTexMuunnin();
        this.entrys = new HashSet<Entry>();
    }

    public void lisaaEntry(Entry viite) {
        this.entrys.add(viite);
    }

    public void lisaaEntry(List<Entry> lista) {
        for (Entry entry : lista) {
            this.lisaaEntry(entry);
        }
    }

    public String palautaBibTex() {
        this.otsikot = new HashSet<String>();

        String bibTex = "";
        for (Entry entry : this.entrys) {
            bibTex += entry.toBibTex(palautaOtsikko(entry));
        }
        return bibTex;
    }

    private String palautaOtsikko(Entry entry) {
        String otsikko = this.palautaCite(entry);

        if (otsikko == null) {
            otsikko = this.palautaGeneroituOtsikko(entry);
        }
        return tarkistaJaPalautaUniikkiOtsikko(otsikko);
    }

    private String getBookAuthorOrEditor(Entry entry) {
        String[] nimet = getSplittedAuthorOrEditor(entry);

        for (String sana : nimet) {
            if (sana.length() >= 4) {
                return sana;
            }
        }
        return nimet[0];
    }

    private String getYear(Entry entry) {
        int vuosi = Integer.parseInt(entry.getYear());

        if (vuosi >= 2000 && vuosi < 2100) {
            vuosi -= 2000;
        } else if (vuosi >= 1900 && vuosi < 2000) {
            vuosi -= 1900;
        }

        if (vuosi >= 10) {
            return Integer.toString(vuosi);
        } else {
            return "0" + Integer.toString(vuosi);
        }
    }

    private String[] getSplittedAuthorOrEditor(Entry entry) {
        String[] nimet;
        String nimi = entry.getAuthor();
        if (nimi == null) {
            nimi = entry.getEditor();
        }
        nimet = nimi.split(" ");
        return nimet;
    }

    private String tarkistaJaPalautaUniikkiOtsikko(String otsikko) {
        if (this.otsikot.contains(otsikko) == false) {
            this.otsikot.add(otsikko);
        } else {
            otsikko = this.lisaaSeuraavaKirjainLoppuun(otsikko);
            otsikko = this.tarkistaJaPalautaUniikkiOtsikko(otsikko);
        }
        return otsikko;
    }

    private String lisaaSeuraavaKirjainLoppuun(String otsikko) {
        char loppukirjain = this.palautaViimeinenKirjain(otsikko);

        if (Character.isDigit(loppukirjain) == true) {
            otsikko += "a";
        } else {
            loppukirjain++;
            otsikko = this.poistaViimeinenKirjain(otsikko);
            otsikko += loppukirjain;
        }
        return otsikko;
    }

    private String palautaCite(Entry entry) {
        String cite;
        
        if (entry.getCite() == null) {
            return null;
        } else {
            cite = entry.getCite();
        }

        char loppukirjain = this.palautaViimeinenKirjain(cite);
        if (Character.isDigit(loppukirjain) == false) {
            cite += this.getYear(entry);
        }
        return cite;
    }

    private char palautaViimeinenKirjain(String string) {
        return string.charAt(string.length() - 1);
    }

    private String poistaViimeinenKirjain(String string) {
        return string.substring(0, string.length() - 1);
    }

    private String palautaGeneroituOtsikko(Entry entry) {
        String otsikko;
        String vuosi = this.getYear(entry);
        String tekija = this.getBookAuthorOrEditor(entry);
        otsikko = tekija + vuosi;
        return otsikko;
    }
}