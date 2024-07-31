package Launch;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appiumlaunch extends BaseTest{

    @Test
    public void WifiSetting () {
        // locators in Appium, Xpath, Accessibility id, clasname, id, AndroidUIAutomator

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML")).click();
        driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id='android:id/checkbox'])[1]")).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alerttitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Mukesh Wifi");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
