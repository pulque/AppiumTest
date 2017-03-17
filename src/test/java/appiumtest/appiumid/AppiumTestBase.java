package appiumtest.appiumid;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTestBase {

	private AndroidDriver<WebElement> driver;

	@Before
	public void prepare() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "base.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "T8DDU15303001806");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.pulque.idcard");
		capabilities.setCapability("appActivity", ".IDCardActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		System.out.println("App is launched.");
	}

	@After
	public void finish() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		// 411722197508214014
		driver.findElementById("com.pulque.idcard:id/Bt_4").click();
		driver.findElementById("com.pulque.idcard:id/Bt_1").click();
		driver.findElementById("com.pulque.idcard:id/Bt_1").click();
		driver.findElementById("com.pulque.idcard:id/Bt_7").click();
		driver.findElementById("com.pulque.idcard:id/Bt_2").click();
		driver.findElementById("com.pulque.idcard:id/Bt_2").click();
		driver.findElementById("com.pulque.idcard:id/Bt_1").click();
		driver.findElementById("com.pulque.idcard:id/Bt_9").click();
		driver.findElementById("com.pulque.idcard:id/Bt_7").click();
		driver.findElementById("com.pulque.idcard:id/Bt_5").click();
		driver.findElementById("com.pulque.idcard:id/Bt_0").click();
		driver.findElementById("com.pulque.idcard:id/Bt_8").click();
		driver.findElementById("com.pulque.idcard:id/Bt_2").click();
		driver.findElementById("com.pulque.idcard:id/Bt_1").click();
		driver.findElementById("com.pulque.idcard:id/Bt_4").click();
		driver.findElementById("com.pulque.idcard:id/Bt_0").click();
		driver.findElementById("com.pulque.idcard:id/Bt_1").click();
		driver.findElementById("com.pulque.idcard:id/Bt_4").click();

		WebElement el = driver.findElementById("com.pulque.idcard:id/enterET");
		assertEquals("411722197508214014", el.getText());

		WebElement el_del = driver.findElementById("com.pulque.idcard:id/Bt_delete");
		for (int i = 0; i < 18; i++) {
			el_del.click();
		}

		System.out.println(el.getText());
		assertEquals("18位中国身份证号码", el.getText());

	}
}
