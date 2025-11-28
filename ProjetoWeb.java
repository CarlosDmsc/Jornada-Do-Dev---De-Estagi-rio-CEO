package models;

public class ProjetoWeb extends Projeto {
    public ProjetoWeb() {
        super("Site Responsivo", 2, 50);
    }

    @Override
    public void concluirProjeto(Desenvolvedor dev) {
        dev.adicionarXP(recompensaXP);
        System.out.println(" Projeto Web concluído! +" + recompensaXP + " XP");
    }
}
