package br.com.andrem91.CadastroDeNinjas.Ninjas;

import br.com.andrem91.CadastroDeNinjas.Exceptions.NinjaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        return ninjaRepository.findAll()
                .stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO buscarNinjaPorId(Long id) {
        NinjaModel ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new NinjaNotFoundException(id));
        return ninjaMapper.map(ninja);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        validarEmail(ninjaDTO.getEmail());
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninjaSalvo);
    }

    public void deletarNinjaPorId(Long id) {
        if (!ninjaRepository.existsById(id)) {
            throw new NinjaNotFoundException(id);
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        NinjaModel ninjaExistente = ninjaRepository.findById(id)
                .orElseThrow(() -> new NinjaNotFoundException(id));

        atualizarCampos(ninjaExistente, ninjaDTO);
        NinjaModel ninjaSalvo = ninjaRepository.save(ninjaExistente);
        return ninjaMapper.map(ninjaSalvo);
    }

    private void atualizarCampos(NinjaModel ninja, NinjaDTO dto) {
        ninja.setNome(dto.getNome());
        ninja.setEmail(dto.getEmail());
        ninja.setImgUrl(dto.getImgUrl());
        ninja.setIdade(dto.getIdade());
        ninja.setRank(dto.getRank());
        ninja.setMissoes(dto.getMissoes());
    }

    private void validarEmail(String email) {
        // Implementar validação de email duplicado se necessário
    }

}
