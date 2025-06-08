package tutorialsninjaRegister;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
    @Test
	public void VerifyRegisterWithMandatoryFields() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ezhil");
		driver.findElement(By.id("input-lastname")).sendKeys("Arasan");
		driver.findElement(By.id("input-email")).sendKeys(GenerateNewEmail());
		driver.findElement(By.name("telephone")).sendKeys("9655903816");
		driver.findElement(By.id("input-password")).sendKeys("ezhil1234");
		driver.findElement(By.id("input-confirm")).sendKeys("ezhil1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String ExpectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), ExpectedHeading);
		
		String ActuleProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String ActuleProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ActuleProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ActuleProperDetailsFour ="contact us";
		
		String ExpectedProperDetatils= driver.findElement(By.id("content")).getText();

		
		Assert.assertTrue(ExpectedProperDetatils.contains(ActuleProperDetailsOne));
		Assert.assertTrue(ExpectedProperDetatils.contains(ActuleProperDetailsTwo));
		Assert.assertTrue(ExpectedProperDetatils.contains(ActuleProperDetailsThree));
		Assert.assertTrue(ExpectedProperDetatils.contains(ActuleProperDetailsFour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}
	
	public  String GenerateNewEmail() {
	    return new Date().toString().replaceAll(" ","").replaceAll(":", "")+"@gmail.com";
	    
	}
	

}
