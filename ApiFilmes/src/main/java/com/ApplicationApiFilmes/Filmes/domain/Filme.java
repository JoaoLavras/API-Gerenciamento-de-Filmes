package com.ApplicationApiFilmes.Filmes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data //gera Getters, Setters, toString, equals e hashCode
@NoArgsConstructor // Construtor sem Argumentos
@AllArgsConstructor // Construtor com Argumentos

@Entity //marca a classe como uma entidade JPA(java persistence API)
public class Filme {
    @Id //marca o campo como chave primaria (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GERA O ID AUTOMATICAMENTE
    private Long id; //long é o padrão de ID do JPA
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
}
