package seleniumTest2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;


public class LogTest1 {
	
	Logger logger = Logger.getLogger(this.getClass());
	WebDriver driver = new FirefoxDriver();
	
	@FindBy (id="answer1")
	WebElement answer1Field;
	
	@FindBy (xpath="//*[@id= 'answer2']") WebElement answer2Field;
	
	
	public LogTest1(){
		
		driver.get("http://timvroom.com/selenium/playground/");
		PageFactory.initElements(driver, this);
	}
		
	
	
	@Test
	public void testLog(){
		
		logger.info("Starting...");
		logger.debug("Very detailed log");
		logger.fatal("Terribly failing!");
		
	}
	

}
