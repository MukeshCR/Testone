package Launch;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerceTest03 extends BaseTest{
    @Test
    public void fillForm () throws InterruptedException {
        // filling the login form to enter in to the product page dashboard
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

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//        Thread.sleep(5000);
        // storing the price of the products and iterating through one by one
        List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrice.size();
        double totalSum =0;
        for (int i =0; i<count; i++)
        {
            String amount = productPrice.get(i).getText();
            // $116.05 removing the $ from the string using substring
            Double actualPrice = getFormattedAmount(amount);
            totalSum = totalSum +actualPrice;  // in the 1st iteration this happens 0+169.7 = 167.9
            // in the 2nd iteration this happens 167.9+ 120 = 280.97

        }

        Thread.sleep(5000);

        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double diplayFormatedSum = getFormattedAmount(displaySum);
        Assert.assertEquals(totalSum, diplayFormatedSum);




        

    }
}

