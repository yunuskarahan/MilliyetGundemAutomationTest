package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GundemPage extends BasePage {


    @FindBy(xpath = "//div[@class='cat-slider ']//div[@class='swiper-container swiper-container-horizontal']")
    public WebElement swiperContainer;


    @FindBy(xpath = "//div[@class='cat-slider ']/div[@class='swiper-container swiper-container-horizontal']/div[@class='swiper-wrapper']/div")
    public List<WebElement> slides;

    @FindBy(css = ".swiper-slide:not(.swiper-slide-duplicate) a.cat-slider__link")
    public List<WebElement> allSlides;


    @FindBy(xpath = "//*[contains(@class, 'swiper-slide-active')]/a[@class='cat-slider__link']")
    public WebElement activeSlide;


    @FindBy(xpath = "//div[@class='cat-slider__nav cat-slider__nav--prev']")
    public WebElement leftSliderButton;

    @FindBy(xpath = "//div[@class='cat-slider__nav cat-slider__nav--next']")
    public WebElement rightSliderButton;

    @FindBy(xpath = "//div[@class='swiper-pagination swiper-pagination--category swiper-pagination-bullets']/a")
    public List<WebElement> swiperPaginition;


}
