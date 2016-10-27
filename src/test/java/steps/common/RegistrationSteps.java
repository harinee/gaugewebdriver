package steps.common;

import com.tests.pages.HomePage;
import com.tests.pages.LoginPage;
import com.thoughtworks.gauge.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationSteps {
    @Step("Sign up valid user")
    public void signUp() throws InterruptedException {
        assertThat("Login Page is displayed", new LoginPage().isReady(), is(true));
        new LoginPage().signUp().submitUserDetails();
        assertThat("Home Page is displayed", new HomePage().isReady(), is(true));
    }
}
