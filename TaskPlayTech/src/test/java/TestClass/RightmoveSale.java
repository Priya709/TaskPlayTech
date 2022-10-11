package TestClass;

import BaseClass.Base;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class RightmoveSale extends Base {

    private WebDriver driver;

    @Before
    public void setUp() {
        super.setUp();
        driver = getDriver();
    }


    @Test
    public void testForSaleHouses() {
        driver.get("https://www.rightmove.co.uk/");
        WebElement searchButton = driver.findElement(By.xpath("//input[@placeholder=\"e.g. 'York', 'NW3', 'NW3 5TY' or 'Waterloo Station'\"]"));
        searchButton.sendKeys("SS2 6JZ");
        driver.findElement(By.xpath("//button[normalize-space()='For Sale']")).click(); //click for sale

        WebElement searchRadius = driver.findElement(By.xpath("//select[@id='radius']"));
        selectOptionForDropDown(searchRadius, "Within 5 miles");

        WebElement priceRangeMin = driver.findElement(By.xpath("//select[@id='minPrice']"));
        Select distanceSelection = new Select(priceRangeMin);
        distanceSelection.selectByVisibleText("60,000");

        WebElement priceRangeMax = driver.findElement(By.xpath("//select[@id='maxPrice']"));
        selectOptionForDropDown(priceRangeMax, "250,000");

        WebElement minBedroom = driver.findElement(By.xpath("//select[@id='minBedrooms']"));
        selectOptionForDropDown(minBedroom, "1");

        WebElement maxBedroom = driver.findElement(By.xpath("//select[@id='maxBedrooms']"));
        selectOptionForDropDown(maxBedroom, "3");

        WebElement propertyType = driver.findElement(By.xpath("//select[@id='displayPropertyType']"));
        selectOptionForDropDown(propertyType, "Houses");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // Sorting it to Newest Listed
        WebElement sortingPrice = driver.findElement(By.xpath("//select[@id='sortType']"));
        selectOptionForDropDown(sortingPrice, "Newest Listed");

        //  WebElement imageSelect = driver.findElement( By.xpath("//div[@id='property-126567620']//address[1]"));
        //imageSelect.click();
        //      getWebElementWithExplicitWait(d, 20, By.xpath("//div[@id='property-126567620']//address[1]")).click();

    }

}