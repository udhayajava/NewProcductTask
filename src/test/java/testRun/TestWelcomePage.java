package testRun;

import com.pages.SearchTest;
import com.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumBase.MyBrowser;

public class TestWelcomePage extends MyBrowser {
    @Test
    public void testRun() {
        WelcomePage pages = new WelcomePage();
        Assert.assertTrue(pages.urlCheck());
        Assert.assertTrue(pages.logoIsDisplayed());
        Assert.assertTrue(pages.orderButton());
        Assert.assertTrue(pages.searchButton());
        pages.searchBox();
        SearchTest test = new SearchTest();
        test.verifySearchContent();
        test.searchProduct();
        test.verifySearchResult();
        test.findMaxAndMinPriceOfProduct();
        test.productInStock();
    }
}

