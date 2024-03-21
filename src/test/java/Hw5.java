import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class Hw5 {
    @AndroidFindBy(id = "btnJoinConf")
    private MobileElement btnJoinConf;
    @AndroidFindBy(id = "txtTitle")
    private MobileElement txtTitle;
    @AndroidFindBy(id = "btnBack")
    private MobileElement btnBack;
    @AndroidFindBy(id = "edtConfNumber")
    private MobileElement edtConfNumber;
    @AndroidFindBy(id = "btnGotoVanityUrl")
    private MobileElement btnGotoVanityUrl;
    @AndroidFindBy(id = "edtScreenName")
    private MobileElement edtScreenName;

    private final DriverFactory driverFactory = new DriverFactory();
    private AndroidDriver<?> driver;

    @BeforeEach
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Test
    public void homeworkTest() throws InterruptedException {
        btnJoinConf.click();
        txtTitle.isDisplayed();
        edtConfNumber.isDisplayed();
        btnGotoVanityUrl.isDisplayed();
        edtScreenName.isDisplayed();

        Thread.sleep(2000);

        MobileElement joinButton = (MobileElement) driver.findElementById("btnJoinConf");
        MobileElement linkText = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"tap on the link to join the meeting\")");
        MobileElement optionsTitle = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"JOIN OPTIONS\")");
        MobileElement optionNoAudio = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"Don't Connect To Audio\")");
        MobileElement chkNoAudio = (MobileElement) driver.findElementById("chkNoAudio");

        joinButton.isDisplayed();
        linkText.isDisplayed();
        optionsTitle.isDisplayed();
        optionNoAudio.isDisplayed();
        chkNoAudio.isDisplayed();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}