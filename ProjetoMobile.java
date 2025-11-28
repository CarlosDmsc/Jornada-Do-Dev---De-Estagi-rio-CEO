package models;

public class ProjetoMobile extends Projeto {

    public ProjetoMobile() {
        super("Projeto Mobile", 3, 70);
    }

    @Override
    public void concluirProjeto(Desenvolvedor dev) {
        dev.adicionarXP(recompensaXP);
        System.out.println("Projeto Mobile concluido. +" + recompensaXP + " XP");
    }
}
