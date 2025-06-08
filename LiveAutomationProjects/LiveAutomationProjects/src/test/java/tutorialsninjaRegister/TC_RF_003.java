package tutorialsninjaRegister;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
    @Test
	public void VerifyregisterAccountWithAllFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ezhil");
		driver.findElement(By.id("input-lastname")).sendKeys("B");
		driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8969696968");
		driver.findElement(By.id("input-password")).sendKeys("Ezhil1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Ezhil1234");
		driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String ExepetedProperDeatailsOne ="Your Account Has Been Created!";
		String ExepetedProperDeatailsTwo="Congratulations! Your new account has been successfully created!";
		String ExepetedProperDeatailsThree="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ExepetedProperDeatailsFour ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ExepetedProperDeatailsFive ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String ExepetedProperDeatailsSix="contact us";
		
		String actuleProperDeatails= driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsOne));
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsTwo));
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsThree));
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsFour));
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsFive));
		Assert.assertTrue(actuleProperDeatails.contains(ExepetedProperDeatailsSix));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();	
	}
	
	public  String GenerateEmail() {
	
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com" ;
		
		
	}

}
