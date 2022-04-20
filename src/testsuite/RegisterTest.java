package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
   /* 1.verifyThatSigningUpPageDisplay
			* click on the ‘Register’ link
			* Verify the text ‘Signing up is easy!’*/
   String baseUrl = " https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        // click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        //Verify the text ‘Signing up is easy!’
        String expectedMessage = "Signing up is easy!";
        String actualMessage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
     }
      /*2.userSholdRegisterAccountSuccessfully
			* click on the ‘Register’ link
			* Enter First name
			* Enter Last name
			* Enter Address
			* Enter City
			* Enter State
			* Enter Zip Code
			* Enter Phone
			* Enter SSN
			* Enter Username
			* Enter Password
			* Enter Confirm
			* Click on REGISTER button
			* Verify the text 'Your account was created successfully. You are now logged in.’*/

    @Test
     public void userShouldRegisterAccountSuccessfully(){
       // click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        //Enter First name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        //sending firstname  to firstname field element
        firstName.sendKeys("Jaimin2");

        //Enter Last name
        WebElement  lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Patel");

        //Enter address
        WebElement  address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("4A Apt Second Avenue");

        //Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
       city.sendKeys("Broklyn");

        //Enter state
        WebElement state   = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("New york");

        //Enter ZipCode
        WebElement zipcode   = driver.findElement(By.id("customer.address.zipCode"));
        zipcode.sendKeys("11220");

        //Enter phone
        WebElement phone   = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("73237236683");

        //Enter SSN
        WebElement ssn   = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("123456789");

        //Enter Username
        WebElement userName   = driver.findElement(By.id("customer.username"));
        userName.sendKeys("Jaimin2");

        //Enter password
        WebElement password   = driver.findElement(By.id("customer.password"));
        password.sendKeys("12345@");

        //Enter conpassword
        WebElement conpassword   = driver.findElement(By.id("repeatedPassword"));
        conpassword.sendKeys("12345@");

        //click on registre button
        WebElement regiLink = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        regiLink.click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        //Verify the text ‘Signing up is easy!’
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")).getText();
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
    }

}
