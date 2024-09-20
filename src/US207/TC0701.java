package US207;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class TC0701 extends BaseDriver {

    @Test

    public void Test01()
    {
        driver.get("https://demowebshop.tricentis.com/");
        Actions actions=new Actions(driver);

        WebElement register= driver.findElement(By.xpath(" //a[@href='/register']"));
        register.click();


        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        actions.click(gender)
                .sendKeys(Keys.TAB)
                .sendKeys("Kadriye")
                .sendKeys(Keys.TAB)
                .sendKeys("Alsancak")
                .sendKeys(Keys.TAB)
                .sendKeys("ahmet52296nl3klnmı1ghbnlk4@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("4521354Ka")
                .sendKeys(Keys.TAB)
                .sendKeys("4521354Ka")
                .perform();

        WebElement registerButton=driver.findElement(By.id("register-button"));
        registerButton.click();
        System.out.println("Your registration completed ");
        //Your registration completed

        WebElement continu=driver.findElement(By.xpath("//input[@value='Continue']"));
        continu.click();



        WebElement polDisplay= driver.findElement(By.id("pollanswers-1"));
        polDisplay.click();

        WebElement vote=driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        vote.click();



        List<WebElement> results = driver.findElements(By.className("poll-results"));
        String[] polResults = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            polResults[i] = results.get(i).getText();
        }

        for (String result : polResults) {
            System.out.println(result);
        }




        tearDown();


    }
}
