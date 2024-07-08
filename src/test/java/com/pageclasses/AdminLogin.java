package com.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
@FindBy(name = "btnreset")
WebElement objreset;
@FindBy(name = "username")
WebElement objusername;
@FindBy(id = "password")
WebElement objpass;
@FindBy(xpath  = "//button[@id='btnsubmit']")
WebElement objlogin;
public void login(String user, String pass) {
	objreset.click();
	objusername.sendKeys(user);
	objpass.sendKeys(pass);
	objlogin.click();
}
}
