package br.com.dbarbosa.viajenet.confg;

import static br.com.dbarbosa.viajenet.confg.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	// Textos //

	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public String obterTextoXpath(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTextoXpath(String xpath) {
		return obterTexto(By.xpath(xpath));
	}

	// Radio, Check e button //

	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}

	public void clicarBotaoXpath(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotaoXpath(String xpath) {
		clicarBotao(By.xpath(xpath));
	}

	// Select //

	public void selecionar(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selecionarName(String name, String valor) {
		WebElement element = getDriver().findElement(By.name(name));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	// Data e Frame

	public void clicarData(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public static void selecionarDataJs(String dataVal, WebElement elemento) {

		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].setAttribute('value','" + dataVal + "');", elemento);
	}

	public void selecionarData(String idData, String dataIda) {
		WebElement calendario = getDriver().findElement(By.id(idData));
		calendario.click();
		String dataVal = dataIda;
		selecionarDataJs(dataVal, calendario);

	}
	
	public void focoJanela() {
		for(String winHandle : getDriver().getWindowHandles()){
		    getDriver().switchTo().window(winHandle);
		}
	}

}
