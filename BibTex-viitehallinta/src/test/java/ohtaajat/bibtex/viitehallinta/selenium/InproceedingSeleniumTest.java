/*
package ohtaajat.bibtex.viitehallinta.selenium;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Before;
import org.junit.Test;


public class InproceedingSeleniumTest {
    
    private WebDriver driver;
 
   
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }
    
    @Test
    public void addingNewInproceedingWorks() throws Exception {
        driver.get("http://localhost:8080/");

        WebElement element = driver.findElement(By.linkText("Create new inproceeding"));
        element.click();
        WebElement author = driver.findElement(By.name("author"));
        WebElement title = driver.findElement(By.name("title"));
        WebElement year = driver.findElement(By.name("year"));
        WebElement booktitle = driver.findElement(By.name("booktitle"));
       
        author.sendKeys("inpro3");
        title.sendKeys("inpro otsikko");
        year.sendKeys("2005");
        booktitle.sendKeys("joku");
        author.submit();
        
        assertEquals(true, driver.getPageSource().contains("inpro3"));
        assertEquals(true, driver.getPageSource().contains("inpro otsikko"));
    }
 

}
 */