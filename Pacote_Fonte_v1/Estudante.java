package Pacote_Fonte_v1;

import java.util.ArrayList;

public class Estudante {

    // Atributos
    private long id;
    private String nome;
    private String email;
    private ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

    // Construtores
    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Métodos Públicos
    public void addMatricula(Matricula matricula) { // Adiciona uma matricula na lista de matriculas
        matriculas.add(matricula);
    }

    public ArrayList getDisciplinasMatriculadas() {

        ArrayList<String> disciplinasMatriculadas = new ArrayList<String>();

        for (Matricula matricula : matriculas) {

            String disciplina = matricula.getDisciplina().getCodigo();

            disciplinasMatriculadas.add(disciplina);
        }

        return disciplinasMatriculadas;
    }

    // Métodos Especiais
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
