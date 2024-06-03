package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(xpath = "//div[@class='swiper-wrapper']/div/a[@title='Gündem']")
    public WebElement gundemButton;





}
