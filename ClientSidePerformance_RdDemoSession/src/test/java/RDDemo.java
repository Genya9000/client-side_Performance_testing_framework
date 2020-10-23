/* @Author: Dmytro.Tyrtyshnyi@gmail.com */
import org.testng.annotations.Test;

import static util.Constants.*;

public class RDDemo extends SetUpScenario {

    @Test(priority = 1)
    public void openMainPage() {
        MAIN_PAGE.openMainPage();
    }

    @Test(priority = 2)
    public void openComputersSection() {
        COMPUTERS_PAGE.openComputersPage();
    }

    @Test(priority = 3)
    public void openLaptopsPage() {
        LAPTOPS_PAGE.openLaptopsPage();
    }

    @Test(priority = 4)
    public void openFirstLaptopInTheList() {
        LAPTOPS_PAGE.openFirstLaptop();
    }
}
