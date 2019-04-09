import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.applitools.eyes.RectangleSize as RectangleSize
import com.applitools.eyes.selenium.Eyes as Eyes
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//-----------------------------------------check eyesOpen/checkWindow/checkRegion/eyesClose ------------------------------------------------------------
//use 'https://applitools.com/helloworld2?diff1' to make changes to page
WebUI.openBrowser('https://applitools.com/helloworld2?diff2')

//initialize eyes
Eyes eyes = CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen'('sample7', new RectangleSize(
    1024, 768))

WebDriver driver = DriverFactory.getWebDriver()

driver.findElement(By.id('name')).sendKeys('My Name')

By locatorBy = By.id('name')

eyes.checkRegion(locatorBy, 1, 'check checkRegion by selector keyword', true)

//check region by selector
//CustomKeywords.'com.kms.katalon.keyword.applitools.AdvancedKeywords.checkOpenedRegion'(eyes, locatorBy, 1, 'check checkRegion by selector keyword',
//    true)
//check element by selector
//CustomKeywords.'com.kms.katalon.keyword.applitools.AdvancedKeywords.checkOpenedRegion'(eyes, locatorBy, 1, 'check checkRegion by selector keyword',
//    false)
driver.findElement(By.tagName('button')).click()

WebElement element = driver.findElement(By.xpath('//img[contains(@class,\'diff2\')]'))

//check region by web element
CustomKeywords.'com.kms.katalon.keyword.applitools.AdvancedKeywords.checkOpenedRegion'(eyes, element, 0, 'check checkRegion by web element keyword',
    false)

//check window not including eyes set up
CustomKeywords.'com.kms.katalon.keyword.applitools.AdvancedKeywords.checkOpenedWindow'(eyes, 'check checkWindow')

CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose'(eyes)

WebUI.closeBrowser()

CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline'('', '', null)

