package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AccountPage {
    WebDriver driver;

    By loginHeaderBy= By.xpath("//div[@class=\"u-column1 col-1\"]//child::h2");
    WebElement loginHeaderWE;

    By userNameInputBy= By.xpath("//input[@id=\"username\"]");
    WebElement userNameInputWE;

    By passwordInputBy= By.xpath("//input[@id=\"password\"]");
    WebElement passwordInputWE;

    By loginButtonBy= By.xpath("//input[@name=\"login\"]");
    WebElement loginButtonWE;
    WebElement consentButton;

    By dashboardHeaderBy= By.xpath("//a[text()=\"Dashboard\"]");
    WebElement dashboardHeaderByWE;
       @Given("je suis sur la page MyAccount")
    public void jeSuisSurLaPageMyAccount() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\Formation Testeur Logiciel\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/my-account");
    }

    @When("je verifie le pavé Login")
    public void jeVerifieLePavéLogin() {
        loginHeaderWE=driver.findElement(loginHeaderBy);
    }

    @Then("le pavé Login est existe")
    public void lePavéLoginEstExiste() {
        String regH=loginHeaderWE.getText();
        System.out.println("un pavé : "+regH);
        Assert.assertEquals(regH,"Login","n'existe pas");
    }

    @Given("je suis sur la page d'acceuil")
    public void jeSuisSurLaPageDAcceuil() {
        System.out.println("je suis sur la page d'acceuil");
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/my-account");
        if(driver == null) {
            System.out.println("driver: null ");
        } else {
            System.out.println("driver: "+ driver.getCurrentUrl());

        }
        consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));
        if(consentButton == null) {
            System.out.println("Button: null ");
        } else {
            System.out.println("Button: "+consentButton.getText());

        }
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled())
        { consentButton.click(); }
    }

    @When("je saisie email {string}")
    public void jeSaisieEmail(String userName, WebDriver driver2) {

        userNameInputWE= driver2.findElement(userNameInputBy);
         userNameInputWE.sendKeys(userName);

    }

    @And("je saisie Password {string}")
    public void jeSaisiePassword(String password, WebDriver driver2) {

        passwordInputWE=driver2.findElement(passwordInputBy);
        passwordInputWE.sendKeys(password);
    }

    @And("je clique Login")
    public void jeCliqueLogin(WebDriver driver2) {
        loginButtonWE=driver2.findElement(loginButtonBy);
        loginButtonWE.click();
    }

    @Then("je suis sur la page Dashboard")
    public void jeSuisSurLaPageDashboard() {
        dashboardHeaderByWE=driver.findElement(dashboardHeaderBy);
        String dash=dashboardHeaderByWE.getText();
        Assert.assertEquals(dash,"Dashboard","N'existe pas");
        //return new MyAccountPage(driver);
    }

}
