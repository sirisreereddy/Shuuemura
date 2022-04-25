package com.loreal.automation.utilities;

import java.util.ArrayList;

import com.loreal.automation.base.BaseTest;

public class EnvironmentTestData extends BaseTest {
		
	public EnvironmentTestData() {
		super();
	}
	
	public  String
	
	menuItems,reportName,keyword,mainmenu,submenu,mainmenu1,submenu1,mainmenu3,submenu3,arSubmenu,arMainmenu,frequency,arProduct,menuPlp,subMenuplp,menuSb,submenuSb,prodNamesb,inValidPromoCode,
	fname, lname, password,address, city, state, State, zipcode, phone, month, date, year, email1, email2, email3,	 email4, email5,email6, email7,
	 email8, email9, email10, email11, email12, email13, email14, invalidPwd, zip1, zip2, zip3, zip4, brandName, newpassword,emailEdit,firstname, lastname,
	 editpassword, editstate, editPhone, phone1, phone2, phone3, phone4, phone5,phone6, phone7, cardholdername, cardtype, cardnumber, Expirymonth,Expiryyear,
	  CVV,  invalidCardnum,	 email,Password,Firstname,Username,sample1,sample2,payPalEmail,payPalPassword,username,		Billingaddress,billing_city,
		billing_zipcode,billing_State,productName,invemails,invzips,invphones,productName1,Username1,
		credname ,
		crednumber1,
		crednumber2,
		crednumber3,
		crednumber4,
		cardtype1,
		cardtype2,
		cardtype3,
		cardtype4,
		expmonth,
		expyear,
		cvv1,
		cvv3;
			
;
	public static ArrayList<String> menu = new ArrayList<String>();
	public static ArrayList<String> invalidemail = new ArrayList<String>();
	public static ArrayList<String> invalidzip = new ArrayList<String>();
	public static ArrayList<String> invalidphone = new ArrayList<String>();

	
	public void setTestData() {
	
		String URL =getBaseURL();
		if(URL.contains("shuuemura")) {
					
			 reportName="SHUUEMURA US";
			 menuItems="9";
			 menu.add(0,"collections");
			 menu.add(1,"shampoos");
			 menu.add(2,"conditioners");
			 menu.add(3,"styling");
			 menu.add(4,"art of oils");
			 menu.add(5,"new");
			 menu.add(6,"discover");
			 menu.add(7,"Hair Quiz");
			 menu.add(8,"offers");
			 
			
			 invemails="5";
			 invalidemail.add(0,"@domain.com");
			 invalidemail.add(1,"plainaddress");
			 invalidemail.add(2,"#@%^%#$@#$@#.com");
			 invalidemail.add(3,"@domain.com");
			 invalidemail.add(4,"email@@domain..com");
			 
			 invzips="4";
			 invalidzip.add(0,"9404o");
			 invalidzip.add(1,"9404@");
			 invalidzip.add(2,"54ds3");
			 invalidzip.add(3,"9404");
			 
			 invphones="7";
			 invalidphone.add(0,"1234");
			 invalidphone.add(1,"123456852369851");
			 invalidphone.add(2,"91M2561237821");
			 invalidphone.add(3,"563");
			 invalidphone.add(4,".@21");
			 invalidphone.add(5,"52369afd65");
			 invalidphone.add(6,"456123789456321");
			
			 
			 
			 //search
			 keyword="hair";
			//(PDP an AR product
			 mainmenu="shampoos";
			 submenu="colored hair shampoos";
			 arMainmenu = "shampoos";
			 arSubmenu="coarse hair shampoos";
			 frequency="3";
			 arProduct="cleansing oil shampoo";
			 productName1="gentle radiance cleansing oil shampoo";

			 mainmenu1="shampoos";
			 submenu1="colored hair shampoos";
			 productName1="gentle radiance cleansing oil shampoo";
			 mainmenu3="conditioners";
			 submenu3="travel size conditioners";
			
			 //PLP
			 menuPlp="shampoos";
			 subMenuplp="dry hair shampoos";
			 
			 //Shopping Bag
			 menuSb="shampoos";
			 submenuSb="dry shampoos";
			 prodNamesb="color lustre dry cleaner travel-size dry shampoo";
			 inValidPromoCode="WINNER";
			 
			 
			 //Userreg
			 fname="tcs";
			 lname="team";
			 password="123456789";
			 address="10 hudson street";
			 city="new york";
			 state="NY";
			 State="New York";
			 zipcode="10013";
			 phone="9887766554";
			 month="March";
			 date="29";
			 year="1993";
			 invalidPwd="123";
			
			 brandName="Shuuemura";
			 newpassword="123456789";
			 //editacc
			emailEdit="team@gmail.com";
			 firstname="rob";
			 lastname="jr";
			 editpassword="123456789";
			 editstate="New York";
			 editPhone="9776655443";
			 
			 
			 cardholdername="test";
			 cardtype="American Express";
			 cardnumber="341134113411347";
			 Expirymonth="March";
			    Expiryyear="2024";
			    CVV="1234";
			    invalidCardnum="7@@@@@@@@@@@@@@@@@@";

			 
			 
			email="lorealtcs@gmail.com";
			Username1="lorealtcs2021@gmail.com";
			Password="123456789";
				
				Firstname="test";
				Username="team@gmail.com";
				
				
		//checkout
				sample1="urban moisture hydro-nourishing shampoo sample";
				sample2="muroto volume pure lightness shampoo sample";
				
				payPalEmail="lorealus@gmail.com";
				payPalPassword="Loreal@123";
				username="robert jr";
				
				Billingaddress="10 hudson yards";
				billing_city="NY";
				billing_zipcode="10001";
				billing_State="New York";
				    
				credname ="ron";
				crednumber1="4111111111111111";
				crednumber2="5555555555554444";
				crednumber3="378282246310005";
				crednumber4="6011111111111117";
				cardtype1="Visa";
				cardtype2="Master Card";
				cardtype3="American Express";
				cardtype4="Discover";
				expmonth="May";
				expyear="2024";
				cvv1="123";
				cvv3="1234";
			 
		}
				
		
}
}
