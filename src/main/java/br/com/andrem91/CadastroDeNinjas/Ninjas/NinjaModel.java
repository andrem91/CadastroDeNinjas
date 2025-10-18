package br.com.andrem91.CadastroDeNinjas.Ninjas;

import br.com.andrem91.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 50)
    private String rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
