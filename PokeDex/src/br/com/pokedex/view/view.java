package br.com.pokedex.view;

import java.util.Scanner;

public class view {

    public void cabecalho(){
        System.out.println("-------------------------");
        System.out.println("|        PokeDex        |");
        System.out.println("-------------------------");
    }

    public void enunciado(){
        System.out.println("Seja bem vindo a PokeDex");
        System.out.println("Digite o numero do pokemon que vc deseja");
        System.out.println("E veja seus atributos");
    }

    public int infoUsuario(){
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        System.out.println("Escreva o numero do pokemon Desejado");
        x = scanner.nextInt();

        if (x > 150 || x < 0) {
            do {
                System.out.println("Numero digitado não tem nenhum pokemon");
                System.out.println( "Digite novamente:");
                x = scanner.nextInt();    
            } while (x > 150 || x < 0);
            
        }
        return x;
    }
}
