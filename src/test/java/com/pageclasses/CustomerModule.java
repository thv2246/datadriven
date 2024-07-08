package com.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerModule {
	WebDriver driver;
	public CustomerModule(WebDriver driver) {
		this.driver = driver;	
	}
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement objcustomer;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement objadd;
	@FindBy(xpath = "//input[@id='x_Customer_Number']")
	WebElement objcustomernum;
	@FindBy(id  = "x_Customer_Name")
	WebElement objname;
	@FindBy(xpath ="//textarea[@id='x_Address']")
	WebElement objaddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement objcity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement objcountry;
	@FindBy(xpath ="//input[@id='x_Contact_Person']")
	WebElement objcperson;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement objphno;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement objemail;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement objmobile;
	@FindBy(xpath = "//input[@id='x_Notes']")
	WebElement objnotes;
	@FindBy(id = "btnAction")
	WebElement ObjAddBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjConfirmOk;
	@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
	WebElement ObjAlertOk;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearcTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchbtn;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement customertable;
	public boolean add_Customer(String cname,String Address,String city,String Country,String cperson,
			String pnumber,String email,String mnumber,String notes) throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.objcustomer).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjAddBtn).click().perform();
		Thread.sleep(2000);
		String Exp_Data = this.objcustomernum.getAttribute("value");
		this.objname.sendKeys(cname);
		this.objaddress.sendKeys(Address);
		this.objcity.sendKeys(city);
		this.objcountry.sendKeys(Country);
		this.objcperson.sendKeys(cperson);
		this.objphno.sendKeys(pnumber);
		this.objemail.sendKeys(email);
		this.objmobile.sendKeys(mnumber);
		this.objnotes.sendKeys(notes);
		ac.moveToElement(this.ObjAddBtn).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(this.ObjConfirmOk).click().build().perform();
		ac.pause(4000);
		ac.moveToElement(this.ObjAlertOk).click().perform();
		Thread.sleep(3000);
		if(!this.ObjSearcTextbox.isDisplayed())
			this.ObjSearchPanel.click();
		this.ObjSearcTextbox.clear();
		this.ObjSearcTextbox.sendKeys(Exp_Data);
		this.ObjSearchbtn.click();
		Thread.sleep(4000);
		String Act_data = this.customertable.getText();
		if(Act_data.equals(Exp_Data))
		{
			Reporter.log(Act_data+"     "+Exp_Data,true);
			return true;
		}
		else
		{
			Reporter.log(Act_data+"     "+Exp_Data,true);
			return false;
		}
	}


	}

		


