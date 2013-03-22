package tatu.bibtex.viitehallinta;

public class BibTex {

    public String authorToBibTex(String sisalto) {
        return ("author = {" + sisalto + "},");
    }

    public String titleToBibTex(String sisalto) {
        return ("title = {" + sisalto + "},");
    }

    public String publisherToBibTex(String sisalto) {
        return ("publisher = {" + sisalto + "},");
    }

    public String yearToBibTex(int sisalto) {
        return ("year = {" + sisalto + "},");
    }

    public String addressToBibTex(String sisalto) {
        return ("address = {" + sisalto + "},");
    }
}
