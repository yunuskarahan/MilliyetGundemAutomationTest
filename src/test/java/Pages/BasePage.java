package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class BasePage {





    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//iframe[@id='mobinter']")
    public WebElement iframeAdd;

    @FindBy(xpath = "//button[@class='mobinterkapat']")
    public WebElement iframeCloseButton;


    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']")
    public WebElement oneTrustBanner;

    @FindBy(xpath = "//button[@id='onetrust-reject-all-handler']")
    public WebElement  closeOneTrustButton;



}
