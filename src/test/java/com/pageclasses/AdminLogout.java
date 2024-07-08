package com.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath = "(//a[@href='logout.php'][normalize-space()='Logout'])[2]")
WebElement objlogout;
public void logout() {
	objlogout.click();
}
}
