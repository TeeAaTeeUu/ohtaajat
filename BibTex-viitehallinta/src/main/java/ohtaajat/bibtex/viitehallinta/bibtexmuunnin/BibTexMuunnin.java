package ohtaajat.bibtex.viitehallinta.bibtexmuunnin;

import java.util.HashMap;
import java.util.Map;

public class BibTexMuunnin {

    HashMap<String, String> umlauts = new HashMap<String, String>();

    public BibTexMuunnin() {
        this.umlauts.put("ä", "{\\\\\"a}");
        this.umlauts.put("Ä", "{\\\\\"A}");
        this.umlauts.put("ö", "{\\\\\"o}");
        this.umlauts.put("Ö", "{\\\\\"O}");
        this.umlauts.put("å", "{\\\\aa}");
        this.umlauts.put("Å", "{\\\\aA}");
    }

    protected String umlautDegenerator(String sisalto) {

        for (Map.Entry tarkistettavaKirjain : this.umlauts.entrySet()) {
            sisalto = sisalto.replaceAll((String) tarkistettavaKirjain.getKey(), (String) tarkistettavaKirjain.getValue());
        }
        return sisalto;
    }

    public String tagToBibTex(String key, String value) {
        return this.muunnaBibTexiksi(key, value);
    }
    
    public String tagToBibTex(String key, int value) {
        return this.tagToBibTex(key, Integer.toString(value));
    }

    private String muunnaBibTexiksi(String key, String value) {
        value = this.umlautDegenerator(value);
        return ("    " + key + " = {" + value + "}," + "\n");
    }
}
