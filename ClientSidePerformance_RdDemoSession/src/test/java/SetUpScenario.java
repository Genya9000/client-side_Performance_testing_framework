/* @Author: Dmytro.Tyrtyshnyi@gmail.com */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.ComputersPage;
import pages.LaptopsPage;
import pages.MainPage;
import util.Constants;
import util.WebDriverHolder;

import static util.Constants.*;
import static util.WebDriverHolder.*;

public class SetUpScenario {
    private WebDriver driver;

    @BeforeClass
    protected void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        SCENARIO_NAME = this.getClass().getSimpleName();
        setDriver(BROWSER_FACTORY.startBrowser(BROWSER_NAME, driver));
        getDriver().get(LOGIN_URL);
        deleteJsonFiles();
    }

    @BeforeMethod
    protected void setUp() {
        MAIN_PAGE = new MainPage();
        LAPTOPS_PAGE = new LaptopsPage();
        COMPUTERS_PAGE = new ComputersPage();
    }

    @AfterClass
    protected void teardown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
