import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can print books/inproceedings/articles in cleartext'

scenario "user can print books in cleartext", {
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
    when 'kirjojen listaus link is pressed', {
        driver.get("http://localhost:8080/app/books");
    }
    then 'book list is printed in cleartext', {
        driver.getPageSource().contains("Kirjan otsikko").shouldBe true
    }
}

scenario "user can print inproceedings in cleartext", {
     given 'new inproceeding is added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/inproceedings/new");
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        booktitle = driver.findElement(By.name("booktitle"));

        author.sendKeys("inproceeding3");
        title.sendKeys("Inproceeding headline");
        year.sendKeys("2005");
        booktitle.sendKeys("joku");
        author.submit();
    }
    when 'List inproceedings link is pressed', {
        driver.get("http://localhost:8080/app/inproceedings");
    }
    then 'inproceedings list is printed in cleartext', {
        driver.getPageSource().contains("Inproceeding headline").shouldBe true
    }      
}

scenario "user can print articles in cleartext", {
     given 'new article is added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/articles/new");
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        journal = driver.findElement(By.name("journal"));

        author.sendKeys("article3");
        title.sendKeys("article headline");
        year.sendKeys("2005");
        journal.sendKeys("joku");
        author.submit();
    }
    when 'List articles link is pressed', {
        driver.get("http://localhost:8080/app/articles");
    }
    then 'articles list is printed in cleartext', {
        driver.getPageSource().contains("article headline").shouldBe true
    }      
}