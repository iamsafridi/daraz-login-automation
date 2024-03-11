package page;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends Setup {

    @FindBy(tagName = "input")
    List<WebElement> txtEmail;
    @FindBy(css = "[type=\"password\"]")
    WebElement txtPassword;

    @FindBy(css = "[type=\"submit\"]")
    WebElement loginBtn;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email,String password){
        txtEmail.get(2).sendKeys(email);
        txtPassword.sendKeys(password);
        loginBtn.click();
    }
}
