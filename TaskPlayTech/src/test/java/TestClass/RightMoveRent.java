package TestClass;

import BaseClass.Base;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class RightMoveRent extends Base {
    private WebDriver driver;
    @Before
    public void setUp() {
        super.setUp();
        driver = getDriver();
    }

    @Test
    public void testToRent() throws InterruptedException {
        driver.get("https://www.rightmove.co.uk/");
        WebElement searchButton = driver.findElement(By.cssSelector(("input[placeholder=\"e.g. 'York', 'NW3', 'NW3 5TY' or 'Waterloo Station'\"]")));
        searchButton.sendKeys("SS2");
        driver.findElement(By.cssSelector("div[id='_3OuiRnbltQyS534SB4ivLV'] button:nth-child(2)")).click(); //clicking for rent

        WebElement searchRadius = driver.findElement(By.xpath("//select[@id='radius']"));
        selectOptionForDropDown(searchRadius, "Within 5 miles");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//button[@class='optanon-allow-all accept-cookies-button']")).click();


        //getWebElementWithExplicitWait(driver,20,By.xpath(".//button[@class='optanon-allow-all accept-cookies-button']")).click();

       // WebElement priceRangemax = driver.findElement(By.id("maxPrice"));
        //Select price_range_max = new Select(priceRangemax);
        //price_range_max.selectByVisibleText("110PCM");

       // WebElement minBedroom = driver.findElement(By.xpath("//select[@id='minBedrooms']"));
        //selectOptionForDropDown(minBedroom, "2");

        WebElement propertyType = driver.findElement(By.xpath("//select[@id='displayPropertyType']"));
        selectOptionForDropDown(propertyType, "Houses");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        WebElement sortingPrice = driver.findElement(By.xpath("//select[@id='sortType']"));
        selectOptionForDropDown(sortingPrice, "Lowest Price");

       // WebElement image = driver.findElement(By.cssSelector(" By.cssSelector(\"div[id='property-127205597'] address[class='propertyCard-address property-card-updates']\")"));
        //image.click();

        getWebElementWithExplicitWait(driver, 2000, By.cssSelector("div[id='property-127205597'] address[class='propertyCard-address property-card-updates']")).click();
        assertEquals("https://www.rightmove.co.uk/properties/126555848#/?channel=RES_BUY", driver.getCurrentUrl());
    }
}



