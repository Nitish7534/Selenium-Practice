package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectdropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.manage().window().maximize();

        // ✅ Correct dropdown element
        WebElement dropdown = driver.findElement(By.id("input_1_8"));

        // ✅ Use Select class
        Select select = new Select(dropdown);

        // Select by Value
        select.selectByValue("level3");   // 51–100 employees
        Thread.sleep(2000);

        // Select by Visible Text
        select.selectByVisibleText("101 - 250 employees");
        Thread.sleep(2000);

        // Select by Index
        select.selectByIndex(5);
        Thread.sleep(2000);

        driver.quit();
    }
}