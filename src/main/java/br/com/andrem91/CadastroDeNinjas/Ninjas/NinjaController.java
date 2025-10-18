package br.com.andrem91.CadastroDeNinjas.Ninjas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody @Valid NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoNinja);
    }

    @GetMapping
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> buscarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.buscarNinjaPorId(id);
        return ResponseEntity.ok(ninja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(
            @PathVariable Long id,
            @RequestBody @Valid NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        return ResponseEntity.ok(ninja);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }
}
