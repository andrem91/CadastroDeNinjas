package br.com.andrem91.CadastroDeNinjas.Exceptions;

public class NinjaNotFoundException extends RuntimeException {
    public NinjaNotFoundException(Long id) {
        super("Ninja não encontrado com ID: " + id);
    }
}
