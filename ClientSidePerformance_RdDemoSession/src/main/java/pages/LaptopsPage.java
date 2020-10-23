/* @Author: Dmytro.Tyrtyshnyi@gmail.com */
package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class LaptopsPage extends AbstractPage{
    public LaptopsPage() { super(); }

    @FindBy(xpath = "//div[@class='popular-category']/ul//a[@href='/ct/1003/']")
    private WebElement laptopsPageButton;

    @FindBy(xpath = "//section[@class='catalog']//div[@class='catalog-block-head']/a")
    private List<WebElement> laptopProductsList;

    @FindBy(xpath = "//div[@class='breadcrumbs']//h1/span")
    private WebElement openedLaptopTitle;

    @FindBy(xpath = "//div[@class='catalog-head']//a[@class='index main']")
    private WebElement productDescriptionAndPricesButton;

    @FindBy(xpath = "//div[@class='product-img']//img")
    private WebElement productImage;

    public LaptopsPage openLaptopsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopsPageButton));
        laptopsPageButton.click();
        log.info("Clicked on 'laptopsPageButton'");
        wait.until(ExpectedConditions.elementToBeClickable(laptopProductsList.get(0)));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("LaptopsPage");
        log.info("Laptops list is appeared");
        return this;
    }

    public LaptopsPage openFirstLaptop() {
        String firstLaptopInTheListName = laptopProductsList.get(0).getText();
        log.info("Let's grab first laptop: " + firstLaptopInTheListName);
        laptopProductsList.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(productDescriptionAndPricesButton));
        Assert.assertTrue(openedLaptopTitle.getText().contains(firstLaptopInTheListName), "Wrong laptop was opened");
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ProductPage");
        log.info("Asserted that the laptop we wanted to open and actually opened laptop are the same product");
        return this;
    }

}
