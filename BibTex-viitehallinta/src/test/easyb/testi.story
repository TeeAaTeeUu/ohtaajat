import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a new book'

scenario "user can create new book", {
    given 'create a new book selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/app/book");
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
        tuloste = driver.getPageSource();
        tuloste.shouldBe "New book created!"
    }
}