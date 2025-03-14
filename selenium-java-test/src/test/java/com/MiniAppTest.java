package com;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniAppTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testMiniAppWorkflow() {
        
        driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/static/index.html");

       
        WebElement status = driver.findElement(By.id("status"));
        assertEquals("Status: Not Started", status.getText());

        WebElement startButton = driver.findElement(By.id("startButton"));
        startButton.click();

        
        WebElement inputField = driver.findElement(By.id("inputField"));
        inputField.sendKeys("Test Input");

        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();

        
        assertEquals("Status: Not Started", status.getText()); 
 
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}