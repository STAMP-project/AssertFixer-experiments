package com.mbueno.lanchonete.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Cardapio implements Serializable {

    private Long id;
    private List<Lanche> lanches;

    public Cardapio(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "cardapio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }

    @Override
    public String toString() {
        return "Cardapio [id=" + id +"]";
    }
}
