/* 
package ohtaajat.bibtex.viitehallinta.selenium;

import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Before;
import org.junit.Test;


public class ArticleSeleniumTest {
    
    private WebDriver driver;
 
   
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }
   
    @Test
    public void addingNewArticleWorks() throws Exception {
        driver.get("http://localhost:8080/");

        WebElement element = driver.findElement(By.linkText("Create new article"));
        element.click();
        WebElement author = driver.findElement(By.name("author"));
        WebElement title = driver.findElement(By.name("title"));
        WebElement year = driver.findElement(By.name("year"));
        WebElement journal = driver.findElement(By.name("journal"));
       
        author.sendKeys("arti3");
        title.sendKeys("arti otsikko");
        year.sendKeys("2005");
        journal.sendKeys("joku");
        author.submit();
        
        assertEquals(true, driver.getPageSource().contains("arti3"));
        assertEquals(true, driver.getPageSource().contains("arti otsikko"));
    }
    
  

}*/