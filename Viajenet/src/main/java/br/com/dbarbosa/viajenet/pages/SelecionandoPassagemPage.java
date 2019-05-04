package br.com.dbarbosa.viajenet.pages;

import br.com.dbarbosa.viajenet.confg.BasePage;
import br.com.dbarbosa.viajenet.confg.DriverFactory;

public class SelecionandoPassagemPage extends BasePage {

	public void acessarURl() {
		DriverFactory.getDriver().get(
				"https://www.viajanet.com.br/?gclid=CjwKCAjw8LTmBRBCEiwAbhh-6OujABz-gxxgVdxtZN6eOeCL9EscxFj1EOZIKn4Gibtvp57vR0zg9BoC_SEQAvD_BwE");
	}

	public void setOrigem(String origem) {
		escrever("inptorigin", origem);
	}

	public void setDestino(String destino) {
		escrever("inptdestination", destino);
	}

	public void setPassagemIdaeVolta() {
		clicarRadio("iptRoundTrip");
	}

	public void selecionaAdulto(String qtd) {
		selecionar("drpAdultsQtd", qtd);

	}

	public void selecionarCrianca(String qtd) {
		selecionar("drpChildrenQtd", qtd);
	}

	public void selecionarPessoasString(String qtdAdu, String qtdCria) {
		selecionaAdulto(qtdAdu);
		selecionarCrianca(qtdCria);
	}

	public void selecionarDataIda(String dataIda) {
		selecionarData("departureDate", dataIda);
	}

	public void selecionarDataVolta(String dataVolta) {
		selecionarData("arrivalDate", dataVolta);
	}

	public void selecionandoDatas(String ida, String volta) {
		selecionarDataIda(ida);
		selecionarDataVolta(volta);
	}

	public void pesquisar() {
		clicarBotaoXpath("//*[@id='passagens']/form/div[1]/div/label/button");
	}

	public void dataViagemIndef() {
		clicarCheck("box-nodate");
	}
	
	

}
