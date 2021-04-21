package Pacote_Fonte_v1;

public class Matricula {

    // Atributos
    private Estudante estudante;
    private Disciplina disciplina;

    // Construtores

    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }
    
    // Métodos Públicos
    // Métodos Especiais
    
    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
