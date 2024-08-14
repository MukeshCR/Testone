package Launch;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerceTest01 extends BaseTest{
    @Test
    public void fillForm () {

        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestUser");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[@text=\'Please enter your name\']")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");


    }
}
