import java.util.Scanner;
import models.Desenvolvedor;
import models.Carreira;
import models.SaveManager;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Desenvolvedor dev = null;
        Carreira carreira = null;

        while (true) {
            System.out.println("===============================");
            System.out.println("        JORNADA DO DEV");
            System.out.println("===============================");
            System.out.println("1 - Novo Jogo");
            System.out.println("2 - Continuar");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {

                case 1:
                    // Novo jogo
                    System.out.println("\nDigite o nome do desenvolvedor:");
                    String nome = sc.nextLine();

                    dev = new Desenvolvedor(nome);
                    carreira = new Carreira(dev);

                    System.out.println("\nNovo jogo iniciado!\n");
                    menuDoJogo(dev, carreira, sc);
                    break;

                case 2:
                    // Continuar
                    dev = SaveManager.carregarJogo();

                    if (dev == null) {
                        System.out.println("\nNenhum jogo salvo encontrado!\n");
                    } else {
                        carreira = new Carreira(dev);
                        System.out.println("\nJogo carregado com sucesso!\n");
                        menuDoJogo(dev, carreira, sc);
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
    }

    // ================================
    //   MENU INTERNO DO JOGO
    // ================================
    public static void menuDoJogo(Desenvolvedor dev, Carreira carreira, Scanner sc) {

        while (true) {

            System.out.println("\n===============================");
            System.out.println("        MENU DO JOGO");
            System.out.println("===============================");
            System.out.println("1 - Trabalhar em Projeto");
            System.out.println("2 - Estudar");
            System.out.println("3 - Subir de Cargo");
            System.out.println("4 - Descansar");
            System.out.println("5 - Mostrar Status");
            System.out.println("6 - Voltar ao Menu Principal");
            System.out.println("7 - Salvar Jogo");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {

                    case 1:
                        dev.trabalharEmProjeto(carreira.gerarProjetoAleatorio());
                        break;

                    case 2:
                        System.out.println("Modo de estudo (leve/normal/intenso): ");
                        String modo = sc.nextLine();
                        dev.estudar("Programação", modo);
                        break;

                    case 3:
                        dev.subirDeCargo();
                        break;

                    case 4:
                        dev.descansarNormal();
                        break;

                    case 5:
                        dev.mostrarHUD();
                        break;

                    case 6:
                        return; // volta ao menu principal

                    case 7:
                        SaveManager.salvarJogo(dev);
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

        sc.close();
    }
}


