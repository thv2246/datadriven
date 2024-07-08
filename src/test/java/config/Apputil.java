package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pageclasses.AdminLogin;
import com.pageclasses.AdminLogout;

public class Apputil {
public static WebDriver dc;
@BeforeTest
public static void start() {
	dc = new ChromeDriver();
	dc.manage().window().maximize();
dc.get("http://webapp.qedgetech.com");
dc.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
AdminLogin login = PageFactory.initElements(dc, AdminLogin.class);
login.login("admin", "master");
}
@AfterTest
public static void quit() {
	AdminLogout logout = PageFactory.initElements(dc, AdminLogout.class);
	logout.logout();
	dc.quit();
}
}
