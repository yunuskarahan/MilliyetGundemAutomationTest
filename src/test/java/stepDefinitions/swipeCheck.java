package stepDefinitions;

import Pages.GundemPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class swipeCheck {

    GundemPage gundemPage = new GundemPage();

    Actions actions = new Actions(Driver.getDriver());



    @Step("Open the Gündem page")
    public void openGundemPage(){


        Driver.getDriver().get(System.getenv("gundem_url"));




    }

    @Step("Verify swipe functionality with arrow buttons")
    public void verifySwipeWithArrowButtons(){

        List<WebElement> slides = gundemPage.slides;
        Set<Integer> uniqueSlidesIndexes = new HashSet<>();

        for (WebElement slide : slides) {
            int index = Integer.parseInt(slide.getAttribute("data-swiper-slide-index"));
            uniqueSlidesIndexes.add(index);
        }

        int totalUniqueSwipes = uniqueSlidesIndexes.size();


        String initialActiveLink = gundemPage.activeSlide.getAttribute("href");
        System.out.println("initialActiveLink = " + initialActiveLink);

        for (int i = 0; i < totalUniqueSwipes; i++) {
            String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide Before Click Left: " + activeLinkBefore);

            BrowserUtils.clickWithJS(gundemPage.leftSliderButton);
            BrowserUtils.waitFor(3);


            String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide After Click Left: " + activeLinkAfter);

            if (!activeLinkBefore.equals(activeLinkAfter)) {
                System.out.println("Click Left successful, link changed correctly.");
            } else {
                System.out.println("Click Left failed, link did not change.");
            }
        }

        for (int i = 0; i < totalUniqueSwipes; i++) {

            String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide Before Click Right: " + activeLinkBefore);

            BrowserUtils.clickWithJS(gundemPage.rightSliderButton);
            BrowserUtils.waitFor(3);


            String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide After Click right: " + activeLinkAfter);

            if (!activeLinkBefore.equals(activeLinkAfter)) {
                System.out.println("Click right successful, link changed correctly.");
            } else {
                System.out.println("Click right failed, link did not change.");
            }

        }


    }



    @Step("Verify swipe functionality with mouse drag")
    public void verifySwipeWithMouseDrag(){

        BrowserUtils.waitForPageToLoad(3);

        try {
            gundemPage.iframeAdd.isDisplayed();
            BrowserUtils.waitForClickablility(gundemPage.iframeCloseButton, 2);
            gundemPage.iframeCloseButton.click();


            try {
                gundemPage.oneTrustBanner.isDisplayed();
                BrowserUtils.waitForClickablility(gundemPage.closeOneTrustButton, 2);
                gundemPage.closeOneTrustButton.click();

                List<WebElement> slides = gundemPage.slides;
                Set<Integer> uniqueSlidesIndexes = new HashSet<>();

                for (WebElement slide : slides) {
                    int index = Integer.parseInt(slide.getAttribute("data-swiper-slide-index"));
                    uniqueSlidesIndexes.add(index);
                }

                int totalUniqueSwipes = uniqueSlidesIndexes.size();


                String initialActiveLink = gundemPage.activeSlide.getAttribute("href");
                System.out.println("initialActiveLink = " + initialActiveLink);

                for (int i = 0; i < totalUniqueSwipes; i++) {
                    String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide Before Swipe Left: " + activeLinkBefore);

                    actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(-200, 0).
                            release().perform();

                    BrowserUtils.waitFor(3);


                    String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide After Swipe Left: " + activeLinkAfter);

                    if (!activeLinkBefore.equals(activeLinkAfter)) {
                        System.out.println("Swipe Left successful, link changed correctly.");
                    } else {
                        System.out.println("Swipe Left failed, link did not change.");
                    }
                }

                for (int i = 0; i < totalUniqueSwipes; i++) {

                    String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide Before Swipe Right: " + activeLinkBefore);

                    actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(300, 0).
                            release().perform();

                    BrowserUtils.waitFor(3);


                    String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide After Swipe right: " + activeLinkAfter);

                    if (!activeLinkBefore.equals(activeLinkAfter)) {
                        System.out.println("Swipe right successful, link changed correctly.");
                    } else {
                        System.out.println("Swipe right failed, link did not change.");
                    }

                }

            } catch (Exception e) {

                List<WebElement> slides = gundemPage.slides;
                Set<Integer> uniqueSlidesIndexes = new HashSet<>();

                for (WebElement slide : slides) {
                    int index = Integer.parseInt(slide.getAttribute("data-swiper-slide-index"));
                    uniqueSlidesIndexes.add(index);
                }

                int totalUniqueSwipes = uniqueSlidesIndexes.size();



                for (int i = 0; i < totalUniqueSwipes; i++) {
                    String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide Before Swipe Left: " + activeLinkBefore);

                    actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(-200, 0).
                            release().perform();

                    BrowserUtils.waitFor(1);

                    String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide After Swipe Left: " + activeLinkAfter);

                    if (!activeLinkBefore.equals(activeLinkAfter)) {
                        System.out.println("Swipe Left successful, link changed correctly.");
                    } else {
                        System.out.println("Swipe Left failed, link did not change.");
                    }
                }

                for (int i = totalUniqueSwipes - 1; i >= 0; i--) {

                    String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide Before Swipe Right: " + activeLinkBefore);

                    actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(200, 0).
                            release().perform();

                    BrowserUtils.waitFor(1);


                    String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                    System.out.println("Active Slide After Swipe right: " + activeLinkAfter);

                    if (!activeLinkBefore.equals(activeLinkAfter)) {
                        System.out.println("Swipe right successful, link changed correctly.");
                    } else {
                        System.out.println("Swipe right failed, link did not change.");
                    }

                }

            }
        } catch (Exception e) {

            List<WebElement> slides = gundemPage.slides;
            Set<Integer> uniqueSlidesIndexes = new HashSet<>();

            for (WebElement slide : slides) {
                int index = Integer.parseInt(slide.getAttribute("data-swiper-slide-index"));
                uniqueSlidesIndexes.add(index);
            }

            int totalUniqueSwipes = uniqueSlidesIndexes.size();


            for (int i = 0; i < totalUniqueSwipes; i++) {
                String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                System.out.println("Active Slide Before Swipe Left: " + activeLinkBefore);

                actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(-200, 0).
                        release().perform();

                BrowserUtils.waitFor(1);

                String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                System.out.println("Active Slide After Swipe Left: " + activeLinkAfter);

                if (!activeLinkBefore.equals(activeLinkAfter)) {
                    System.out.println("Swipe Left successful, link changed correctly.");
                } else {
                    System.out.println("Swipe Left failed, link did not change.");
                }
            }

            for (int i = totalUniqueSwipes - 1; i >= 0; i--) {

                String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
                System.out.println("Active Slide Before Swipe Right: " + activeLinkBefore);

                actions.moveToElement(gundemPage.swiperContainer).clickAndHold().moveByOffset(200, 0).
                        release().perform();

                BrowserUtils.waitFor(1);


                String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
                System.out.println("Active Slide After Swipe right: " + activeLinkAfter);

                if (!activeLinkBefore.equals(activeLinkAfter)) {
                    System.out.println("Swipe right successful, link changed correctly.");
                } else {
                    System.out.println("Swipe right failed, link did not change.");
                }

            }

        }


    }


    @Step("Verify swipe functionality with pagination buttons")
    public void verifySwipeWithPaginationButtons(){

        List<WebElement> paginationLinks = gundemPage.swiperPaginition;

        for (WebElement link : paginationLinks) {
            String activeLinkBefore = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide Before  hover over: " + activeLinkBefore);


            actions.moveToElement(link).perform();
            BrowserUtils.waitFor(2);

            String activeLinkAfter = gundemPage.activeSlide.getAttribute("href");
            System.out.println("Active Slide After hover over: " + activeLinkAfter);

            if (!activeLinkBefore.equals(activeLinkAfter)) {
                System.out.println("hover over successful, link changed correctly.");
            } else {
                System.out.println("hover over failed, link did not change.");
            }


        }
    }


}
