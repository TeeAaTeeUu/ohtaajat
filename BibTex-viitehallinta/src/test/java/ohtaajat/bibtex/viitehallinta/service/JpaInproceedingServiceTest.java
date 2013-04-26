/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtaajat.bibtex.viitehallinta.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import ohtaajat.bibtex.viitehallinta.data.Inproceeding;

import ohtaajat.bibtex.viitehallinta.service.InproceedingService;
import ohtaajat.bibtex.viitehallinta.service.JpaInproceedingService;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Teemu
 */
public class JpaInproceedingServiceTest {
    
    private InproceedingService service;
    private JpaInproceedingRepository arepo;
    @Before
    public void setUp() {
        arepo = new JpaInproceedingRepository();
        service = new JpaInproceedingService();
        Field field = null;
        try {
            field = service.getClass().getDeclaredField("arepo");
        } catch (NoSuchFieldException e) {
            System.out.println("Kenttää ei löydy");
        }
        field.setAccessible(true);
        try {
            field.set(service, arepo); 
        } catch (IllegalAccessException e) {
            System.out.println("Ei oikeuksia");
        }
        
    }
    @Test
    public void createNewInproceeding() {

        Inproceeding inproceeding = new Inproceeding();


        inproceeding.setAuthor("Pekka Puupaa");
        inproceeding.setTitle("Pekka ja Patka");
        inproceeding.setYear("1989");
        inproceeding.setBooktitle("Otava");

        service.create(inproceeding);

        assertEquals(1, arepo.count());


    }

    @Test
    public void listInproceedingWorks() {
        Inproceeding inproceeding = new Inproceeding();

        inproceeding.setAuthor("Pekka Puupaa");
        inproceeding.setTitle("Pekka ja Patka");
        inproceeding.setYear("1989");
        inproceeding.setBooktitle("Otava");

        service.create(inproceeding);

        assertEquals(arepo.findAll(), service.list());

    }

    @Test
    public void findInproceedingByIdWorks() {
        Inproceeding inproceeding = new Inproceeding();
        
        inproceeding.setId((long) 1);
        inproceeding.setAuthor("Pekka Puupaa");
        inproceeding.setTitle("Pekka ja Patka");
        inproceeding.setYear("1989");
        inproceeding.setBooktitle("Otava");
        service.create(inproceeding);

        assertEquals(inproceeding, service.findById((long) 1));

    }
    @Test
    public void deleteInproceedingWorks(){
        Inproceeding inproceeding = new Inproceeding();
        
        inproceeding.setId((long) 1);
        inproceeding.setAuthor("Pekka Puupaa");
        inproceeding.setTitle("Pekka ja Patka");
        inproceeding.setYear("1989");
        inproceeding.setBooktitle("Otava");
        service.create(inproceeding);
        service.delete((long) 1);
        assertEquals(0, arepo.count());
    }

    
    @Test
    public void findInproceedingByPartOfAuthorWorks(){
        Inproceeding inproceeding = new Inproceeding();
          
        inproceeding.setAuthor("Pekka Puupaa");
        inproceeding.setTitle("Pekka ja Patka");
        inproceeding.setYear("1989");
        inproceeding.setBooktitle("Otava");
        
        service.create(inproceeding);
        
        List<Inproceeding> list = new ArrayList<Inproceeding>();
        list = service.findByPartOfAuthor("Pekka Puupaa");
        String arvo = arepo.palautaArvo();
        
        assertEquals("%Pekka Puupaa%" , arvo);
    }
    
}
