package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class WishlistPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement wishName;

    @FindBy(id = "submitWishlist")
    private WebElement submitWishList;

    @FindBy(css = ".table.table-bordered")
    private WebElement wishlistTable;

    @FindBy(className = "page-heading")
    private WebElement screenName;

    public WishlistPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    public String getScreenName(){
        return screenName.getText();
    }

    public void deleteWishFromList(String item){
        List<WebElement> rows = getRows(wishlistTable);
        for(WebElement row : rows){
            if(row.getText().contains(item)){
                WebElement rowDelete = row.findElement(By.className("icon-remove"));

                wait.until(ExpectedConditions.elementToBeClickable(rowDelete));
                rowDelete.click();
                acceptPopup();
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(wishlistTable, item)));
            }
        }
    }

    private int getColumnNumber(List<WebElement> columns, String columnName) {
        int columnNumber = 0;
        for (int i = 0; i < columns.size(); i++){
            if (columns.get(i).getText().contains(columnName)) {
                columnNumber = i;
                break;
            }
        }
        return columnNumber;
    }

    private List<WebElement> getColumns(WebElement table) {
        List<WebElement> columns = table.findElements(By.tagName("td"));
        return columns;
    }

    private List<WebElement> getRows(WebElement table){
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows;
    }

    public void acceptPopup(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean foundTextInTable(String item) {
        boolean itemFound = false;
        List<WebElement> rows = getRows(wishlistTable);
        for (WebElement row : rows) {
            if (row.getText().contains(item)) {
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }

    public void fillWishName(String wish){
        wishName.sendKeys(wish);
    }

    public void clickSave(){
        submitWishList.click();
    }

    public void refresPage(){
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(submitWishList));
    }
}
