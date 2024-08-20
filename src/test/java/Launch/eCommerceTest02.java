package Launch;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerceTest02 extends BaseTest{
    @Test
    public void fillForm () {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestUser");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // selecting one of the product by scrolling to it and verifiying the product by text and adding it to the cart

        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        //adding product to the cart

        for(int i =0; i< productCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        if (productName.equalsIgnoreCase("Air Jordan 9 Retro"))
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //waiting for the cart page to get displayed to verfiy the product is added in the cart

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        // verifying the added product is same and matched with the product in the cart
        String lastpageproductName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastpageproductName, "Air Jordan 9 Retro");



    }
}

