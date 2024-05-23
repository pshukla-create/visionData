package tests;
import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cobotiks extends BaseClass {

    @Test
    public void loginPageTitleVerification()
    {

        Assert.assertEquals(driver.getTitle(),"Web Table Elements");
    }

    @Test
    public void clickOnFirstDropDown()
    {
        driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/ul/li[3]")).click();

    }

    @Test
    public void getValueFromDynamicTable()
    {
        WebElement comapnyName =driver.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th[4]"));
        String value = comapnyName.getText();
        System.out.println("Value of column" +value);

        WebElement valueOfRow = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[4]/td[4]"));
        String valueOfRows = valueOfRow.getText();
        System.out.println("Value of row "+valueOfRows);


    }


}
