
package ohtaajat.bibtex.viitehallinta.selenium;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Teemu
 */
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
        WebElement author = driver.findElement(By.name("author"));
        WebElement title = driver.findElement(By.name("title"));
        WebElement year = driver.findElement(By.name("year"));
        WebElement publisher = driver.findElement(By.name("publisher"));

        
        author.sendKeys("Kirja3");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
        System.out.println(driver.getPageSource());

        


    }

}
