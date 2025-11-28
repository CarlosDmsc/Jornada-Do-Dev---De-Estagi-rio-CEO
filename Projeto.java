package models;

public abstract class Projeto {

    protected String nome;
    protected int dificuldade;
    protected int recompensaXP;

    public Projeto(String nome, int dificuldade, int recompensaXP) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.recompensaXP = recompensaXP;
    }

    public abstract void concluirProjeto(Desenvolvedor dev);

    public int getDificuldade() {
        return dificuldade;
    }
}
