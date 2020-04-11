import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    WebDriver driver;
    MainPage mainPage;
    SignInPage signInPage;
    String login = PrivateData.getLOGIN(); // enter your GitHub login, password and your GitHubName in Private Data;
    String password = PrivateData.getPASSWORD();
    String yourGitHubName = PrivateData.getYOU_GH_NAME();


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QS_Specialist\\IdeaProjects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        signInPage = new SignInPage(driver);
        mainPage = signInPage.logIn(login, password);
    }

    @Test
    public void createNewRepo() throws InterruptedException {
        String repoName = "testRepo";
        CreateRepoPage createRepoPage = new CreateRepoPage(driver);
        mainPage.clickCreateRepoButton();
        createRepoPage.typeRepoName(repoName);
        createRepoPage.clickCheckBox();
        TimeUnit.SECONDS.sleep(3);
        createRepoPage.pressEnterButton();
        Assert.assertEquals(String.format("https://github.com/%s/%s", yourGitHubName, repoName), driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
