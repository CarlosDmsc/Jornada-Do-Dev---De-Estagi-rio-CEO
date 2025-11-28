package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Desenvolvedor {

    private String nome;
    private String nivel;
    private int xp;
    private int cansaco = 0;
    private final int cansacoMaximo = 10;
    private int dias = 1;

    private ArrayList<String> habilidades;

    public Desenvolvedor(String nome) {
        this.nome = nome;
        this.nivel = "Estagiario";
        this.xp = 0;
        this.habilidades = new ArrayList<>();
    }

    public void forcarAumentoCansaco(int valor) {
        cansaco += valor;
        if (cansaco > cansacoMaximo) cansaco = cansacoMaximo;
    }

    public void forcarAumentoDias(int valor) {
        dias += valor;
    }


    public void trabalharEmProjeto(Projeto projeto) {
    verificarCansaco();
    projeto.concluirProjeto(this);

    // Chance de 20% de desafio
    Random r = new Random();
    int chance = r.nextInt(100);

    if (chance < 20) {
        Desafio d = gerarDesafioAleatorio();
        d.aplicarConsequencia(this);
    }

    aumentarCansaco(projeto.getDificuldade() * 2);
    passarDia();
    mostrarHUD();
}

    private Desafio gerarDesafioAleatorio() {
    Random r = new Random();
    int n = r.nextInt(4);

    switch (n) {
        case 0:
            return new Desafio("Bug crítico no deploy", 15, 3, 1);
        case 1:
            return new Desafio("Servidor instável", 10, 2, 1);
        case 2:
            return new Desafio("Computador travou", 5, 1, 0);
        default:
            return new Desafio("Cliente mudou requisitos", 20, 4, 1);
    }
}


    public void estudar(String habilidade, String modo) {
        verificarCansaco();
        habilidades.add(habilidade);

        switch (modo.toLowerCase()) {
            case "leve":
                xp += 8;
                aumentarCansaco(2);
                System.out.println("Estudo leve realizado: " + habilidade + " (+8 XP)");
                break;

            case "normal":
                xp += 15;
                aumentarCansaco(5);
                System.out.println("Estudo normal realizado: " + habilidade + " (+15 XP)");
                break;

            case "intenso":
                xp += 30;
                aumentarCansaco(9);
                System.out.println("Estudo intenso realizado: " + habilidade + " (+30 XP)");
                break;

            default:
                System.out.println("Modo de estudo invalido.");
                return;
        }

        passarDia();
        mostrarHUD();
    }

    private void verificarCansaco() {
        if (cansaco >= cansacoMaximo) {
            System.out.println("\nO limite de cansaco foi atingido.");
            System.out.println("1 - Descansar");
            System.out.println("2 - Jogar Clash Royale (35% vitoria, 65% derrota)");

            Scanner sc = new Scanner(System.in);
            int escolha = sc.nextInt();

            if (escolha == 1) descansarNormal();
            else if (escolha == 2) jogarClashRoyale();
            else {
                System.out.println("Opcao invalida. Descanso aplicado.");
                descansarNormal();
            }
        }
    }

    private void descansarNormal() {
        cansaco = 0;
        dias++;
        System.out.println("Desenvolvedor descansou.");
        mostrarHUD();
    }

    private void jogarClashRoyale() {
        Random r = new Random();
        int chance = r.nextInt(100);

        if (chance < 35) {
            System.out.println("Vitoria no Clash Royale. Cansaco zerado e dia mantido.");
            cansaco = 0;
        } else {
            System.out.println("Derrota no Clash Royale. Uma penalidade foi aplicada.");
            cansaco = 0;
            dias++;
            xp -= 50;
            if (xp < 0) xp = 0;
        }

        mostrarHUD();
    }

    private void aumentarCansaco(int valor) {
        cansaco += valor;
    }

    private void passarDia() {
        dias++;
    }

    public void subirDeCargo() {
        int necessario = xpNecessario();

        if (xp < necessario) {
            System.out.println("XP insuficiente. Necessario: " + necessario);
            return;
        }

        switch (nivel) {
            case "Estagiario": nivel = "Junior"; break;
            case "Junior": nivel = "Pleno"; break;
            case "Pleno": nivel = "Senior"; break;
            case "Senior": nivel = "CEO"; break;
            default:
                System.out.println("Cargo maximo atingido.");
                return;
        }

        System.out.println("Promocao realizada. Novo cargo: " + nivel);
        Carreira.registrarProgresso(nivel, dias);
    }

    public int xpNecessario() {
        switch (nivel) {
            case "Estagiario": return 100;
            case "Junior": return 200;
            case "Pleno": return 350;
            case "Senior": return 500;
            default: return Integer.MAX_VALUE;
        }
    }

    public void mostrarHUD() {
        System.out.println("\n-------------------------------------------------");
        System.out.println("Status do Desenvolvedor");
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + nivel);
        System.out.println("XP: " + xp + " / " + xpNecessario());
        System.out.println("Cansaco: " + cansaco + "/" + cansacoMaximo);
        System.out.println("Dias: " + dias);
        System.out.println("-------------------------------------------------");
    }

    public int getXP() { return xp; }
    public void adicionarXP(int valor) { xp += valor; }
    public String getNivel() { return nivel; }
}
