/* @Author: Dmytro.Tyrtyshnyi@gmail.com */
package pages;

import navigationtiming.PerfNavigationTiming;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverHolder;

import static util.WebDriverHolder.*;

public class AbstractPage {
    protected WebDriverWait wait;

    public AbstractPage() {
        wait = new WebDriverWait(getDriver(), 50);
        PageFactory.initElements(getDriver(), this);
    }

    protected PerfNavigationTiming perfNavigationTiming = new PerfNavigationTiming();

    /* Common locators */
    @FindBy(xpath = "//div/a[@href='/computer/']")
    protected WebElement computersTitle;

    protected void waitUntilPageIsFullyLoaded(WebDriverWait webDriverWait) {
        webDriverWait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
