package BasePackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName)
    {
      switch(browserName)
      {
          case "chrome":
              driver = new ChromeDriver();
              break;

          default:
              System.out.println("Please provide browser");
              break;
      }

      driver.get("https://www.tendable.com");
      driver.manage().window().maximize();
    }
    @AfterTest
            public void testDown() {
        driver.quit();
    }



}

