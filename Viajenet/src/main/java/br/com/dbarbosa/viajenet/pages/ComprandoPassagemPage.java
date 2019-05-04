package br.com.dbarbosa.viajenet.pages;

import org.openqa.selenium.By;

import br.com.dbarbosa.viajenet.confg.BasePage;
import br.com.dbarbosa.viajenet.confg.DriverFactory;

public class ComprandoPassagemPage extends BasePage {

	public void acessarURl() {
		DriverFactory.getDriver().get(
				"https://www.viajanet.com.br/busca/passagens/voos#/SAO/NVT/RT/29-05-2019/02-06-2019/-/-/-/1/0/0/-/-/-/-");
	}

	public void comprar() {
		clicarBotaoXpath(
				"//*[@id=\"vn-content--result\"]/div/div[3]/ul[3]/vn-full-recommendation/div/div/vn-recommendation-air/li/div[2]/a/span[1]");
	}

	public void setDigitarDados(String email, String nome, String sobrenome, String nasc, String genero) {
		focoJanela();
		escrever("my-account_email", email);
		escrever("nome_0", nome);
		escrever("lastName_0", sobrenome);
		escrever("birth_0", nasc);
		selecionarName("gender_0", genero);// Masculino
	}

	public void setTipoPay() {
		clicarRadio("card13");
	}

	public void setPreenchendoCamposPay(String nome, String cpf, String banco, String cep, String endereco,
			String numero, String bairro, String cidade, String estado) {
		escrever("name_card-0", nome);
		escrever("cpf_card-0", cpf);
		selecionar("BankCode-0", banco);
		escrever("zipcode-0", cep);
		escrever("address-0", endereco);
		escrever("number_address-0", numero);
		escrever("neighborhood-0", bairro);
		escrever("city-0", cidade);
		selecionar("state-0", estado);// SAO PAULO

	}

	public void setPreenchendoContato(String email, String emailConfirm, String telTipo, String numeroTel) {

		escrever("contact_email", email);
		escrever("contact_email_confirm", emailConfirm);
		selecionar("contact_phone_0", telTipo); // Celular
		escrever("contact_phonenumber_0", numeroTel);

	}

	public void setAceitaEConfirma() {
		clicarCheck("accept-checkout");
		clicarBotaoXpath("//*[@id=\"frmCheckout\"]/div[5]/div[2]/button");
	}

	public String setValidarProcessamento() {
		return obterTextoXpath(By.xpath("//span[@class='in-progress']"));
	}

}
