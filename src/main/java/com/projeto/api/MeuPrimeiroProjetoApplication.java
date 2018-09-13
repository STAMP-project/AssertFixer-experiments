package com.projeto.api;

import com.projeto.api.entities.Empresa;
import com.projeto.api.repositories.EmpresaRepository;
import com.projeto.api.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

    @Autowired
    private EmpresaRepository empresaRepository;

    public static void main(String[] args) {
        SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
    }

    /*
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
            System.out.println("Senha encoded: " + senhaEncoded);

            senhaEncoded = SenhaUtils.gerarBCrypt("123456");
            System.out.println("Senha encoded novamente: " + senhaEncoded);

            System.out.println("Senha valida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
        };
    }
    */

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Empresa empresa = new Empresa();

            empresa.setRazaoSocial("Empresa TI");
            empresa.setCnpj("888999000111");

            this.empresaRepository.save(empresa);

            List<Empresa> empresas = empresaRepository.findAll();
            empresas.forEach(System.out::println);

            Empresa empresaDb = empresaRepository.findById(1L).get();
            System.out.println("Empresa por ID: " + empresaDb);

            empresaDb.setRazaoSocial("Empresa TI Web");

            this.empresaRepository.save(empresaDb);

            Empresa empresaCnpj = empresaRepository.findByCnpj("888999000111");
            System.out.println("Empresa por CNPJ: " + empresaCnpj);

            this.empresaRepository.deleteById(1L);

            empresas = empresaRepository.findAll();
            System.out.println("Empresas: " + empresas.size());
        };
    }
}
