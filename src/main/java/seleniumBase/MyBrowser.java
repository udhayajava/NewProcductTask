package seleniumBase;

import Reusables.ChooseBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static Reusables.Use.browser;
import static Reusables.Use.driver;

public class MyBrowser {
    public static Properties properties;

    @BeforeMethod
    public void launchBrowser() throws IOException {
        driver = browser(ChooseBrowser.Edge);
        driver.manage().window().maximize();
        FileInputStream stream = new FileInputStream("AutomationPract.properties");
        properties = new Properties();
        properties.load(stream);
        driver.navigate().to(properties.getProperty("Url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
