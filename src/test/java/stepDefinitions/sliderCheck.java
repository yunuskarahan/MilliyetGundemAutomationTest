package stepDefinitions;

import Pages.GundemPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sliderCheck {


    GundemPage gundemPage = new GundemPage();
    Actions actions = new Actions(Driver.getDriver());

    @Step("Click on each image in the slider and verify that it opens the correct news article in a new tab")
    public void verifySliderImage() {


        try {
            gundemPage.iframeAdd.isDisplayed();
            BrowserUtils.waitForClickablility(gundemPage.iframeCloseButton, 2);
            gundemPage.iframeCloseButton.click();


            List<WebElement> sliderItems = gundemPage.allSlides;

            for (int i = 0; i < sliderItems.size(); i++) {

                sliderItems = gundemPage.allSlides;

                String originalUrl = Driver.getDriver().getCurrentUrl();


                String expectedUrl = sliderItems.get(i).getAttribute("href");


                actions.moveToElement(sliderItems.get(i)).click().perform();


                BrowserUtils.waitForPageToLoad(3);


                String actualUrl = Driver.getDriver().getCurrentUrl();


                if (actualUrl.equals(expectedUrl)) {
                    System.out.println("Test Passed: Correct news  opened after clicking on the image.");
                } else {
                    System.out.println("Failed: Incorrect news  opened after clicking on the image.");
                }

                // Geri dön
                Driver.getDriver().navigate().back();


                String backUrl = Driver.getDriver().getCurrentUrl();
                if (originalUrl.equals(backUrl)) {
                    System.out.println("Returned to the original page.");
                } else {
                    System.out.println("Did not return to the original page.");
                }
            }


        } catch (Exception e) {


            List<WebElement> sliderItems = gundemPage.allSlides;

            for (int i = 0; i < sliderItems.size(); i++) {

                sliderItems = gundemPage.allSlides;

                String originalUrl = Driver.getDriver().getCurrentUrl();


                String expectedUrl = sliderItems.get(i).getAttribute("href");


                actions.moveToElement(sliderItems.get(i)).click().perform();


                BrowserUtils.waitForPageToLoad(3);


                String actualUrl = Driver.getDriver().getCurrentUrl();


                if (actualUrl.equals(expectedUrl)) {
                    System.out.println("Test Passed: Correct news  opened after clicking on the image.");
                } else {
                    System.out.println("Failed: Incorrect news  opened after clicking on the image.");
                }

                // Geri dön
                Driver.getDriver().navigate().back();


                String backUrl = Driver.getDriver().getCurrentUrl();
                if (originalUrl.equals(backUrl)) {
                    System.out.println("Returned to the original page.");
                } else {
                    System.out.println("Did not return to the original page.");
                }
            }

        }


    }


    @Step("Click on each number in the slider and verify that it opens the correct news article in a new tab")
    public void verifySliderNumber() {


        List<WebElement> sliderItems = gundemPage.swiperPaginition;

        for (int i = 0; i < sliderItems.size(); i++) {

            sliderItems = gundemPage.swiperPaginition;

            String originalUrl = Driver.getDriver().getCurrentUrl();


            String expectedUrl = sliderItems.get(i).getAttribute("href");



            actions.moveToElement(sliderItems.get(i)).click().perform();


            BrowserUtils.waitForPageToLoad(3);


            String actualUrl = Driver.getDriver().getCurrentUrl();


            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: Correct news opened after clicking on the number.");
            } else {
                System.out.println(actualUrl + " ------- " + expectedUrl + "Failed: Incorrect news  opened after clicking on the number.");
            }


            Driver.getDriver().navigate().back();
            BrowserUtils.waitForPageToLoad(3);


            String backUrl = Driver.getDriver().getCurrentUrl();
            if (originalUrl.equals(backUrl)) {
                System.out.println("Returned to the original page.");
            } else {
                System.out.println("Did not return to the original page.");
            }
        }


    }
}
