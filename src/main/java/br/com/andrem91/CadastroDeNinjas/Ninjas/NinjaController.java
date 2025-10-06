package br.com.andrem91.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota.";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/lsitarID")
    public String mostrarNinjasPorId() {
        return "Mostrar ninja por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjaPorID() {
        return "Alterar ninja por ID";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId() {
        return "Ninja deletado";
    }
}
