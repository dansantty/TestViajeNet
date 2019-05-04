package br.com.dbarbosa.viajenet.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.dbarbosa.viajenet.confg.DriverFactory;
import br.com.dbarbosa.viajenet.pages.SelecionandoPassagemPage;

public class SelecionandoPassagemTest {

	SelecionandoPassagemPage selecionaPage = new SelecionandoPassagemPage();

	@Before
	public void acessaSite() {
		selecionaPage.acessarURl();
	}

	@Test
	public void preenchendoCampos() {
		// Seleciona destino
		selecionaPage.setOrigem("São Paulo, Brasil - (SAO - Todos os Aeroportos)");
		// Seleciona origem
		selecionaPage.setDestino("Navegantes, Navegantes, Brasil (NVT)");
		// seleciona radio do tipo de passagem
		selecionaPage.setPassagemIdaeVolta();
		// quantidade de pessoas
		selecionaPage.selecionarPessoasString("1 adulto", "Nenhuma");
		// datas da viagem
		selecionaPage.selecionandoDatas("29/05/2019", "02/06/2019");
		// selecionaPage.dataViagemIndef();* Metodo caso, não saiba o dia da viagem
		// botão pesquisa
		selecionaPage.pesquisar();
	}

	@After
	public void finaliza() {

		DriverFactory.killDriver();
	}

}
