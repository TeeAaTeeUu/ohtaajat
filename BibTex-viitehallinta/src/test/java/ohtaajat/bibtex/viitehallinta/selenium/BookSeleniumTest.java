   /* 
package ohtaajat.bibtex.viitehallinta.selenium;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Before;
import org.junit.Test;


public class BookSeleniumTest {
    
    private WebDriver driver;
 
   
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void addingNewBookWorks() throws Exception {
        driver.get("http://localhost:8080/");
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("Create new book"));
        element.click();
        WebElement author = driver.findElement(By.name("author"));
        WebElement title = driver.findElement(By.name("title"));
        WebElement year = driver.findElement(By.name("year"));
        WebElement publisher = driver.findElement(By.name("publisher"));
       
        author.sendKeys("Kirja3");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
        
        assertEquals(true, driver.getPageSource().contains("Kirja3"));
        assertEquals(true, driver.getPageSource().contains("Kirjan otsikko"));
    }
    

}
*/