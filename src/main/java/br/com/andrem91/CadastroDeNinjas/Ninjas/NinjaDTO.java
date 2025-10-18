package br.com.andrem91.CadastroDeNinjas.Ninjas;

import br.com.andrem91.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @URL(message = "URL da imagem deve ser válida")
    private String imgUrl;

    @Min(value = 0, message = "Idade não pode ser negativa")
    private int idade;

    @NotBlank(message = "Rank é obrigatório")
    private String rank;

    private MissoesModel missoes;
}
