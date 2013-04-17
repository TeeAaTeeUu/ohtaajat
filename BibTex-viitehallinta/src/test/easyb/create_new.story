import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a new book/inproceeding/article combination'

scenario "user can create new book", {
    given 'Kirjan luonti is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/books/new");
    }
    when 'valid book information are given', {
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
    then 'new book is created', {
        driver.getPageSource().contains("New book created!").shouldBe true
    }
}    

scenario "user can create new inproceeding", {
    given 'Create new inproceeding is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/inproceedings/new");
    }
    when 'valid inproceeding information are given', {
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        publisher = driver.findElement(By.name("publisher"));

        author.sendKeys("inpro3");
        title.sendKeys("inpro otsikko");
        year.sendKeys("2005");
        publisher.sendKeys("joku");
        author.submit();
    }
    then 'new inproceeding is created', {
        driver.getPageSource().contains("New inproceeding created!").shouldBe true
    }
}    

scenario "user can create new article", {
    given 'Create new article is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/articles/new");
    }
    when 'valid article information are given', {
        author = driver.findElement(By.name("author"));
        title = driver.findElement(By.name("title"));
        year = driver.findElement(By.name("year"));
        journal = driver.findElement(By.name("journal"));

        author.sendKeys("arti3");
        title.sendKeys("arti otsikko");
        year.sendKeys("2005");
        journal.sendKeys("joku");
        author.submit();
    }
    then 'new article is created', {
        driver.getPageSource().contains("New article created!").shouldBe true
    }
}
