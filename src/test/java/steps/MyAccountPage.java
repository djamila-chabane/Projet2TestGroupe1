package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MyAccountPage {

    By addresslinkBy= By.xpath("//a[text()=\"Addresses\"]");
    WebElement adresslinkWE;
    WebDriver driver;
    String userName="yassvega@outlook.fr";
    String mdp="Groupe01/2024";

    AccountPage account= new AccountPage();
    WebElement consentButton;
    @Given("je suis connectée a mon compte")
    public void jeSuisConnectéeAMonCompte() {
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/my-account");
        if(driver == null) {
            System.out.println("driver: null ");
        } else {
            System.out.println("driver: "+ driver.getCurrentUrl());

        }
        consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));

        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled())
        { consentButton.click(); }
        System.out.println("Saisie password");
        account.jeSaisiePassword(mdp, driver);
        System.out.println("saisir userName");

        account.jeSaisieEmail(userName, driver);
        account.jeCliqueLogin(driver);
    }

    @When("je verifie la presence de lien Adresses")
    public void jeVerifieLaPresenceDeLienAdresses() {
        System.out.println("je verifie la presence de lien Adresses");

        adresslinkWE= driver.findElement(addresslinkBy);
        String adresslink= adresslinkWE.getText();
        System.out.println(adresslink);
        Assert.assertEquals(adresslink,"Addresses","Lien adress not exist");
    }

    @And("je clique sur le lien Adresses")
    public void jeCliqueSurLeLienAdresses() {
        adresslinkWE.click();

    }

    @Then("JE redirige vers la page Adresses")
    public void jeRedirigeVersLaPageAdresses() {
    }

    @Given("je suis connectée à mon compte")
    public void jeSuisConnectéeÀMonCompte() {
    }

    @When("je vérifie si un lien LogOut existe")
    public void jeVérifieSiUnLienLogOutExiste() {
    }

    @And("je clique sur le lien Logout")
    public void jeCliqueSurLeLienLogout() {
    }

    @Then("je redirige vers la page Login")
    public void jeRedirigeVersLaPageLogin() {
    }
}
