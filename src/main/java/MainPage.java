import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//основная страница после успешного входа

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By h1 = By.xpath("//h1");
    private By createRepoButton = By.xpath("(//a[@href = \"/new\"])[2]");

    public String getH1Text(){
        return driver.findElement(h1).getText();
    }
    public CreateRepoPage clickCreateRepoButton(){
         driver.findElement(createRepoButton).click();
         return new CreateRepoPage(driver);
    }

}
