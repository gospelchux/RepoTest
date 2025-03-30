import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class RepositoryCreationTest {
    WebDriver driver;

    @BeforeTest
    public void prepareBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    @Test
    public void testRepositoryCreation() {
        // Login
        driver.findElement(By.id("email")).sendKeys("gospel@test.com");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();

        // Navigate to repository creation
        driver.findElement(By.id("newRepo")).click();
        driver.findElement(By.id("repoName")).sendKeys("Test Repository");
        driver.findElement(By.id("createButton")).click();

        // Verify creation
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed(), "Repository was not created successfully");
    }

}
