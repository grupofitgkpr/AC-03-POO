/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote_Fonte_v1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PedroHODL
 */
public class GestaoAcademicaApp1 {
    public static void main(String[] args) {
        
        Faculdade faculdade = new Faculdade("Faculdade Fictícia");
        faculdade.carregarDadosArquivo("disciplinas-acbeccedae.txt",
                                       "estudantes-acbeccedae.txt",
                                       "matriculas-acbeccedae.txt");
        while (true) {
            System.out.println("-------- Menu --------");
            Scanner input = new Scanner(System.in);
            System.out.println("[0] Encerrar programa\n"
                              +"[1] Lista de todos os estudantes\n"
                              +"[2] Lista de todas as disciplinas\n"
                              +"[3] Estudantes matriculados em X disciplina\n"
                              +"[4] Disciplinas matriculadas em X aluno\n"
                              +"Digite a opção desejada:");
            int opc = input.nextInt();
            
            switch (opc){
                case 0:
                    System.out.println("----- Fim do Programa -----");
                    System.exit(-1);
                    break;
                case 1:
                    listDeEstudantes(faculdade.getEstudantes());
                    break;
                case 2:
                    codDaDisciplina(faculdade.getDisciplinas());
                    break;
                case 3:
                    listarEstDisc(faculdade.getDisciplinas());
                    break;
                case 4:
                    listarDiscEst(faculdade.getEstudantes());
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println("");
        }
    }

    private static void listDeEstudantes(ArrayList<Estudante> estudantes) {
        System.out.println("\n--- Lista de estudantes ---");
        for (Estudante estudante : estudantes)
            System.out.println("Id: " + estudante.getId() + " | Nome: "+ estudante.getNome());
    }

    private static void codDaDisciplina(ArrayList<Disciplina> disciplinas) {
        System.out.println("\n--- Lista de Disciplinas ---");
        for (Disciplina disciplina : disciplinas)
            System.out.println("Disciplina: " + disciplina.getCodigo());
    }

    private static void listarEstDisc(ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o código da disciplina: ");
        String opc = input.nextLine();
        
        Disciplina disciplina = findDisciplinaByCodigo(opc, disciplinas);
        
        ArrayList<Estudante> estudantes = disciplina.getEstudantesMatriculados();
        System.out.println("\n--- Lista de alunos da disciplina: " + disciplina.getCodigo() + " ---");
        for (Estudante estudante : estudantes)
            System.out.println("Id: " + estudante.getId() + " | Nome: "+ estudante.getNome() + " | Email: " + estudante.getEmail());
        
        System.out.println("\nTotal de alunos: " + estudantes.size());
    }

    private static void listarDiscEst(ArrayList<Estudante> estudantes) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o id do aluno: ");
        int opc = input.nextInt();
        
        Estudante estudante = findEstudanteById(opc, estudantes);
        
        ArrayList<Disciplina> disciplinas = estudante.getDisciplinasMatriculadas();
        System.out.println("\n--- Lista de Disciplinas do aluno: " + estudante.getNome() + " ---");
        for (Disciplina disciplina : disciplinas)
            System.out.println("Disciplina: " + disciplina.getCodigo() + " | Créditos: " + disciplina.getCreditos());
    }
    
    private static Estudante findEstudanteById(int id, ArrayList<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (id == estudante.getId()) {
                return estudante; //estudante encontrado
            }
        }
        return null; //estudante não encontrado
    }

    private static Disciplina findDisciplinaByCodigo(String codigo, ArrayList<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
            if (codigo.equals(disciplina.getCodigo())) {
                return disciplina;//disciplina encontrada
            }
        }
        return null;//disciplina não encontrada
    }
    
}
