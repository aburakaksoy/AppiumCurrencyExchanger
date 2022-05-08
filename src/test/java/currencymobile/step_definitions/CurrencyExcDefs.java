package currencymobile.step_definitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CurrencyExcDefs {
        AppiumDriver<MobileElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //we use android phone
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //choose android version
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        //name of the device, if it is real device we need to pass "UUID" parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        //set the automation name
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //we need to specify appPackage(Package name of the application) and appActivity(Class name of the application)

        //Set application package name
        desiredCapabilities.setCapability("appPackage", "com.currencyconverter.egalang");

        //Set application's MainActivity activity name
        desiredCapabilities.setCapability("appActivity", "com.paysera.currencyconverter.activities.MainActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);


    }

    @After
    public void tearDown(){

      //  driver.closeApp();


    }



    @Given("the User enters {string} as amount")
    public void theUserEntersAsAmount(String amount) {
        MobileElement sellingAmountBox =  driver.findElement(MobileBy.id("com.currencyconverter.egalang:id/sourceEditText"));
        sellingAmountBox.sendKeys(amount);

    }


    @And("the user picks the {string} currency as selling type")
    public void theUserPicksTheCurrencyAsSellingType(String currencyType) {

    MobileElement listofSellingCurrencies = driver.findElementById("com.currencyconverter.egalang:id/sourceTextView");
    listofSellingCurrencies.click();

        MobileElement chooseReceiveCurrency = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                                +"new UiSelector().text(\""+currencyType+"\"));"));
        chooseReceiveCurrency.click();

    }




    @And("the User picks the {string} currency as receiving type")
    public void theUserPicksTheCurrencyAsReceivingType(String currencyType) {
        MobileElement listofReceiveCurrencies = driver.findElement(MobileBy.id("com.currencyconverter.egalang:id/destinationTextView"));

        listofReceiveCurrencies.click();


        MobileElement chooseReceiveCurrency = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                                +"new UiSelector().text(\""+currencyType+"\"));"));
        chooseReceiveCurrency.click();


    }

    @When("the User clicks Submit Button")
    public void the_User_clicks_Submit_Button() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement submitButton = driver.findElementByXPath("//*[@text='SUBMIT']");
        submitButton.click();

    }

    @And("the User Clicks ok when an alert seen")
    public void theUserClicksOkWhenAnAlertSeen() throws InterruptedException {

        MobileElement okButton = driver.findElementById("android:id/button1");

        okButton.click();
    }

    @And("the Euro balance reduced to {string}")
    public void theEuroBalanceReducedToEuro(String expectedBalance) {
    List<MobileElement> balances = driver.findElementsById("com.currencyconverter.egalang:id/itemBalancesTextView");
    String actualBalance="";

    for(MobileElement element : balances){
        if(element.getText().contains("EUR")){
            actualBalance=element.getText();
        }
    }

        Assert.assertEquals("Verify the balance!!",expectedBalance,actualBalance);

    }




    @And("the User should be able to see insufficient funds error shown")
    public void theUserShouldBeAbleToSeeInsufficentFundsErrorShown() throws InterruptedException {

        MobileElement errorMessageElement = driver.findElementById("android:id/message");
        String errorMessage = errorMessageElement.getText();
        Assert.assertEquals("verify the error message","Insufficient funds",errorMessage);
        MobileElement okButton = driver.findElementById("android:id/button1");

        okButton.click();

    }


    @And("the {string} balance reduced to {string}")
    public void theBalanceReducedTo(String currencyType, String amount) {
        List<MobileElement> balances = driver.findElementsById("com.currencyconverter.egalang:id/itemBalancesTextView");
        String actualBalance="";
        String expectedBalance=amount+" "+currencyType;

        for(MobileElement element : balances){
            if(element.getText().contains("EUR")){
                actualBalance=element.getText();
            }
        }

        Assert.assertEquals("Verify the balance!!",expectedBalance,actualBalance);

    }

    @Then("the {string} balance should be {string}")
    public void theBalanceShouldBe(String currencyType, String amount) {List<MobileElement> balances = driver.findElementsById("com.currencyconverter.egalang:id/itemBalancesTextView");
        String actualBalance=" ";
        String expectedBalance=amount+" "+currencyType;

        for(MobileElement element : balances){
            if(element.getText().contains(currencyType)){
                actualBalance=element.getText();
            }
        }

        Assert.assertEquals("",expectedBalance,actualBalance);
    }



    @Then("the Currency Balance isn't affected and not below the zero")
    public void theCurrencyBalanceIsnTAffected() throws InterruptedException {
        List<MobileElement> balances = driver.findElementsById("com.currencyconverter.egalang:id/itemBalancesTextView");


        for(MobileElement element : balances){
            if(element.getText().contains("-")){
                Assert.assertFalse("Curreny Balance is Affected!!! and Its below the zero !!!",true);
            }
        }

        Thread.sleep(2000);
    }



    @Then("the commission fee should be displayed in the message")
    public void theCommissionFeeShouldBeDisplayedInTheMessage() {
        MobileElement okButton = driver.findElementById("android:id/button1");

        okButton.click();

    }
}