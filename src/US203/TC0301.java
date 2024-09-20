package US203;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


    public class TC0301 extends BaseDriver {
        @Test
        public void Test() {
            driver.get("https://demowebshop.tricentis.com/");
            MyFunc.wait(1);

            WebElement login = driver.findElement(By.cssSelector("[class='header-links']>ul>:nth-child(2)"));
            login.click();
            MyFunc.wait(1);

            WebElement gırısyap = driver.findElement(By.cssSelector("[id='Email']"));
            gırısyap.sendKeys("utkudemir24@gmail.com");
            MyFunc.wait(1);

            WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
            password.sendKeys("1234Demir");
            MyFunc.wait(1);

            WebElement enter = driver.findElement(By.cssSelector("[class='buttons']>input[class='button-1 login-button']"));
            enter.click();
            MyFunc.wait(1);


            WebElement cıkıs = driver.findElement(By.cssSelector("[class='header-links']>ul>:nth-child(2)"));
            cıkıs.click();
            MyFunc.wait(2);


            Assert.assertTrue(driver.getCurrentUrl().equals("Çıkış Yapılamadı [class='header-links']>ul>:nth-child(2)"));

            driver.quit();
        }
    }


