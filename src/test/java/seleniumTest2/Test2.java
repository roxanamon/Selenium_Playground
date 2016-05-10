package seleniumTest2;


import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {
	
	private static WebDriver driver;

		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception{
		
		driver = new FirefoxDriver();
		driver.get("http://timvroom.com/selenium/playground/");
		}
		
//Grab page title and place title text in answer slot #1
		
		@Test
		public void test1() throws InterruptedException{
		
		String pageTitle = driver.getTitle(); 
		driver.findElement(By.id("answer1")).sendKeys(pageTitle);

		}
		
		
//Fill out name section of form to be Kilgore Trout
		@Test
		
		public void test2() throws InterruptedException{
			
		driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
		
		}
		
//Set occupation on form to Sci-Fi Author
		
		@Test
		
		public void test3() throws InterruptedException{
		
		WebElement dropDownList = driver.findElement(By.id("occupation"));
		new Select(dropDownList).selectByVisibleText("Science Fiction Author");
		
		}
		

//Count number of blue_boxes on page after form and enter into answer box #4

		
		@Test
		public void test4() throws InterruptedException{
			
		int count = driver.findElements(By.className("bluebox")).size();
		String cnt = String.valueOf(count);
		driver.findElement(By.id("answer4")).sendKeys(cnt);

		}
		
//Click link that says 'click me'
		@Test
		public void test5() throws InterruptedException{
	
		driver.findElement(By.linkText("click me")).click();
			
		}
		
//Find red box on its page find class applied to it, and enter into answer box #6		
		@Test
		public void test6() throws InterruptedException{
			
		
		String red = driver.findElement(By.id("redbox")).getAttribute("class");
		driver.findElement(By.id("answer6")).sendKeys(red);		
		
		}
		
//Run JavaScript function as: ran_this_js_function() from your Selenium script
		
		@Test
		public void test7() throws InterruptedException{
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("ran_this_js_function();");
			

	// ett annan sätt
			/*
			
			if (driver instanceof JavascriptExecutor)

			{

			((JavascriptExecutor)driver).executeScript("ran_this_js_function();");

			}
			*/	
			
		}
		
//Run JavaScript function as: got_return_from_js_function() from your Selenium script, take returned value and place it in answer slot #8	
		@Test
		public void test8() throws InterruptedException{
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			Long exe =(Long) executor.executeScript("return got_return_from_js_function();");
			String value = String.valueOf(exe);
			driver.findElement(By.id("answer8")).sendKeys(value);		
			
		}
		
//Mark radio button on form for written book? to Yes
		@Test
		public void test9() throws InterruptedException{
			
			driver.findElement(By.name("wrotebook")).click();
			
		}
		

//Get the text from the Red Box and place it in answer slot #10
		
		@Test
		public void test10() throws InterruptedException{
			
			String redtex = driver.findElement(By.id("redbox")).getText(); 
			driver.findElement(By.id("answer10")).sendKeys(redtex);			
		}
		
//Which box is on top? orange or green -- place correct color in answer slot #11		
		@Test
		public void test11() throws InterruptedException{
			
			int orange = driver.findElement(By.id("orangebox")).getLocation().getY();
			 int green = driver.findElement(By.id("greenbox")).getLocation().getY();
			 
			 if ( orange< green){
					driver.findElement(By.id("answer11")).sendKeys("orange");			

			 }
			 
			 else{
					driver.findElement(By.id("answer11")).sendKeys("green");			

			 }

		}
		
		
//Set browser width to 850 and height to 650
		@Test
		public void test12() throws InterruptedException{
			
			Dimension d = new Dimension (850, 650);					
			driver.manage().window().setSize(d);
			
		}
		
//Type into answer slot 13 yes or no depending on whether item by id of ishere is on the page	
		
		@Test
		public void test13() throws InterruptedException{
			try{
				WebElement find = driver.findElement(By.id("ishere"));
				driver.findElement(By.id("answer13")).sendKeys("yes");			
				
			}
			catch(NotFoundException f){
				driver.findElement(By.id("answer13")).sendKeys("no");			

			}
			
		}
		
//Type into answer slot 14 yes or no depending on whether item with id of purplebox is visible 
		
		@Test
		public void test14() throws InterruptedException{
			
			if(driver.findElement(By.id("purplebox")).isDisplayed()){
				driver.findElement(By.id("answer14")).sendKeys("yes");			

			}
			
			else{
				driver.findElement(By.id("answer14")).sendKeys("no");			

			}
			
		}
		
//Waiting game: click the link with link text of 'click then wait' a random wait will occur (up to 10 seconds) and then a new link will get added with link text of 'click after wait' - click this new link within 500 ms of it appearing to pass this test 		
		
		@Test
		public void test15() throws InterruptedException{
			
			driver.findElement(By.xpath("//a[@onclick='show_new_link_after_wait();return false;']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@onclick='click_after_wait();return false;']")));
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
						
			driver.findElement(By.xpath("//a[@onclick='click_after_wait();return false;']")).click();
		}
		
		
		@Test
		public void test16() throws InterruptedException{
			
			Alert alertWindow = driver.switchTo().alert(); 
			alertWindow.accept();
		}
		
		@Test
		public void test17() throws InterruptedException{
			
			driver.findElement(By.id("submitbutton")).click();

		}
		
		
}


