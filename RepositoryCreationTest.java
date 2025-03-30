import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RepositoryCreationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://repository-management-app.com/login");
    }

    @Test
    public void testRepositoryCreation() {
        // Login
        driver.findElement(By.id("username")).sendKeys("testUser");
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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
