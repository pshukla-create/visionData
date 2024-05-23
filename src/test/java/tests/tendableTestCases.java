package tests;
import BasePackage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class tendableTestCases extends BaseClass {

    @Test(priority =1)
    public void verifyLogo()
    {
        WebElement logo = driver.findElement(By.xpath("/html/body/header/div/a/img"));
        //verify logo is present
        if(logo.isDisplayed()) {
            String valueOfLogo = logo.getAttribute("alt");
            System.out.println("Value of Logo " +valueOfLogo);
            Assert.assertTrue(valueOfLogo.contains("Tendable Logo"));
        }
        else {
            System.out.println("Logo is not present");
        }
    }

    @Test(priority =2)
    public void verifyMenusValue()
    {
        //verify our Story accessbility in menu bar
        WebElement ourStoryMenu = driver.findElement(By.xpath("//a[contains(text(),'Our Story')]"));
        Boolean ourStoryAccess = ourStoryMenu.isDisplayed();
        Assert.assertTrue(ourStoryAccess);
        System.out.println("Our Story Menu is present");
        //verify Our Solution accessiblity in menu bar

        WebElement ourSolutionMenu = driver.findElement(By.xpath("//a[contains(text(),'Our Solution')]"));
        Boolean ourSolutionAccess = ourSolutionMenu.isDisplayed();
        Assert.assertTrue(ourSolutionAccess);
        System.out.println("Our Solution Menu is present");

        //verify Why Tendable accessiblity in menu bar

        WebElement whyTendableMenu = driver.findElement(By.xpath("//a[contains(text(),'Why Tendable')]"));
        Boolean whyTendableMenuaccess = whyTendableMenu.isDisplayed();
        Assert.assertTrue(whyTendableMenuaccess);
        System.out.println("Why Tendable Menu is present");


    }

    @Test(priority =3)
    public void verifyRequestDemoButton()
    {
        //verify button on home page
        Boolean requestDemoButton = driver.findElement(By.xpath("//a[contains(text(),'Request A Demo')]")).isEnabled();
        Assert.assertTrue(requestDemoButton);
        System.out.println("Request A Demo button is enabled in home page");

        //button is present and active on each of the aforementioned top-level menu pages.
        driver.findElement(By.xpath("//a[contains(text(),'Our Story')]")).click();
        Boolean demoButtonforourStory = driver.findElement(By.xpath("//a[contains(text(),'Request A Demo')]")).isEnabled();
        Assert.assertTrue(demoButtonforourStory);
        System.out.println("Request A Demo button is active in our story page");

        driver.findElement(By.xpath("//a[contains(text(),'Our Solution')]")).click();
        Boolean demoButtonforourSolution = driver.findElement(By.xpath("//a[contains(text(),'Request A Demo')]")).isEnabled();
        Assert.assertTrue(demoButtonforourSolution);
        System.out.println("Request A Demo button is active in our solution page");

        driver.findElement(By.xpath("//a[contains(text(),'Why Tendable')]")).click();
        Boolean demoButtonforwhyTendable = driver.findElement(By.xpath("//a[contains(text(),'Request A Demo')]")).isEnabled();
        Assert.assertTrue(demoButtonforwhyTendable);
        System.out.println("Request A Demo button is active in why tendable page");

    }

    @Test(priority =4)
    public void verifyMarketingform()
    {
        //click on contact Us button
        driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();

        //navigate to marketing and click on Contact US

        driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/button")).click();

        //fill the form

        driver.findElement(By.xpath("//div[4]/div/div[1]/div/div[1]/form/div[3]/div/input")).sendKeys("Pratishttha Shukla");
        driver.findElement(By.xpath("//*[@id='form-input-organisationName']")).sendKeys("TIAA");
        driver.findElement(By.xpath("//*[@id='form-input-cellPhone']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id='form-input-email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//*[@id='form-input-jobRole']/option[2]")).click();

        //click on I Agree button
        WebElement radioButton = driver.findElement(By.xpath("//*[@id='form-input-consentAgreed-0']"));
        new Actions(driver).moveToElement(radioButton).click().build().perform();

        //submit the form without message

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button' and @data-freeform-action='submit']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,250)");
        //js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='button' and @data-freeform-action='submit']")));
        //myElement.sendKeys(" ");
        System.out.println(myElement.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions a = new Actions(driver);
        a.click(myElement).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



         //verify error message
         js.executeScript("window.scrollTo(0,0)");
         WebElement message = driver.findElement(By.xpath("//*[@id='contactMarketingPipedrive-163701']/div[1]/p"));
         String errorMessage = message.getText();
         System.out.println("Error message: "+errorMessage);
         String actualMessage="Sorry, there was an error submitting the form. Please try again.";
         Assert.assertEquals(errorMessage,actualMessage);
         System.out.println("Assertion passed for error message");


    }

}

