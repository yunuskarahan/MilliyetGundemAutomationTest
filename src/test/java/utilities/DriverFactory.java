package utilities;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

import java.time.Duration;

public class DriverFactory {


    @BeforeSuite
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
    }


    @AfterSuite
    public void closeDriver(){
        Driver.closeDriver();

    }

}
