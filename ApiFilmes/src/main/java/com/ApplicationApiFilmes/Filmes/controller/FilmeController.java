package com.ApplicationApiFilmes.Filmes.controller;

import com.ApplicationApiFilmes.Filmes.domain.Filme;
import com.ApplicationApiFilmes.Filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/filmes
//MARCA A CLASSE COMO UM CONTROLADOR DE API REST
//AUTOMATICAMENTE O SPRING VAI SABER QUE VOCE IRÁ LIDAR COM REQUISIÇÕES HTTP
@RestController
@RequestMapping("/filmes") //DEFINE O CAMINHO BASE PARA OS ENDPOINTS
public class FilmeController {
    //LISTA DE OBJETOS DO TIPO FILME ->> NAO PRECISAMOS MAIS DISSO POIS VAMOS ADICIONAR UM REPOSITORY
    //private List<Filme> listaFilmes;
    private final FilmeRepository filmeRepository;

    @Autowired //injeção de repositório direto no construtor
    public FilmeController(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
        //ANTES FAZIAMOS A MANIPULAÇÃO DE DADOS DIRETO DO CONSTRUTOR
        //AGORA CRIAMOS UM REPOSITORY QUE IRÁ GERENCIAR ESSAS INSTANCIAS AUTOMATICAMENTE
        //LOGO NOSSO CONSTRUTOR RECEBE ESSE REPOSITORY E O SPRING FAZ O CONTROLE NECESSARIIS INJETANDO DEPENDENCIAS
    }

    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme novoFilme){
        return filmeRepository.save(novoFilme); //salva um novo filme no banco de dados
    }

    @GetMapping
    public List<Filme> listarTodos(){
        return filmeRepository.findAll(); //lista todos do banco de dados
    }

    //SEMPRE QUE HOUVER MAPPING ESTAMOS FALANDO DE MAPEAMENTO = URL
    @GetMapping("/{id}")
    //ESSE PATH IRÁ EXTRAI O {id} da URL
    public Filme buscarPorId(@PathVariable Long id){
        return filmeRepository.findById(id).orElse(null);
    }

    //MAPEIA REQUISIÇÕES HTTP PUT USADAS PARA ATUALIZAR RECURSOS
    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id,@RequestBody Filme filmeAtualizado){
        filmeAtualizado.setId(id);
        return filmeRepository.save(filmeAtualizado);
    }

    //MAPEIA REQUISIÇÕES HTPP DELETE
    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Long id){
        filmeRepository.deleteById(id);
        //boa pratica:
        //quando voce deleta ja sabe quem exatamente vai deletar, então voce nao precisa de um retorno, apenas a confirmação de que foi deletado
    }
}
