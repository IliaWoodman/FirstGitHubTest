import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//основная страница после успешного входа

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By h1 = By.xpath("//h1");
    private By createRepoButton = By.xpath("(//a[@href = \"/new\"])[2]");
    private By repoList = By.xpath("(//div[@class=\"js-repos-container\"])[1]//a[contains(@href, \"/IliaWoodman/\")]");

    public String getH1Text() {
        return driver.findElement(h1).getText();
    }

    public CreateRepoPage clickCreateRepoButton() {
        driver.findElement(createRepoButton).click();
        return new CreateRepoPage(driver);
    }

    public CreatedRepoPage getRepoListAndRandomClick() {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(repoList);
        list.get(new Random().nextInt(list.size()-1));
        return new CreatedRepoPage(driver);
    }

}
