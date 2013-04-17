import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can print books/inproceedings/articles as bibtex'

scenario "user can print books in bibtex", {
    given 'new book is added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/books/new");
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        publisher = driver.findElement(By.name("publisher"));

        author.sendKeys("Kirja3");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
    }
    when 'Kirjojen listaus in bibtex link is pressed', {
        driver.get("http://localhost:8080/app/books/bibtex");
    }
    then 'books are printed in bibtex', {
        tuloste = driver.getPageSource();
        driver.getPageSource().contains("Kirja3").shouldBe true
        driver.getPageSource().contains("@").shouldBe true
    }
          
}

scenario "user can print inproceedings in bibtex", {
    given 'new inproceeding is added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/inproceedings/new");
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        publisher = driver.findElement(By.name("publisher"));

        author.sendKeys("inpro3");
        title.sendKeys("Kirjan otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
    }
    when 'List inproceedings link is pressed', {
        driver.get("http://localhost:8080/app/inproceedings/bibtex");
    }
    then 'inproceedings are printed in bibtex', {
        tuloste = driver.getPageSource();
        driver.getPageSource().contains("inpro3").shouldBe true
        driver.getPageSource().contains("@").shouldBe true
    }
          
}