package testRun;

import com.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumBase.MyBrowser;

public class TestRunAutomationPractice extends MyBrowser {
    @Test
    public void testRun() throws InterruptedException {
        WelcomePage pages = new WelcomePage();
        Assert.assertEquals(pages.urlCheck(), true);
        Assert.assertEquals(pages.logoIsDisplayed(), true);
        Assert.assertEquals(pages.dressesButton(), true);
        Assert.assertEquals(pages.womenButton(), true);
        Assert.assertEquals(pages.tShirtButton(), true);
        pages.searchBox(properties.getProperty("SearchText"));
        pages.verifySearchContent();
        pages.searchProduct();

    }
}
