package Reusables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Use {
    public static WebDriver driver;

    public static WebDriver browser(ChooseBrowser chooseBrowser) {
        switch (chooseBrowser) {
            case Edge:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("The Browser is Edge");
                return driver;

            case Chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("The Browser is Chrome");
                return driver;
        }
        return null;
    }

    public static void inputText(WebElement element, String productName) {
        element.clear();
        element.sendKeys(productName + Keys.ENTER);
    }

    public static void myWindowsHandle() {
        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windows);
        driver.switchTo().window(windowList.get(1));

    }

    public static void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);

    }

    public static void jsClick(WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
