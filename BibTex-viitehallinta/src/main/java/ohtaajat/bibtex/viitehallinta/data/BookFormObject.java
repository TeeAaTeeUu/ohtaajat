package ohtaajat.bibtex.viitehallinta.data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ReflectionUtils;

public class BookFormObject {

    private Method[] metodit = BookFormObject.class.getMethods();
    private Map<String, String> metodienNimet = new HashMap<String, String>();
    private String author, editor, title, publisher, year, volume, series, address, edition, month, note, key;
    {
        metodienNimet.put("getAuthor", "author");
        metodienNimet.put("getEditor", "editor");
        metodienNimet.put("getTitle", "title");
        metodienNimet.put("getPublisher", "publisher");
        metodienNimet.put("getYear", "year");
        metodienNimet.put("getVolume", "volume");
        metodienNimet.put("getSeries", "series");
        metodienNimet.put("getAddress", "address");
        metodienNimet.put("getEdition", "edition");
        metodienNimet.put("getMonth", "month");
        metodienNimet.put("getNote", "note");
        metodienNimet.put("getKey", "key");
    }
    
    public void setAuthor(String author) {
        
        this.author = author;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public Map<String, String> getAll(){
        Map<String, String> all = new HashMap<String, String>();
        for (Method method : metodit) {
            if(metodienNimet.containsKey(method.getName())){
                String arvo =  (String) ReflectionUtils.invokeMethod(method, this);
                if(arvo != null && !arvo.trim().isEmpty()){
                    all.put(metodienNimet.get(method.getName()), arvo);
                }
            }
        }
        return all;
    }
}
