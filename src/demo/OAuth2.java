package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;




public class OAuth2 {
@Test
public void OAuth(){
		
//		 System.setProperty("webdriver.chrome.driver","C:/Users/hanand/chromedriver_win32 (2)/chromedriver.exe");
//		    WebDriver driver = new ChromeDriver();
//		    driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		    driver.findElement(By.cssSelector("input[type='email']")).sendKeys("harshitanand83407@gmail.com");
//		    driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		    Thread.sleep(3000);
//		    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("H@rshit01122000");
//		    driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		    Thread.sleep(3000);
//		    String url= driver.getCurrentUrl();
	
		    
// get this by hitting the below  url from .get chrome is not supporting any automation testing
// Hit below url and get url and fill in string variable getcodeurlurl in incognito window make sure after generating code you immediately paste the code from url to getcodeurlurl variable string
// https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		
		
	     String getcodeurlurl= "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AeaYSHAEATXJFk-zlhMtdnXYztTF0shUm8qaGysiYYlyIoOEP_f5LSlqA0-Bc7xkNwnXLQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
	     String partialcode=getcodeurlurl.split("code=")[1];
	     String code=partialcode.split("&scope")[0];
		 System.out.println(code);
		    
		 String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code",code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		String response = given().queryParam("access_token",accessToken).when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(response);

	}
	

}
