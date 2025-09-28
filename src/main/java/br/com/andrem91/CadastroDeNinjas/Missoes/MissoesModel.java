package br.com.andrem91.CadastroDeNinjas.Missoes;

import br.com.andrem91.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    private NinjaModel ninjas;

    public MissoesModel() {
    }

    public MissoesModel(String nome, String dificuldade, NinjaModel ninjas) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public NinjaModel getNinjas() {
        return ninjas;
    }

    public void setNinjas(NinjaModel ninjas) {
        this.ninjas = ninjas;
    }
}
