package com.ApplicationApiFilmes.Filmes.repository;

import com.ApplicationApiFilmes.Filmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//aqui ficará as partes responsáveis pelo banco de dados
@Repository //isso indica que é o repositorio de acesso de dados
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    //passamos o tipo da entidade que sera gerenciada (Film) e o PK que será do tipo long
}
