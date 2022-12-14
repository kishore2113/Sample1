package org.practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver;

	public void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void quit() {
		driver.quit();
	}
	public List<WebElement> locatorss(String attributeValue) {
		List<WebElement> findElements = driver.findElements(By.xpath(attributeValue));
		return findElements;
		
	}

	public WebElement Locators(String attributeName, String attributeValue) {
		if (attributeName.equalsIgnoreCase("id")) {
			WebElement findElement = driver.findElement(By.id(attributeValue));
			return findElement;
		} else if (attributeName.equalsIgnoreCase("name")) {
			WebElement findElement = driver.findElement(By.name(attributeValue));
			return findElement;
		} else if (attributeName.equalsIgnoreCase("className")) {
			WebElement findElement = driver.findElement(By.className(attributeValue));
			return findElement;
		} else if (attributeName.equalsIgnoreCase("xpath")) {
			WebElement findElement = driver.findElement(By.xpath(attributeValue));
			return findElement;
		} else {
			List<WebElement> findElements = driver.findElements(By.tagName(attributeValue));
			return (WebElement) findElements;
		}

	}

	public void sendvalue(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
		
	}

	public void btnClick(WebElement findElement) {
		findElement.click();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public void getText(WebElement findElement) {
		String text = findElement.getText();
		System.out.println(text);
	}

	public void getAttribute(WebElement findElement) {
		String attribute = findElement.getAttribute("value");
		System.out.println(attribute);
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void actionSendKeys(WebElement element, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(element, value).perform();
	}

	public void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertSendKeys(String value) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(value);
		al.accept();
	}

	public void javaScriptEnterText(WebElement findElement, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','text')", findElement);
	}

	public String javaScriptGetText(WebElement findElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("arguments[0].getAttribute('value')", findElement);
		String string = executeScript.toString();
		return string;
	}

	public void javaScriptClick(WebElement findElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", findElement);
	}

	public void javaScriptScrollDown(WebElement findElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollInToView(true)", findElement);
	}

	public void javaScriptScrollUp(WebElement findElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollInToView(false)", findElement);
	}

	public void screenShot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
	}

	public void ddSelectByIndex(WebElement findElement, int index) {
		Select select = new Select(findElement);
		select.selectByIndex(index);
	}

	public void ddSelectByValue(WebElement findElement, String Value) {
		Select select = new Select(findElement);
		select.selectByValue(Value);
	}

	public void ddSelectByVisibleText(WebElement findElement, String text) {
		Select select = new Select(findElement);
		select.selectByVisibleText(text);
	}

	public void ddPrintSingleOption(WebElement findElement, int index) {
		Select select = new Select(findElement);
		List<WebElement> options = select.getOptions();
		WebElement webElement = options.get(index);
		String text = webElement.getText();
		System.out.println(text);
	}

	public void ddPrintAllOptions(WebElement findElement) {
		Select select = new Select(findElement);
		List<WebElement> options = select.getOptions();
		for (WebElement allOptions : options) {
			String text = allOptions.getText();
			System.out.println(text);
		}
	}

	public void ddSelectMultipleOptions(WebElement findElement, int index) {
		Select select = new Select(findElement);
		select.selectByIndex(index);
		
	}

	public void ddSelectAll(WebElement findElement) {
		Select select = new Select(findElement);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);
		}
	}

	public void ddPrintAllSelected(WebElement findElement) {
		Select select = new Select(findElement);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement allOptions : allSelectedOptions) {
			String text = allOptions.getText();
			System.out.println(text);
		}
	}

	public void ddDeselectSingleValue(WebElement findElement, int index) {
		Select select = new Select(findElement);
		select.deselectByIndex(index);
	}

	public void ddDeselectAll(WebElement findElement) {
		Select select = new Select(findElement);
		select.deselectAll();
	}

	public void ddSingleOrMultiple(WebElement findElement) {
		Select select = new Select(findElement);
		boolean multiple = select.isMultiple();
		System.out.println(multiple);
	}
	
	public String readxclSingleValue(String sheetName, int rowNum, int cellNum) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\Kishore\\eclipse-workspace\\MavenProject\\DataDriven\\Login.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				res = f.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				//BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				//res = valueOf.toString();
				long check = Math.round(d);
				if(check==d) {
					res = String.valueOf(check);
				}
				else {
					res = String.valueOf(d);
					
				}
			}
		default:
			break;
		}
		return res;
	}

	public void readxclStringAndNumericalValues(String path, String sheetName) throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue + "\t");
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyy");
						String format = date.format(dateCellValue);
						System.out.print(format + "\t");
					} else {
						double numericCellValue = cell.getNumericCellValue();
						BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
						String string = valueOf.toString();
						System.out.print(string + "\t");
					}
				default:
					break;
				}
			}
			System.out.println();
		}

	}

	public void writexcl(String path, String sheetName, int i, int j, String Value) throws IOException {
		File file = new File(path);
		Workbook book = new XSSFWorkbook();
		Sheet createSheet = book.createSheet(sheetName);
		Row createRow = createSheet.createRow(i);
		Cell createCell = createRow.createCell(j);
		createCell.setCellValue(Value);
		FileOutputStream f = new FileOutputStream(file);
		book.write(f);
	}

	public void replacexcl(String path, String sheetName, int i, int j, String PresentValue, String ChangeValue)
			throws IOException {
		File file = new File(path);
		FileInputStream f = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(f);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equalsIgnoreCase(PresentValue)) {
			cell.setCellValue(ChangeValue);
		}
		FileOutputStream stream = new FileOutputStream(file);
		book.write(stream);
	}

	public void staticWait(long ms) throws InterruptedException {
		Thread.sleep(ms);
	}

	public WebElement webdriverWait(long sec, String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		return webElement;
	}
	public void implicityWait(long ms) {
		driver.manage().timeouts().implicitlyWait(ms, TimeUnit.SECONDS);
	}
	

}

