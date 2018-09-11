package br.com.falcao.PontoInteligente.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")// Indica que ao iniciar essa classe, ira carregar o aplicattion.properties é o de test
public class PontoInteligenteApplicationTests {

	@Test
	public void contextLoads() {
	}

}
