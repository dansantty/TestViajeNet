package br.com.dbarbosa.viajenet.confg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

	private static WebDriver sistema;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (sistema == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				sistema = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
				sistema = new ChromeDriver();
				break;
			}
			sistema.manage().window().maximize();
			sistema.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		return sistema;
	}

	public static void killDriver() {
		sistema.quit();

	}

}
