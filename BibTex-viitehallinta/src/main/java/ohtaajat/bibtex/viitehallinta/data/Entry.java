package ohtaajat.bibtex.viitehallinta.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class Entry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Field> fields = new ArrayList<Field>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    
    public void addField(Field field){
        this.fields.add(field);
    }
    public void addFields(Map<String, String> fields){
        for (String key : fields.keySet()) {
            this.fields.add(new Field(key, fields.get(key)));
        }
    }
    
    public String getFieldValue(String name){
        for (Field field : fields) {
            if(field.getName().equals(name)){
                return field.getValue();
            }
        }
        return null;
    }
}
