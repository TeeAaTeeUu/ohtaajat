import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User search book/inproceeding/article by author'

scenario "user can search entries by author", {
    given 'new entry is created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/books/new");
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        publisher = driver.findElement(By.name("publisher"));

        author.sendKeys("Testi Testi");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
    }
    and 'Search entries is selected', {
        driver.get("http://localhost:8080/app/entries");
    }
    when 'excisting author name is given', {
        author2 = driver.findElement(By.name("author"))
        author2.sendKeys("Testi Testi");
        author2.submit();
    }
    then 'list of entries by author name are listed', {
        driver.getPageSource().contains("year").shouldBe true
        driver.getPageSource().contains("2005").shouldBe true
        driver.getPageSource().contains("joku").shouldBe true
    }

}

scenario "when non-excisting author name is given list is empty", {
    given 'Search entries is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/entries");
        
    }
    when 'non-excisting author name is given', {
        author = driver.findElement(By.name("author"));
        author.sendKeys("Testi");
        author.submit();
    }
    then 'list of entries by author name are listed', {
        driver.getPageSource().contains("List of entryes with author name Testi").shouldBe true
        driver.getPageSource().contains("year").shouldBe false
    }

}