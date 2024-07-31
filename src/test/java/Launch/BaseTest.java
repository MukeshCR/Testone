package Launch;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

@BeforeClass
    public void ConfigureAppium () throws MalformedURLException {

    service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//CR Mukesh//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
    service.start();

    Boolean value =service.isRunning();
    System.out.println("Appium server is started and Running" + value);

    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName("google");
    options.setApp("C://Users//CR Mukesh//IdeaProjects//Appium//src//main//resources//ApiDemos-debug.apk");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void LongPressAction(WebElement value) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) value).getId(), "duration", 2000));
    }

    @AfterClass
    public void TearDown() {
    driver.quit();
    service.stop();
    System.out.println("Appium server has stopped now");

    }
}
