package testrunner;

import config.Setup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoginPage;

public class LoginTestRunner extends Setup {
    @Test(priority = 1,description = "User cannot login with empty field")
    public void emptyField(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("","");
        //*[@id="container"]/div/div[2]/form/div/div[1]/div[1]/span

        String message = driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/span")).get(0).getText();
        Assert.assertTrue(message.contains("You can't leave this empty."));
    }
    @Test(priority = 2,description = "User cannot login with invalid email")
    public void invalidEmail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("asd","");
        driver.get("https://member.daraz.com.bd/user/login");

//        //*[@id="container"]/div/div[2]/form/div/div[1]/div[1]/span
//        String message = driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/span")).get(0).getText();
//        Assert.assertTrue(message.contains("The length of the Phone or Email should be 6-60 characters"));

        String alertActual= driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/span")).get(0).getText();
        String alertExpected="The length of the Phone or Email should be 6-60 characters.";
        SoftAssert softAssert=new SoftAssert(); //soft assertion
        softAssert.assertTrue(alertActual.contains(alertExpected));
        softAssert.assertAll();
    }
    @Test(priority = 4,description = "User can login successfully")
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("shahidafridi.baymax@gmail.com","Afridi@@afridI144");
//        String message = driver.findElements(By.className("dashboard-mod-title")).get(0).getText();
//        Assert.assertTrue(message.contains("Personal Profile"));
        String alertActual= driver.findElements(By.className("dashboard-mod-title")).get(0).getText();
        String alertExpected="Personal Profile";
        SoftAssert softAssert=new SoftAssert(); //soft assertion
        softAssert.assertTrue(alertActual.contains(alertExpected));
        softAssert.assertAll();
       driver.get("https://member.daraz.com.bd/user/logout");
    }
    @Test(priority = 3,description = "User cannot login with valid email invalid password")
    public void invalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("asd@gmail.com","123");
    }

}
