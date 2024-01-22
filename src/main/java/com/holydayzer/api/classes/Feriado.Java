import java.time.LocalDate;

public class Feriado {
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
