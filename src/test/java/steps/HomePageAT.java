package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageAT {
    WebDriver driver;


    By registerHeaderBy= By.xpath("//div[@class=\"u-column2 col-2\"]//child::h2");
    WebElement registerHeaderWE;
    By emailInputBy= By.xpath("//input[@id='reg_email']");
    WebElement emailInputWE;



    By passwordInputBy= By.xpath("//input[@id='reg_password']");
    WebElement passwordInputWE;

    By registerButtonBy= By.xpath("//input[@name='register']");
    WebElement registerButtonWE;
    // Rechercher le bouton "Consent" en utilisant un xpath relatif
    //Scenario: Vérifier qu’un pavé “register” existe sur la page
    @Given("j'ouvre la page My Account")
    public void jOuvreLaPageMyAccount() {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\Formation Testeur Logiciel\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/my-account");
    }

    @When("je verifie si le pavé {string} existe")
    public void jeVerifieSiLePavéExiste(String arg0) {
        registerHeaderWE=driver.findElement(registerHeaderBy);
    }

    @Then("le pavé {string} existe sur la pag")
    public void lePavéExisteSurLaPag(String header) {

        String regH=registerHeaderWE.getText();
        System.out.println("un pavé : "+regH);
        Assert.assertEquals(regH,header,"n'existe pas");
    }

    //Creation Compte Client

    @When("Je saisie mon nom")
    public void jeSaisieMonNom() {
        System.out.println("le champs Nom n'existe pas...annomalie");

    }
    @And("je saisie mon prenom")
    public void jeSaisieMonPrenom() {
        System.out.println("le champs Prenom n'existe pas...annomalie");

    }
    @And("je saisie mon email {string}")
    public void jeSaisieMonEmail(String email) {

        WebElement consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));
        System.out.println("Button: "+consentButton.getText());
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled())
        { consentButton.click(); }
        emailInputWE=driver.findElement(emailInputBy);
        StringBuffer email2 = new StringBuffer(email);
        int indice=(int) (Math.random() * 26);
        System.out.println("indice "+indice);
        email2.insert(0,indice);
        System.out.println("je saisie MonEmail "+email2);
        emailInputWE.sendKeys(email2);

    }
    @And("je saisie mon password  {string}")
    public void jeSaisieMonPassword(String password) {
        passwordInputWE=driver.findElement(passwordInputBy);
        passwordInputWE.sendKeys(password);
    }

    @And("je clique sur la le boutton {string}")
    public void jeCliqueSurLaLeBoutton(String arg0) {
        registerButtonWE=driver.findElement(registerButtonBy);
        registerButtonWE.click();

    }
    @Then("la création de compte est validée")
    public void laCréationDeCompteEstValidée() {

        //return new MyAccountPage(driver);

    }



}
