package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    //userShouldLoginSuccessfullyWithValidCredentials
    //			* Enter valid username
    //			* Enter valid password
    //			* Click on ‘LOGIN’ button
    //			* Verify the ‘Accounts Overview’ text is display
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Jaimin2");

        // Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12345@");

        // Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";
        String actualMessage = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
    }
    /*verifyTheErrorMessage
			* Enter invalid username
			* Enter invalid password
			* Click on Login button
			* Verify the error message ‘The username and password could not be verified.’*/
    @Test
    public void verifyTheErrorMessage(){
        // Enter invalid username
        WebElement invuserName = driver.findElement(By.xpath("//input[@name='username']"));
        invuserName.sendKeys("Ja562");

        //Enter invalid password
        WebElement invpassword = driver.findElement(By.xpath("//input[@name='password']"));
       invpassword.sendKeys("1345]#@");

        // Click on Login button
       WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

        // Verify the error message ‘The username and password could not be verified.’
        String expectedMessage = "The username and password could not be verified.";
        String actualMessage = driver.findElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]")).getText();
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);

    }
    //.userShouldLogOutSuccessfully
    //			* Enter valid username
    //			* Enter valid password
    //			* Click on ‘LOGIN’ button
    //			* Click on ‘Log Out’ link
    //			* Verify the text ‘Customer Login’
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Jaimin2");

        // Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12345@");

        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

       //Click on ‘Log Out’ link
        WebElement logout= driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']"));
        logout.click();

      // Verify the text ‘Customer Login’
        String expectedMessage = "Customer Login";
        String actualMessage = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);

    }
}
