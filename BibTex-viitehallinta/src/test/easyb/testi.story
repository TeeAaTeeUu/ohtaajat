import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a new book'

scenario "user can create new book", {
    given 'create a new book selected'
        driver = new HtmlUnitDriver()
        port = System.getProperty("jetty.port", "8084")
        baseUrl = "http://localhost:" + port +"/app"
        driver.get(baseUrl+"/book")

        author = driver.findElement(By.name("author"))
        title = driver.findElement(By.name("title"))
        year = driver.findElement(By.name("year"))
        publisher = driver.findElement(By.name("publisher"))

        author.sendKeys("Kirja3")
        title.sendKeys("Kirjan otsikko")
        year.sendKeys("2005")
        publisher.sendKeys("joku")

    when 'valid book information are given'
        author.submit()
 
    then 'new book is created'
        tuloste = driver.getPageSource()
        tuloste.shouldBe "New book created!"
        
}