package ohtaajat.bibtex.viitehallinta.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BookSeleniumTest {
    
    private String port;
    private WebDriver driver;
    private String baseUrl;
    
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
        port = System.getProperty("jetty.port", "8080");
        baseUrl = "http://localhost:" + port +"/app";
    }
    
    @Test
    public void testaaEttaSaadaanKirjanLisaysLomakeOsoitteestaBook(){
        driver.get(baseUrl+"/book");
        System.out.println();
        assertTrue("Ei löydy kirja otsikkoa", driver.getPageSource().contains("Kirja"));
        assertTrue("Ei löydy author kenttää", driver.getPageSource().contains("Author"));
        assertTrue("Ei löydy title kenttää", driver.getPageSource().contains("Title"));
        assertTrue("Ei löydy year kenttää", driver.getPageSource().contains("Year"));
        assertTrue("Ei löydy publisher kenttää", driver.getPageSource().contains("Publisher"));
    }
    
    @Test
    public void testaaEttaKirjanLisaaminenOnnistuu(){
        driver.get(baseUrl+"/book");
        
        WebElement author = driver.findElement(By.name("author"));
        WebElement title = driver.findElement(By.name("title"));
        WebElement year = driver.findElement(By.name("year"));
        WebElement publisher = driver.findElement(By.name("publisher"));
        
        author.sendKeys("Kirja3");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        
        author.submit();
        assertTrue(driver.getPageSource().contains("New book created!"));
    }
}