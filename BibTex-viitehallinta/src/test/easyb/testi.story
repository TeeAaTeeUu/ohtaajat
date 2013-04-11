import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can log in with valid username/password-combination'

scenario "user can login with correct password", {
    given 'login selected'

    when 'a valid username and password are given'
 
    then 'user will be logged in to system'
}