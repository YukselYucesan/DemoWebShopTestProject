package Utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyFunc extends BaseDriver{
    public static void wait(int sn){
        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void isDisplayed(WebElement element, String elementName){
        System.out.println(elementName +" is Displayed : " +element.isDisplayed());
        Assert.assertTrue(elementName+" isn't Displayed ",element.isDisplayed());
    }
    public static void isEnabled(WebElement element,String elementName){
        System.out.println(elementName +" is Enabled : " +element.isEnabled());
        Assert.assertTrue(elementName+" isn't Enabled ",element.isEnabled());
    }
    public static void isSelected(WebElement element,String elementName){
        System.out.println(elementName +" is Selected : " +element.isSelected());
        Assert.assertTrue(elementName+" isn't Selected ",element.isSelected());

    }
    public static void isSelectedNot(WebElement element,String elementName){
        System.out.println(elementName +" is Selected : " +element.isSelected());
        Assert.assertNotEquals(elementName+" isn't Selected ",element.isSelected());

    }
    public static void textIsDisplayed(WebElement element,String expectedText,String elementName){
        System.out.println(elementName +" text : " +element.getText());
        Assert.assertEquals(elementName+" text does not match ",expectedText,element.getText());
    }


}
