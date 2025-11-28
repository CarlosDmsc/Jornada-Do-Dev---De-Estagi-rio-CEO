import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" Bem-vindo(a) à Jornada do Dev! Digite seu nome:");
        String nome = sc.nextLine();

        Desenvolvedor dev = new Desenvolvedor(nome);
        Carreira carreira = new Carreira(dev);

        int opcao = -1;

        while (opcao != 0) {

            dev.mostrarHUD();

            System.out.println("\n════════════ MENU DE AÇÕES ════════════");
            System.out.println("1 - Trabalhar em Projeto ");
            System.out.println("2 - Estudar ");
            System.out.println("3 - Tentar Subir de Cargo ");
            System.out.println("4 - Descansar ");
            System.out.println("5 - Ver Status Completo ");
            System.out.println("0 - Sair ");
            System.out.println("══════════════════════════════════════════");
            System.out.print(" Escolha: ");
            opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    dev.trabalharEmProjeto(carreira.gerarProjetoAleatorio());
                    break;

                case 2:
                    System.out.println("\n Como deseja estudar?");
                    System.out.println("1 - Leve (+8 XP / +2 cansaço)");
                    System.out.println("2 - Normal (+15 XP / +5 cansaço)");
                    System.out.println("3 - Intenso (+30 XP / +9 cansaço)");
                    int tipo = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Digite o nome da habilidade:");
                    String hab = sc.nextLine();

                    if (tipo == 1) dev.estudar(hab, "leve");
                    else if (tipo == 2) dev.estudar(hab, "normal");
                    else if (tipo == 3) dev.estudar(hab, "intenso");
                    else System.out.println(" Opção inválida!");
                    break;

                case 3:
                    try {
                        dev.subirDeCargo();
                    } catch (Exception e) {
                        System.out.println(" Você ainda não tem XP suficiente!");
                    }
                    break;

                case 4:
                    // descanso manual
                    try {
                        java.lang.reflect.Method desc = dev.getClass().getDeclaredMethod("descansarNormal");
                        desc.setAccessible(true);
                        desc.invoke(dev);
                    } catch (Exception e) {
                        System.out.println("Não foi possível descansar.");
                    }
                    break;

                case 5:
                    System.out.println("\n STATUS DO DESENVOLVEDOR ");
                    System.out.println(" Nome: " + nome);
                    System.out.println(" Cargo atual: " + dev.getNivel());
                    System.out.println(" XP atual: " + dev.getXP());
                    dev.mostrarHUD();
                    break;

                case 0:
                    System.out.println("\n Obrigado por jogar!");
                    Carreira.mostrarRelatorioFinal();
                    break;

                default:
                    System.out.println(" Opção inválida!");
                    break;
            }
        }

        sc.close();
    }
}
