import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[contains(@title, 'Search ')]")).sendKeys("Laptop");
		driver.findElement(By.xpath("//input[contains(@title, 'Search ')]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> laplist=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(laplist.size());
		laplist.get(6).click();
		// using foreach
		/*
		 * for(WebElement ele:laplist) { String Product_name =
		 * driver.findElement(By.xpath("//div[@class='_4rR01T']")).getText();
		 * if(Product_name.contains("Inspiron 3511")) { ele.click(); } }
		 */
		Set<String> wh = driver.getWindowHandles();
		List<String> whlist=new ArrayList(wh);
		driver.switchTo().window(whlist.get(1));
		Thread.sleep(2000);
		//new window
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']")).sendKeys("8489828922");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Careerspot@5");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//order confirmation
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("8489828922");
		driver.findElement(By.xpath("//span[text()='Payment Options']")).click();
		// remove from cart
		driver.findElement(By.xpath("//span[text()='Remove']")).click();
		//validate product is removed from cart
		String message = driver.findElement(By.xpath("//span[text()='Order Summary']/following::div[@class='LYTQKl']")).getText();
		if(message.equals("Your checkout has no items."))
		{
			System.out.println("Product is removed from cart");
		}
		
		
		

	}

}
