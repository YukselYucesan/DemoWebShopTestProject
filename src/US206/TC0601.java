package US206;

import TestData._02_UserTestData;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC0601 extends BaseDriver {
    // WAIT
    public static WebDriverWait wait;
    //SELECT
    public static Select dropDown;

    @Test
    public void allTest() {
        driver.get("https://demowebshop.tricentis.com");
        wait =new WebDriverWait(driver,Duration.ofSeconds(20));

        //all tests
        loginHomePage();
        computersMenu();
        shoppingCartLink();
        billingAddress();
        shippingAddress();
        shippingMethod();
        paymentMethod();
        paymentInformation();
        confirmOrder();

        //Wait and Close
        tearDown();
    }

    @Test
    public void loginHomePage() {
        //Login link
        WebElement loginHomePage = driver.findElement(By.xpath("//li//a[@href='/login']"));
        MyFunc.isDisplayed(loginHomePage, "Login link");
        MyFunc.isEnabled(loginHomePage, "Login link");
        actions.click(loginHomePage).build().perform();

        //Email placeholder
        WebElement emailPlaceholder = driver.findElement(By.xpath("(//div[@class='inputs']/input)[1]"));
        MyFunc.isDisplayed(emailPlaceholder, "Email placeholder");
        MyFunc.isEnabled(emailPlaceholder, "Email placeholder");
        emailPlaceholder.clear();
        actions.click(emailPlaceholder).sendKeys(_02_UserTestData.eMail).build().perform();

        //Password placeholder
        WebElement passwordPlaceholder = driver.findElement(By.xpath("(//div[@class='inputs']/input)[2]"));
        MyFunc.isDisplayed(passwordPlaceholder, "Password placeholder");
        MyFunc.isEnabled(passwordPlaceholder, "Password placeholder");
        passwordPlaceholder.clear();
        actions.click(passwordPlaceholder).sendKeys(_02_UserTestData.password).build().perform();

        //Remember me checkbox
        WebElement rememberMeCheckBox = driver.findElement(By.cssSelector("div[class='inputs reversed'] label"));
        MyFunc.isDisplayed(rememberMeCheckBox, "Remember me checkbox");
        MyFunc.isEnabled(rememberMeCheckBox, "Remember me checkbox");
        MyFunc.isSelectedNot(rememberMeCheckBox, "Remember me checkbox");
        actions.click(rememberMeCheckBox).build().perform();


        //Forgot password link
        WebElement forgotPaswwordLink = driver.findElement(By.xpath("//span[@class='forgot-password']/a"));
        MyFunc.isDisplayed(forgotPaswwordLink, "Forgot password link");
        MyFunc.isEnabled(forgotPaswwordLink, "Forgot password link");
        actions.click(forgotPaswwordLink).build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/passwordrecovery"));//URL WAIT


        // GO BACK TO LOGIN PAGE
        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));//URL WAIT
        Assert.assertTrue("Page not found!", driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"));


        //Login button
        WebElement loginButton = driver.findElement(By.cssSelector("div[class='inputs reversed']~div input"));
        MyFunc.isDisplayed(loginButton, "Login button");
        MyFunc.isEnabled(loginButton, "Login button");
        actions.click(loginButton).build().perform();
        wait.until(ExpectedConditions
                .textToBe(By.xpath("//div[@class='header-links']//ul/li/a[@class='account']"),"techno.team12@gmail.com"));
        Assert.assertNotEquals("Page not found!", driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login");
        MyFunc.wait(1);


        //Register text Control
        WebElement textControlEmail = driver.findElement(By.xpath("//a[text()='techno.team12@gmail.com']"));
        MyFunc.isDisplayed(textControlEmail, "Register text");
        MyFunc.isEnabled(textControlEmail, "Register text");
        Assert.assertTrue("Text not found!", textControlEmail.getText().equals("techno.team12@gmail.com"));
        MyFunc.wait(1);
    }

    @Test
    public void computersMenu() {
        // Computers Menu [Desktops,Notebooks,Accessories]
        WebElement computerMenu = driver
                .findElement(By.xpath("(//ul[@class='top-menu']//li[2]/a)[1]"));
        MyFunc.isDisplayed(computerMenu, "Computers Menu");
        MyFunc.isEnabled(computerMenu, "Computers Menu");
        actions.clickAndHold(computerMenu).build().perform();
        MyFunc.wait(1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='top-menu']//li[2]/ul/li[2]/a")));
        //Notebooks link
        WebElement notebooksLink = driver
                .findElement(By.xpath("//ul[@class='top-menu']//li[2]/ul/li[2]/a"));
        MyFunc.isDisplayed(notebooksLink, "Notebooks link");
        MyFunc.isEnabled(notebooksLink, "Notebooks link");
        actions.click(notebooksLink).build().perform();
        MyFunc.wait(1);

        //Product 14.1-inch Laptop displayed
        WebElement productLaptop = driver.findElement(By.xpath("//h2[@class='product-title']/a"));
        MyFunc.isDisplayed(productLaptop, "Notebooks link");
        MyFunc.isEnabled(productLaptop, "Notebooks link");
        actions.click(productLaptop).build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/141-inch-laptop"));//URL WAIT

        //Products specifications
        WebElement screenSize = driver.findElement(By.cssSelector("tr[class='odd'] td:nth-child(2)"));
        MyFunc.isDisplayed(screenSize, "ScreenSize");
        MyFunc.isEnabled(screenSize, "ScreenSize");
        MyFunc.textIsDisplayed(screenSize, screenSize.getText(), "14.1''");
        WebElement cpuType = driver.findElement(By.cssSelector("tr[class='even'] td:nth-child(2)"));
        MyFunc.isDisplayed(cpuType, "CPU Type");
        MyFunc.isEnabled(cpuType, "CPU Type");
        MyFunc.textIsDisplayed(cpuType, cpuType.getText(), "Intel");
        WebElement memory = driver.findElement(By.cssSelector("tbody tr[class='odd']~tr[class='odd'] :nth-child(2)"));
        MyFunc.isDisplayed(memory, "Memory");
        MyFunc.isEnabled(memory, "Memory");
        MyFunc.textIsDisplayed(memory, memory.getText(), "3 GB");
        WebElement hardrive = driver.findElement(By.cssSelector("tr[class='even']~tr[class='even'] :nth-child(2)"));
        MyFunc.isDisplayed(hardrive, "Hardrive");
        MyFunc.isEnabled(hardrive, "Hardrive");
        MyFunc.textIsDisplayed(hardrive, hardrive.getText(), "250 GB");

        //Delete product from cart
        WebElement goShoppingLink = driver.findElement(By.xpath("//*[@id='topcartlink']/a"));
        actions.click(goShoppingLink).build().perform();


        List<WebElement> selectCheckBox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
        if (!selectCheckBox.isEmpty()) {
            wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            actions.click(selectCheckBox.get(0)).build().perform();

            WebElement deletedProduct = driver.findElement(By.xpath("//input[@name='updatecart']"));
            actions.click(deletedProduct).build().perform();
            //Back product page
            driver.navigate().back();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-button-31']")));

        } else {
            System.out.println("Sepette silinecek ürün yok.");
            //Back product page
            driver.navigate().back();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-button-31']")));
        }


        //Add to Cart
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']"));
        MyFunc.isDisplayed(addToCart, "Add to Cart");
        MyFunc.isEnabled(addToCart, "Add to Cart");
        actions.click(addToCart).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='bar-notification'] p")));
        //Message (The product has been added to your shopping cart)
        WebElement addCartMessage = driver.findElement(By.cssSelector("div[id='bar-notification'] p"));
        MyFunc.isDisplayed(addCartMessage, "Message");
        MyFunc.isEnabled(addCartMessage, "Message");
        MyFunc.textIsDisplayed(addCartMessage, addCartMessage.getText(), "The product has been added to your shopping cart");

        //Shopping Cart quantity
        WebElement shoppingCartQuantity = driver.findElement(By.xpath("//li[@id='topcartlink']//span[2]"));
        MyFunc.isDisplayed(shoppingCartQuantity, "Shopping Cart quantity");
        MyFunc.isEnabled(shoppingCartQuantity, "Shopping Cart quantity");
        MyFunc.textIsDisplayed(shoppingCartQuantity, shoppingCartQuantity.getText(), "(1)");
    }

    @Test
    public void shoppingCartLink() {
        // Shopping Cart link hoverover
        WebElement shoppingLink = driver.findElement(By.xpath("//li[@id='topcartlink']//span[1]"));
        actions.moveToElement(shoppingLink).build().perform();
        WebElement productName = driver.findElement(By.xpath("//div[@class='product']//a")); //   14.1-inch Laptop
        MyFunc.textIsDisplayed(productName, productName.getText(), "14.1-inch Laptop");
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='product']//a"),"14.1-inch Laptop"));

        // Shopping Cart link click
        WebElement shoppingCartLink = driver.findElement(By.xpath("//li[@id='topcartlink']//span[1]"));
        MyFunc.isDisplayed(shoppingCartLink, "Shopping Cart quantity");
        MyFunc.isEnabled(shoppingCartLink, "Shopping Cart quantity");
        MyFunc.textIsDisplayed(shoppingCartLink, shoppingCartLink.getText(), "Shopping cart");
        actions.click(shoppingCartLink).build().perform();

        //Country Select
        WebElement countrySelect = driver.findElement(By.xpath("(//div[@class='inputs']//select)[1]"));
        dropDown = new Select(countrySelect);
        MyFunc.wait(1);
        dropDown.selectByValue("8");

        //State / province Select
        WebElement stateSelect = driver.findElement(By.xpath("//div[@class='inputs']//select[@id='StateProvinceId']"));
        dropDown = new Select(stateSelect);
        MyFunc.wait(1);
        dropDown.selectByValue("0");

        //Zip / postal code Placeholder
        WebElement zipPcode = driver.findElement(By.xpath("(//div[@class='inputs']//input)[1]"));
        MyFunc.isDisplayed(zipPcode, "Zip / postal code Placeholder");
        MyFunc.isEnabled(zipPcode, "Zip / postal code Placeholder");
        zipPcode.clear();
        actions.click(zipPcode).sendKeys(_02_UserTestData.zipCode).build().perform();

        //"Estimate shipping" button
        WebElement estimateShippingButton = driver.findElement(By.cssSelector("div[class='inputs'] input[name='estimateshipping']"));
        MyFunc.isDisplayed(estimateShippingButton, "Estimate shipping");
        MyFunc.isEnabled(estimateShippingButton, "Estimate shipping");
        actions.click(estimateShippingButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class*='shipping']>strong[class*='option-name']:nth-child(1)")));
        //Text Control [Ground (0.00)]
        WebElement groundText = driver.findElement(By.cssSelector("li[class*='shipping']>strong[class*='option-name']:nth-child(1)"));
        MyFunc.isDisplayed(groundText, "Text Control [Ground (0.00)]");
        MyFunc.isEnabled(groundText, "Text Control [Ground (0.00)]");
        MyFunc.textIsDisplayed(groundText, groundText.getText(), "Ground (0.00)");


        //If the Terms and Conditions Checkbox is not selected
        WebElement termsSelectedIsNot = driver.findElement(By.xpath("//div[@class='terms-of-service']/input"));
        MyFunc.isDisplayed(termsSelectedIsNot, "Terms and Conditions Checkbox");
        MyFunc.isEnabled(termsSelectedIsNot, "Terms and Conditions Checkbox");
        MyFunc.isSelectedNot(termsSelectedIsNot, "Terms and Conditions Checkbox");
        MyFunc.wait(1);

        //Checkout button
        WebElement checkoutButton = driver.findElement(By.xpath("//div[@class='checkout-buttons']//button"));
        MyFunc.isDisplayed(checkoutButton, "Terms and Conditions Checkbox");
        MyFunc.isEnabled(checkoutButton, "Terms and Conditions Checkbox");
        actions.click(checkoutButton).build().perform();
        MyFunc.wait(1);

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Please accept the terms of service before the next step.']"),
                                                                "Please accept the terms of service before the next step."));
        //Message screen if Terms and Conditions Checkbox is not selected
        WebElement messageScreen = driver
                .findElement(By.xpath("//*[text()='Please accept the terms of service before the next step.']"));
        MyFunc.isDisplayed(messageScreen, "Message screen Terms");
        MyFunc.isEnabled(messageScreen, "Message screen Terms");
        MyFunc.textIsDisplayed(messageScreen, messageScreen.getText(), "Please accept the terms of service before the next step.");
        MyFunc.wait(1);

        //Message screen close
        WebElement messageScreenClose = driver.findElement(By.xpath("//*[text()='close']/../span[1]"));
        MyFunc.isDisplayed(messageScreenClose, "Message screen close");
        MyFunc.isEnabled(messageScreenClose, "Message screen close");
        actions.click(messageScreenClose).build().perform();
        MyFunc.wait(1);

        //Terms and Conditions Checkbox is selected
        WebElement termsIsSelected = driver.findElement(By.xpath("//div[@class='terms-of-service']/input"));
        actions.click(termsIsSelected).build().perform();
        MyFunc.wait(1);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkout-buttons']//button")));
        //Checkout button
        WebElement checkoutButtonnt = driver.findElement(By.xpath("//div[@class='checkout-buttons']//button"));
        MyFunc.isDisplayed(checkoutButtonnt, "Terms and Conditions Checkbox");
        MyFunc.isEnabled(checkoutButtonnt, "Terms and Conditions Checkbox");
        actions.click(checkoutButtonnt).build().perform();
        MyFunc.wait(1);
    }

    public void billingAddress() {
        //Billing address select
        WebElement billingAddress = driver.findElement(By.xpath("//div/select[@id='billing-address-select']"));
        dropDown = new Select(billingAddress);
        MyFunc.wait(1);
        dropDown.selectByVisibleText("New Address");

        //First name palceholder
        WebElement firstName = driver.findElement(By.xpath("//*[@id='BillingNewAddress_FirstName']"));
        MyFunc.isDisplayed(firstName, "First name palceholder");
        MyFunc.isEnabled(firstName, "First name palceholder");
        firstName.clear();
        actions.click(firstName).sendKeys(_02_UserTestData.firstName).build().perform();

        //Last name palceholder
        WebElement lastName = driver.findElement(By.xpath("//*[@id='BillingNewAddress_LastName']"));
        MyFunc.isDisplayed(lastName, "Last name palceholder");
        MyFunc.isEnabled(lastName, "Last name palceholder");
        lastName.clear();
        actions.click(lastName).sendKeys(_02_UserTestData.lastName).build().perform();

        //Email palceholder
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Email']"));
        MyFunc.isDisplayed(emailBox, "Email palceholder");
        MyFunc.isEnabled(emailBox, "Email palceholder");
        emailBox.clear();
        actions.click(emailBox).sendKeys(_02_UserTestData.eMail).build().perform();

        //Company name palceholder
        WebElement companyBox = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Company']"));
        MyFunc.isDisplayed(companyBox, "Company palceholder");
        MyFunc.isEnabled(companyBox, "Company palceholder");
        companyBox.clear();
        actions.click(companyBox).sendKeys(_02_UserTestData.company).build().perform();

        //Country  select
        WebElement countrySelect = driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']"));
        dropDown = new Select(countrySelect);
        MyFunc.wait(1);
        dropDown.selectByValue("8");

        //State / province  select
        WebElement stateSelect = driver.findElement(By.xpath("//*[@id='BillingNewAddress_StateProvinceId']"));
        dropDown = new Select(stateSelect);
        MyFunc.wait(1);
        dropDown.selectByValue("0");

        //City Placeholder
        WebElement cityBox = driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']"));
        MyFunc.isDisplayed(cityBox, "City palceholder");
        MyFunc.isEnabled(cityBox, "City palceholder");
        cityBox.clear();
        actions.click(cityBox).sendKeys(_02_UserTestData.city).build().perform();

        //Address 1 Placeholder
        WebElement address1Box = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']"));
        MyFunc.isDisplayed(address1Box, "Address 1 palceholder");
        MyFunc.isEnabled(address1Box, "Address 1 palceholder");
        address1Box.clear();
        actions.click(address1Box).sendKeys(_02_UserTestData.address1).build().perform();

        //Address 2 Placeholder
        WebElement address2Box = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address2']"));
        MyFunc.isDisplayed(address2Box, "Address 2 palceholder");
        MyFunc.isEnabled(address2Box, "Address 2 palceholder");
        address2Box.clear();
        actions.click(address2Box).sendKeys(_02_UserTestData.address1).build().perform();

        //Zip / postal code Placeholder
        WebElement zipCodeBox = driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']"));
        MyFunc.isDisplayed(zipCodeBox, "Zip / postal code palceholder");
        MyFunc.isEnabled(zipCodeBox, "Zip / postal code palceholder");
        zipCodeBox.clear();
        actions.click(zipCodeBox).sendKeys(_02_UserTestData.zipCode).build().perform();

        //Phone number Placeholder
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']"));
        MyFunc.isDisplayed(phoneNumber, "Phone number palceholder");
        MyFunc.isEnabled(phoneNumber, "Phone number palceholder");
        phoneNumber.clear();
        actions.click(phoneNumber).sendKeys(_02_UserTestData.phoneNumber).build().perform();

        //Fax number Placeholder
        WebElement faxNumber = driver.findElement(By.xpath("//*[@id='BillingNewAddress_FaxNumber']"));
        MyFunc.isDisplayed(faxNumber, "Fax number palceholder");
        MyFunc.isEnabled(faxNumber, "Fax number palceholder");
        faxNumber.clear();
        actions.click(faxNumber).sendKeys(_02_UserTestData.faxNumber).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id,'billing-buttons')]/input[@title='Continue']")));
        //Contiune Button
        WebElement contiuneButton = driver
                .findElement(By.xpath("//div[starts-with(@id,'billing-buttons')]/input[@title='Continue']"));
        MyFunc.isDisplayed(contiuneButton, "Contiune Button");
        MyFunc.isEnabled(contiuneButton, "Contiune Button");
        actions.click(contiuneButton).build().perform();
    }

    public void shippingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PickUpInStore']")));
        // In-Store Pickup Check Box
        WebElement inStorePickup = driver.findElement(By.xpath("//*[@id='PickUpInStore']"));
        MyFunc.isDisplayed(inStorePickup, "In-Store Pickup Check Box");
        MyFunc.isSelectedNot(inStorePickup, "In-Store Pickup Check Box");
        actions.click(inStorePickup).build().perform();

        //Text Control (Select a shipping address from your address book or enter a new address.)
        WebElement textControl = driver.findElement(By.xpath("//*[@id='shipping-addresses-form']/div[1]/label"));
        Assert.assertNotEquals("Text Found!", textControl.getText()
                , "Select a shipping address from your address book or enter a new address.");
        //Selected not
        actions.click(inStorePickup).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shipping-buttons-container']/input")));
        //Contiune Button
        WebElement contiuneButtonNext = driver.findElement(By.xpath("//*[@id='shipping-buttons-container']/input"));
        MyFunc.isDisplayed(contiuneButtonNext, "Contiune Button");
        MyFunc.isEnabled(contiuneButtonNext, "Contiune Button");
        actions.click(contiuneButtonNext).build().perform();
    }

    public void shippingMethod() {
        //Shipping method select
        WebElement shippingMethod = driver.findElement(By.xpath("//*[@id='shippingoption_0']"));
        MyFunc.isDisplayed(shippingMethod, "Shipping method select");
        MyFunc.isEnabled(shippingMethod, "Shipping method select");
        MyFunc.isSelectedNot(shippingMethod, "Shipping method select");
        actions.click(shippingMethod).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shipping-method-buttons-container']/input")));
        //Contiune Button
        WebElement contiuneButtonNext = driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/input"));
        MyFunc.isDisplayed(contiuneButtonNext, "Contiune Button");
        MyFunc.isEnabled(contiuneButtonNext, "Contiune Button");
        actions.click(contiuneButtonNext).build().perform();

    }

    public void paymentMethod() {
        //Payment method select
        WebElement paymentMethod = driver.findElement(By.xpath("//*[@id='paymentmethod_0']"));
        MyFunc.isDisplayed(paymentMethod, "Payment method select");
        MyFunc.isEnabled(paymentMethod, "Payment method select");
        MyFunc.isSelectedNot(paymentMethod, "Payment method select");
        actions.click(paymentMethod).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payment-method-buttons-container']/input")));
        //Contiune Button
        WebElement contiuneButtonNext = driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/input"));
        MyFunc.isDisplayed(contiuneButtonNext, "Contiune Button");
        MyFunc.isEnabled(contiuneButtonNext, "Contiune Button");
        actions.click(contiuneButtonNext).build().perform();
    }

    public void paymentInformation() {
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[text()='You will pay by COD']"),"You will pay by COD"));
        //Text Control
        WebElement textControl = driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
        Assert.assertEquals("Text not Found!!", textControl.getText(), "You will pay by COD");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payment-info-buttons-container']/input")));
        //Contiune Button
        WebElement contiuneButtonNext = driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/input"));
        MyFunc.isDisplayed(contiuneButtonNext, "Contiune Button");
        MyFunc.isEnabled(contiuneButtonNext, "Contiune Button");
        actions.click(contiuneButtonNext).build().perform();
    }

    public void confirmOrder() {
        //Products Control
        WebElement productControl = driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]"));
        Assert.assertEquals("Product not Found!!", productControl.getText(), "14.1-inch Laptop");

        //Confirm Button
        WebElement confirmButton = driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/input"));
        MyFunc.isDisplayed(confirmButton, "Confirm Button");
        MyFunc.isEnabled(confirmButton, "Confirm Button");
        actions.click(confirmButton).build().perform();

        //"Thank you" text control
        WebElement thankYouText = driver.findElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Text not Found!!", thankYouText.getText(), "Thank you");

        //"Your order has been successfully processed!" text control
        WebElement successTextControl = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertEquals("Product not Found!!", successTextControl.getText(), "Your order has been successfully processed!");

        //Order Number Text Control
        WebElement orderNumber = driver.findElement(By.xpath("(//ul[@class='details']/li)[1]"));
        String confrimOrderNum = orderNumber.getText().replaceAll("[^0-9]", "");

        //"Click here for order details." Link Control
        WebElement detailsLink = driver.findElement(By.xpath("(//ul[@class='details']/li)[2]/a"));
        Assert.assertEquals("Product not Found!!", detailsLink.getText(), "Click here for order details.");
        actions.click(detailsLink).build().perform();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='page-title']/h1"),"Order information"));

        WebElement detailsOrderNum = driver.findElement(By.xpath("//div[@class='order-number']/strong"));
        String orderNum = detailsOrderNum.getText().replaceAll("[^0-9]", "");
        driver.navigate().back();
        MyFunc.wait(1);
        Assert.assertEquals("Order Number not Equals", confrimOrderNum, orderNum);

        //Contiune Button
        WebElement contiuneButton = driver.findElement(By.xpath("//div[@class='buttons']/input"));
        MyFunc.isDisplayed(contiuneButton, "Contiune Button");
        MyFunc.isEnabled(contiuneButton, "Contiune Button");
        actions.click(contiuneButton).build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
        Assert.assertEquals("URL not Found", driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
    }
}
