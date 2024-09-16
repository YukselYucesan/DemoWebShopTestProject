package US206;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC0601 extends BaseDriver {
    // WAIT
    public static WebDriverWait wait;

    @Test
    public void allTest() {
        driver.get("https://demowebshop.tricentis.com");

        //all tests
        loginHomePage();
        computersMenu();

        tearDown();
    }

    @Test
    public void loginHomePage() {
        //Login link
        WebElement loginHomePage = driver
                .findElement(By.xpath("//li//a[@href='/login']"));
        MyFunc.isDisplayed(loginHomePage, "Login link");
        MyFunc.isEnabled(loginHomePage, "Login link");
        actions.click(loginHomePage).build().perform();


        //Email placeholder
        WebElement emailPlaceholder = driver
                .findElement(By.xpath("(//div[@class='inputs']/input)[1]"));
        MyFunc.isDisplayed(emailPlaceholder, "Email placeholder");
        MyFunc.isEnabled(emailPlaceholder, "Email placeholder");
        actions.click(emailPlaceholder).sendKeys("techno.team12@gmail.com").build().perform();


        //Password placeholder
        WebElement passwordPlaceholder = driver
                .findElement(By.xpath("(//div[@class='inputs']/input)[2]"));
        MyFunc.isDisplayed(passwordPlaceholder, "Password placeholder");
        MyFunc.isEnabled(passwordPlaceholder, "Password placeholder");
        actions.click(passwordPlaceholder).sendKeys("pass1234").build().perform();
        MyFunc.wait(1);

        //Remember me checkbox
        WebElement rememberMeCheckBox = driver
                .findElement(By.cssSelector("div[class='inputs reversed'] label"));
        MyFunc.isDisplayed(rememberMeCheckBox, "Remember me checkbox");
        MyFunc.isEnabled(rememberMeCheckBox, "Remember me checkbox");
        MyFunc.isSelectedNot(rememberMeCheckBox, "Remember me checkbox");
        actions.click(rememberMeCheckBox).build().perform();
        MyFunc.wait(1);

        //Forgot password link
        WebElement forgotPaswwordLink = driver
                .findElement(By.xpath("//span[@class='forgot-password']/a"));
        MyFunc.isDisplayed(forgotPaswwordLink, "Forgot password link");
        MyFunc.isEnabled(forgotPaswwordLink, "Forgot password link");
        actions.click(forgotPaswwordLink).build().perform();
        MyFunc.wait(2);

        // GO BACK TO LOGIN PAGE
        driver.navigate().back();
        Assert.assertTrue("Page not found!", driver.getCurrentUrl()
                .equals("https://demowebshop.tricentis.com/login"));

        //Login button
        WebElement loginButton = driver
                .findElement(By.cssSelector("div[class='inputs reversed']~div input"));
        MyFunc.isDisplayed(loginButton, "Login button");
        MyFunc.isEnabled(loginButton, "Login button");
        actions.click(loginButton).build().perform();
        Assert.assertNotEquals("Page not found!", driver
                .getCurrentUrl(), "https://demowebshop.tricentis.com/login");
        MyFunc.wait(2);

        //Register text Control
        WebElement textControlEmail = driver.findElement(By.xpath("//a[text()='techno.team12@gmail.com']"));
        MyFunc.isDisplayed(textControlEmail, "Register text");
        MyFunc.isEnabled(textControlEmail, "Register text");
        Assert.assertTrue("Text not found!", textControlEmail.getText().equals("techno.team12@gmail.com"));
        MyFunc.wait(2);


    }

    @Test
    public void computersMenu() {
        // Computers Menu [Desktops,Notebooks,Accessories]
        WebElement computerMenu = driver
                .findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
        MyFunc.isDisplayed(computerMenu, "Computers Menu");
        MyFunc.isEnabled(computerMenu, "Computers Menu");
        actions.clickAndHold(computerMenu).build().perform();
        MyFunc.wait(3);
//        actions.perform();
//        MyFunc.wait(3);

        //Notebooks link
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='sublist firstLevel'] li:nth-child(2) a[href='/notebooks'][class='hover']")));
//        WebElement notebooksLink = driver
//                .findElement(By.cssSelector("ul[class='sublist firstLevel'] li:nth-child(2) a[href='/notebooks'][class='hover']"));
//        MyFunc.isDisplayed(notebooksLink,"Notebooks link");
//        MyFunc.isEnabled(notebooksLink, "Notebooks link");
//        actions.click(notebooksLink).build().perform();



    }


}
