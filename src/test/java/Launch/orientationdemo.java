package Launch;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class orientationdemo extends BaseTest{

    @Test
    public void MisscellanousActions () {
        // locators in Appium Xapth, id, accessibilityid, classname, androidUIAutomator

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        // device rotation to landscape mode
        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alerttitle, "WiFi settings");

        // copy the text to clipboard
        driver.setClipboardText("Mukesh Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys("Mukesh Wifi");

        driver.findElement(By.id("android:id/button1")).click();

        // keyboard events like home button, back button,
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
