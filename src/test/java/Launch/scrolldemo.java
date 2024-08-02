package Launch;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class scrolldemo extends BaseTest{

    @Test
    public void scrollPageTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        ScrollTillElement();

    }
}
