package br.com.dbarbosa.viajenet.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dbarbosa.viajenet.confg.DriverFactory;
import br.com.dbarbosa.viajenet.pages.ComprandoPassagemPage;

public class ComprandoPassagemTest {

	ComprandoPassagemPage compraPage = new ComprandoPassagemPage();

	@Before
	public void acessaSite() {
		compraPage.acessarURl();
	}

	@Test
	public void comprando() {

		// Clicar bot�o Comprar
		compraPage.comprar();

		// Digitar Dados
		compraPage.setDigitarDados("danielqiluaige@gmail.com", "Daniel ", "Qiluaige", "26011993", "Masculino");

		// escolhendo forma pagamento
		compraPage.setTipoPay();

		// preenchendo dados pagamento
		compraPage.setPreenchendoCamposPay("Daniel Qiluaige", "88116197851", "Ita�", "03924250",
				"Rua Primeiro Sorriso", "130", "Jardim Dona Sinh�", "S�o Paulo", "SAO PAULO");

		// preenchendo campos contato
		compraPage.setPreenchendoContato("danielqiluaige@gmail.com", "danielqiluaige@gmail.com", "Celular",
				"11953545454");

		// aceita e finaliza
		compraPage.setAceitaEConfirma();

		// valida mensagem processo
		Assert.assertEquals(
				"Reserva em processamento.\nSua reserva est� em processamento."
						+ " Ap�s a confirma��o do pagamento voc� receber� sua passagem a�rea por e-mail.",
				compraPage.setValidarProcessamento());

	}

	@After
	public void finaliza() {

		DriverFactory.killDriver();
	}

}
