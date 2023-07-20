package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetUp {

	
	public WebDriver driver=null;
	public String shortName=null;
	public String prodNameHome=null;
	public PageObjectManager pageManager=null;
	public TestBase testBase=null;
	public GenericUtils gen=null;
	public String prodNameOffer=null;
	public TestContextSetUp() throws Exception
	{
		testBase=new TestBase();
		pageManager=new PageObjectManager(testBase.webDriverManager());
		gen=new GenericUtils(testBase.webDriverManager());
	}
}
