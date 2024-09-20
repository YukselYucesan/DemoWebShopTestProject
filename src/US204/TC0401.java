package US204;

import TestData._01_UserTestData;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC0401 extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://demowebshop.tricentis.com/");
        Assert.assertEquals("The website reached is not the correct website address.","https://demowebshop.tricentis.com/",driver.getCurrentUrl());
        WebElement login = driver.findElement(By.xpath("//a[@href='/login'][text()='Log in']"));
        MyFunc.isDisplayed(login,"Login Button");
        MyFunc.isEnabled(login,"Login Button");
        login.click();
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.isDisplayed(eMail,"E Mail Text Box");
        MyFunc.isEnabled(eMail,"E Mail Text Box");
        eMail.sendKeys(_01_UserTestData.eMail);
        MyFunc.wait(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.isDisplayed(password,"Password Text Box");
        MyFunc.isEnabled(password,"Password Text Box");
        password.sendKeys(_01_UserTestData.password);
        MyFunc.wait(1);

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        MyFunc.isDisplayed(login2,"Login Button");
        MyFunc.isEnabled(login2,"Login Button");
        login2.click();
        MyFunc.wait(1);

        WebElement userName=driver.findElement(By.xpath("//div[@class='header-links']//ul/li/a[@href='/customer/info']"));
        Assert.assertEquals("The user account created is not correct.",userName.getText(),_01_UserTestData.eMail);

        tearDown();
    }
}
