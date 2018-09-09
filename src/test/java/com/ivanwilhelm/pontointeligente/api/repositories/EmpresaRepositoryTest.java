package com.ivanwilhelm.pontointeligente.api.repositories;

import com.ivanwilhelm.pontointeligente.api.entities.Empresa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
    @Autowired
    private EmpresaRepository empresaRepository;
    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa de Exemplo Ltda");
        empresa.setCnpj(CNPJ);
        empresaRepository.save(empresa);
    }

    @After
    public final void tearDown() {
        empresaRepository.deleteAll();
    }

    @Test
    public void testBuscaPorCnpj() {
        Empresa empresa = empresaRepository.findByCnpj(CNPJ);
        assertThat(empresa.getCnpj()).isEqualTo(CNPJ);
    }

}
