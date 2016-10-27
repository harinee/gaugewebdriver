package com.tests.pages;

import com.tests.helpers.ui.Page;
import com.tests.helpers.util.Generator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Page {

    @FindBy(id="user_first_name")
    private WebElement firstName;

    @FindBy(id="user_last_name")
    private WebElement lastName;

    @FindBy(id="user_email")
    private WebElement email;

    @FindBy(id="user_password")
    private WebElement password;

    @FindBy(id="user_password_confirmation")
    private WebElement passwordConfirmation;

    @FindBy(name="commit")
    private WebElement signUp;

    public RegistrationPage(){
        initElements(this);
    }

    public void submitUserDetails() throws InterruptedException {
        fill(firstName, "First name").with(Generator.randomShortText());
        fill(lastName, "Last name").with(Generator.randomShortText());
        fill(email, "Email").with(Generator.randomShortText()+"@t.com");
        fill(password, "Password").with("@12345ab");
        fill(passwordConfirmation, "Password Confirmation").with("@12345ab");
        click(signUp, "Sign up button");
    }
}
