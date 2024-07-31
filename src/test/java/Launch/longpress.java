package Launch;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class longpress extends BaseTest{

    @Test
    public void longPressGesture () {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement value = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));

        LongPressAction(value);
        String PopupText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(PopupText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
