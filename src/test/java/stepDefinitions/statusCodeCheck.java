package stepDefinitions;

import Pages.GundemPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class statusCodeCheck {

    GundemPage gundemPage =new GundemPage();
    Actions actions =new Actions(Driver.getDriver());


    @Step("Verify HTTP 200 status codes for slider items")
    public void verifySliderItemsHttpStatus() {


        List<WebElement> sliderItems = gundemPage.swiperPaginition;


        for (int i = 0; i < sliderItems.size(); i++) {

            sliderItems = gundemPage.swiperPaginition;
            String expectedUrl = sliderItems.get(i).getAttribute("href");

            actions.moveToElement(sliderItems.get(i)).click().perform();

            BrowserUtils.waitForPageToLoad(3);


            String actualUrl = Driver.getDriver().getCurrentUrl();

            int statusCode = getHTTPResponseStatusCode(actualUrl);
            Assert.assertEquals(200,statusCode);

            System.out.println("HTTP Status 200: " + actualUrl);


            Assert.assertEquals(expectedUrl,actualUrl);
            System.out.println("Test Passed: Correct news article opened.");


            Driver.getDriver().navigate().back();


            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }

    private int getHTTPResponseStatusCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
