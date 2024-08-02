package Launch;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class directlaunch extends BaseTest{

    @Test
    public void launchfromspecificscreen () {
        // using App package and App activity we can launch the app from the desried screen directly
        // adb shell dumpsys window | grep -E 'mCurrentFocus'  -for MAC
        // adb shell dumpsys window | find 'mCurrentFocus'  -for Windows

        Activity activ = new Activity(" io.appium.android.apis","io.appium.android.apis.preference.DefaultValues");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.DefaultValues" ));
        driver.findElement(By.id("android:id/checkbox")).click();


    }
}
