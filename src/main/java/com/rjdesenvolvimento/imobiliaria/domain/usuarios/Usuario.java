package com.rjdesenvolvimento.imobiliaria.domain.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(schema = "usuario")
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String login;
    private String senha;
    private Integer roleCodigo;
    private String roleDescricao;
    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_pessoafisicas")
    private PessoaFisica pessoaFisica;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha, RoleEnum roleCodigo, RoleEnum roleDescricao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.roleCodigo = roleCodigo.getCodigo();
        this.roleDescricao = roleDescricao.getDescricao();
    }

    public RoleEnum getRoleCodigo() {
        return RoleEnum.converteParaEnum(roleCodigo);
    }

    public String getRoleDescricao() {
        return RoleEnum.descricao(roleCodigo);
    }
}
