package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multi_select_dropdown {

    public static void main(String[] args) throws InterruptedException {

        // Setup driver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Open test website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Locate multi-select dropdown
        WebElement dropdown = driver.findElement(By.id("colors"));

        // Create Select object
        Select select = new Select(dropdown);

        // ✅ Check if multi-select
        if (select.isMultiple()) {
            System.out.println("This is a multi-select dropdown");
        }

        // Select options
        select.selectByVisibleText("Red");
        Thread.sleep(2000);

        select.selectByIndex(2); // Blue
        Thread.sleep(2000);

        // Get all selected options
        List<WebElement> allItems = select.getAllSelectedOptions();
        System.out.println("Selected count: " + allItems.size());

        // Deselect all
        select.deselectAll();
        Thread.sleep(2000);

        // Select again
        select.selectByVisibleText("Green");
        Thread.sleep(2000);

        select.selectByIndex(3); // Yellow
        Thread.sleep(2000);

        // Deselect by index
        select.deselectByIndex(3);
        Thread.sleep(2000);

        // Get selected options again
        List<WebElement> allItems1 = select.getAllSelectedOptions();
        System.out.println("Selected count after deselect: " + allItems1.size());

        // Close browser
        driver.quit();
    }
}