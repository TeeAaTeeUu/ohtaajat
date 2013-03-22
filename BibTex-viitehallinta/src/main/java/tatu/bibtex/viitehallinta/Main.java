package tatu.bibtex.viitehallinta;

public class Main {

    public static void main(String[] args) {
        Book kirja = new Book();
        
        kirja.tallennaAuthor("L. S. Vygotsky");
        kirja.tallennaTitle("Mind in Society: The Development of Higher Psychological Processes");
        kirja.tallennaPublisher("Harvard University Press");
        kirja.tallennaYear(1978);
        kirja.tallennaAddress("Cambridge, MA");
        
        System.out.println(kirja.bookToBibTex());
        
    }
}
