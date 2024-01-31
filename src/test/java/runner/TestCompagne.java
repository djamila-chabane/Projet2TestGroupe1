package runner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCompagne {
    String siteDemo="https://practice.automationtesting.in/my-account";
    String email="yassvega@outlook.fr";
    String password="Groupe01/2024";

    WebDriver driver;

    @BeforeTest
    public void Setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\Formation Testeur Logiciel\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @Test
    public void testcampaign() {
        driver.get(siteDemo);
// Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Consent']"));
// Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled())
        { consentButton.click(); }
        // Trouver l'élément à l'aide de l'XPath

        HomePage home= new HomePage(driver);
        home.enterLoginPsswd(email, password);
      //  home.VerifyPasswordStrength(password);
        home.clickButtonRegister();

    }

    @AfterTest
    public void Teardown() throws Exception {
        //close browser

   //     driver.close();
    }
}
