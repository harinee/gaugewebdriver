package steps.common;

import com.tests.pages.LoginPage;
import com.thoughtworks.gauge.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps {

    @Step("Login page should be displayed")
    public void isAtLoginPage() throws InterruptedException {
        assertThat("Login page should be displayed", new LoginPage().isReady(), is(true));
    }
}