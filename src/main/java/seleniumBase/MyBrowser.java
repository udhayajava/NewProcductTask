package seleniumBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MyBrowser {
    public static WebDriver driver;
    public static Properties properties;

    @BeforeMethod
    public void launchBrowser() throws IOException {
        WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
        driver.manage().window().maximize();
        FileInputStream stream = new FileInputStream("AutomationPract.properties");
        properties = new Properties();
        properties.load(stream);
        driver.navigate().to(properties.getProperty("Url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
