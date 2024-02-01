package pages;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    WebDriver driver;
    By headerLoginBy= By.xpath("//input[@id='reg_email']");
    WebElement headerLoginWE;
    public MyAccountPage (WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;
    }


}
