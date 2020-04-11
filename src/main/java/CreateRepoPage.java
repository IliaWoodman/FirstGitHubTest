import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//станица создания репозитория

public class CreateRepoPage {
    WebDriver driver;
    public CreateRepoPage(WebDriver driver){
        this.driver = driver;
    }
    private By repoName = By.xpath("//input[@id = \"repository_name\"]");
    private By createReadmeCheckbox = By.xpath("//input[@id = \"repository_auto_init\"]");
    private By createRepoButton = By.xpath("(//button[@type = \"submit\"])[2]");

    public CreateRepoPage typeRepoName(String name){
        driver.findElement(repoName).sendKeys(name);
        return this;
    }
    public CreateRepoPage clickCheckBox(){
        driver.findElement(createReadmeCheckbox).click();
        return this;
    }
    public CreatedRepoPage pressEnterButton(){
        driver.findElement(By.xpath("//input[@id = \"repository_name\"]")).sendKeys(Keys.ENTER);;
        return new CreatedRepoPage(driver);
    }
}

