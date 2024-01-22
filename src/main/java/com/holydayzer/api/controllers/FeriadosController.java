package com.holydayzer.api.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holydays")
public class FeriadosController {

    @GetMapping
    public String getFeriados() {
        Calendario calendario = new Calendario();
        calendario.imprimirFeriados();

        return "Imprimiu os feriados";
    }

    @GetMapping("/{dia}")
    public String getFeriadoByDay(@PathVariable("dia") LocalDate dia){
        Calendario calendario = new Calendario();
        System.out.println(calendario.verificaFeriado(dia));
        
        return "Disse se era ou não feriado";
    }
}

class Feriado {
    private String nome;
    private LocalDate data;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    Feriado(){}
    
    Feriado(String nome, LocalDate data){
        this.nome = nome;
        this.data = data;
    }
}

class Calendario {
    private ArrayList<Feriado> feriados;

    public Calendario(){
        feriados = new ArrayList<>();

        Feriado natal = new Feriado("Natal", LocalDate.of(2024, 12, 25));
        Feriado pascoa = new Feriado("Pascoa", LocalDate.of(2024,03, 31));
        Feriado tiradentes = new Feriado("Tiradentes", LocalDate.of(2024, 04, 21));
        Feriado independencia = new Feriado("Independência", LocalDate.of(2024, 9, 07));

        feriados.add(natal);
        feriados.add(pascoa);
        feriados.add(tiradentes);
        feriados.add(independencia);
    }

    public void imprimirFeriados(){
        for(Feriado feriado: feriados){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println(feriado.getData().format(formatter) + " é " + feriado.getNome() + "!");
        }
    }

    public String verificaFeriado(LocalDate dataInserida) {
        for(Feriado feriado: feriados){
            if(feriado.getData().equals(dataInserida)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return "Dia " + dataInserida.format(formatter) + " é " + feriado.getNome() + "!";
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Dia " + dataInserida.format(formatter) + " não é feriado";
    }


}