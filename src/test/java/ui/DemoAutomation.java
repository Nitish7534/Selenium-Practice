package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {

    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        // FirefoxDriver driver = new FirefoxDriver();

        // EdgeDriver driver = new EdgeDriver();
        driver.get("http://www.ebay.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile", Keys.ENTER);

        driver.close();
        // driver.quit();
    }
}