package Pacote_Fonte_v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Faculdade {

    // Atributos
    private String nome;
    private ArrayList<Estudante> estudantes = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    // Construtores
    public Faculdade(String nomeFaculdadeEsperado) {
        this.nome = nomeFaculdadeEsperado;
    }
    
    // Métodos públicos
    public void carregarDadosArquivo(String nomeArquivoDisciplinas, String nomeArquivoEstudantes, String nomeArquivoMatriculas) {
        
        String pathDisciplinas = nomeArquivoDisciplinas;
        String pathEstudantes = nomeArquivoEstudantes;
        String pathMatriculas = nomeArquivoMatriculas;
        
        // Ler o arquivo TXT de disciplinas, cortar e adicionar na lista de disciplinas
        try (BufferedReader br = new BufferedReader(new FileReader(pathDisciplinas))){
            String linha = br.readLine();
            while (linha != null){
                
                String[] vetor = linha.split(":");
                String codigo = vetor[0];
                Integer creditos = Integer.parseInt(vetor[1]);
                
                Disciplina disciplina = new Disciplina(codigo, creditos);
                disciplinas.add(disciplina);
                
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Ler o arquivo TXT de estudantes, cortar e adicionar na lista de estudantes
        try (BufferedReader br = new BufferedReader(new FileReader(pathEstudantes))){
            
            String linha = br.readLine();
            while (linha != null){
                
                String[] vetor = linha.split(":");
                Long id = Long.parseLong(vetor[0]);
                String nome = vetor[1];
                String email = vetor[2];
                
                Estudante estudante = new Estudante(id, nome, email);
                estudantes.add(estudante);
                
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
            
        // Ler o arquivo TXT de matriculas, cortar e adicionar na lista de matriculas
        try (BufferedReader br = new BufferedReader(new FileReader(pathMatriculas))){
            String linha = br.readLine();
            while (linha != null){
                String[] vetor = linha.split(":");
                int indEstudante = 0, indDisciplina = 0;
                
                for(Disciplina disciplina: disciplinas){
                    if(disciplina.getCodigo().equals(vetor[1]))
                         indDisciplina = disciplinas.indexOf(disciplina);
                }
                
                for(Estudante estudante: estudantes){
                    if(estudante.getId() == Long.parseLong(vetor[0]))
                        indEstudante = estudantes.indexOf(estudante);
                }
                
                Matricula matricula = new Matricula(estudantes.get(indEstudante),disciplinas.get(indDisciplina));
                disciplinas.get(indDisciplina).addMatricula(matricula);
                estudantes.get(indEstudante).addMatricula(matricula);
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    // Métodos especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
