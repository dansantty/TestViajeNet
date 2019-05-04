package br.com.dbarbosa.viajenet.suite.tests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import br.com.dbarbosa.viajenet.tests.SelecionandoPassagemTest;
import br.com.dbarbosa.viajenet.confg.DriverFactory;
import br.com.dbarbosa.viajenet.tests.ComprandoPassagemTest;

@RunWith(Suite.class)
@SuiteClasses({
	SelecionandoPassagemTest.class,
	ComprandoPassagemTest.class
})

public class SuiteGeral {

	@AfterClass
	public static void finaliza(){
		DriverFactory.killDriver();
	}
}
