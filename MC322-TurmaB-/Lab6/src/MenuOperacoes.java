
public enum MenuOperacoes{
    CADASTROS("Cadastros", new SubmenuOps[]{
                SubmenuOps.CADASTRAR_CLIENTE_PF,
                SubmenuOps.CADASTRAR_CLIENTE_PJ,
                SubmenuOps.CADASTRAR_SEGURADORA,
                SubmenuOps.CADASTRAR_VEICULO,
                SubmenuOps.CADASTRAR_CONDUTOR,
                SubmenuOps.VOLTAR
    }),
    LISTAR("Listar", new SubmenuOps[]{
                SubmenuOps.LISTAR_PF_SEGURADORA,
                SubmenuOps.LISTAR_PJ_SEGURADORA,
                SubmenuOps.SEGURO_SEGURADORA,
                SubmenuOps.LISTAR_SINISTRO_CONDUTOR,
                SubmenuOps.LISTAR_SINISTRO_SEGURO,
                SubmenuOps.LISTAR_CONDUTOR_SEGURO,
                SubmenuOps.LISTAR_FROTA_CLIENTEPJ,
                SubmenuOps.LISTAR_VEICULO_CLIENTEPF,
                SubmenuOps.LISTAR_SINISTRO_SEGURADORA,
                SubmenuOps.LISTAR_SINISTRO_CLIENTE,
                SubmenuOps.LISTAR_VEICULO_CLIENTE,
                SubmenuOps.LISTAR_VEICULO_SEGURADORA,
                SubmenuOps.VOLTAR
    }),
    EXCLUIR("Excluir", new SubmenuOps[]{
            SubmenuOps.EXCLUIR_CLIENTE,
            SubmenuOps.EXCLUIR_SEGURO,
            SubmenuOps.EXCLUIR_CONDUTOR,
            SubmenuOps.EXCLUIR_FROTA,
            SubmenuOps.EXCLUIR_VEICULO_FROTA,
            SubmenuOps.EXCLUIR_VEICULO_CLIENTEPF,
            SubmenuOps.EXCLUIR_SINISTRO,
            SubmenuOps.VOLTAR
    }),
    GERAR_SINISTRO("Gerar sinistro", new SubmenuOps[]{ SubmenuOps.VOLTAR }),
    GERAR_SEGUROPF("Gerar um seguro para pessoa física", new SubmenuOps[]{SubmenuOps.VOLTAR}),
    GERAR_SEGUROPJ("Gerar um seguro para pessoa jurídica", new SubmenuOps[]{SubmenuOps.VOLTAR}),
    CALCULAR("Calcular Receita Classes.Seguradora", new SubmenuOps[]{SubmenuOps.VOLTAR}),
    SAIR("Sair", new SubmenuOps[]{});
    public final String descricao;
    private final SubmenuOps[] submenu;
    MenuOperacoes(String descricao, SubmenuOps[] submenu) {
        this.descricao = descricao;
        this.submenu = submenu;
    }
    public String getDescricao(){
        return descricao;
    }

    public SubmenuOps[] getSubmenu(){
        return submenu;
    }
}


