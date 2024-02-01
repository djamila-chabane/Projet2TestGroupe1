package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class HomePage {

    WebDriver driver;

    By emailInputBy= By.xpath("//input[@id='reg_email']");
    WebElement emailInputWE;

    By passwordInputBy= By.xpath("//input[@id='reg_password']");
    WebElement passwordInputWE;

    By registerButtonBy= By.xpath("//input[@name='register']");
    WebElement registerButtonWE;

    By passwordStrength= By.xpath("//div[@class='woocommerce-password-strength strong']");
    WebElement passwordStrengthWE;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterLoginPsswd(String email,String password) {

        emailInputWE=driver.findElement(emailInputBy);
       System.out.println(email);
       emailInputWE.sendKeys(email);
       passwordInputWE=driver.findElement(passwordInputBy);
      passwordInputWE.sendKeys(password);

    }

    /*public void VerifyPasswordStrength(String password)
    {
        passwordStrengthWE=driver.findElement(passwordStrength);
        String msgPasswordStrength=passwordStrengthWE.getText();
        System.out.println(msgPasswordStrength);

        Assert.assertEquals(msgPasswordStrength, "Strong", "Le mot de passe doit être composé à minima de 7 caractères et contenir à minima une majuscule, une\r\n"
                + "minuscule, un chiffre et un caractère spécial");

    }*/

    public MyAccountPage clickButtonRegister()
    {
        registerButtonWE=driver.findElement(registerButtonBy);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.elementToBeClickable(registerButtonWE));
        registerButtonWE.click();
        return new MyAccountPage(driver);
    }


}
