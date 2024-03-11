package testrunner;

import config.Setup;

import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTestRunner extends Setup {
        @Test(description = "User can login successfully",priority = 1)
        public void doLogin(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.doLogin("shahidafridi.baymax@gmail.com","Afridi@@afridI144");
        }
        init
}
