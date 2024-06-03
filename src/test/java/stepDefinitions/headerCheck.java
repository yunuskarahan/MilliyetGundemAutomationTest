package stepDefinitions;

import Pages.HomePage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;

public class headerCheck {


    HomePage homePage = new HomePage();

    @Step("Open Milliyet homepage")
    public void openMilliyetHomePage() {

        Driver.getDriver().get(System.getenv("url"));
        BrowserUtils.verifyContainsTitle("Milliyet");
    }


    @Step("Click on the Gündem category button")
    public void clickGundemCategoryButton() {
        Assert.assertTrue(homePage.gundemButton.isDisplayed());
        BrowserUtils.waitForClickablility(homePage.gundemButton, 2);
        homePage.gundemButton.click();
        BrowserUtils.waitForPageToLoad(3);
    }


    @Step("Verify that the Gündem page is opened in a new tab with the this <expectedUrl>  URL")
    public void verifyGundemPageOpened(String expectedUrl) {

        ArrayList<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(1));

        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        System.out.println("expectedUrl = " + expectedUrl);
        Assert.assertEquals(expectedUrl, actualUrl);

    }

}