package Launch;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class eCommerceTest04_Hybridapp extends BaseTest {
    @Test
    public void fillForm() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestUser");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //clikcing on Add to cart of the first two products
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);

        //long press action on terms and condition button
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        LongPressAction(ele);
        // clicking on the popup close button
        driver.findElement(By.id("android:id/button1")).click();
        // selecting the checkbox
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(5000);
        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contexts);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Mukesh CR");
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }
}

