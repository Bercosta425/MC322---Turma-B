
public enum MenuOperacoes{
    CADASTROS("Cadastros", new SubmenuOps[]{
                SubmenuOps.CADASTRAR_CLIENTE_PF,
                SubmenuOps.CADASTRAR_CLIENTE_PJ,
                SubmenuOps.CADASTRAR_SEGURADORA,
                SubmenuOps.CADASTRAR_VEICULO,
                SubmenuOps.VOLTAR
    }),
    LISTAR("Listar", new SubmenuOps[]{
                SubmenuOps.LISTAR_PF_SEGURADORA,
                SubmenuOps.LISTAR_PJ_SEGURADORA,
                SubmenuOps.LISTAR_SINISTRO_SEGURADORA,
                SubmenuOps.LISTAR_SINISTRO_CLIENTE,
                SubmenuOps.LISTAR_VEICULO_CLIENTE,
                SubmenuOps.LISTAR_VEICULO_SEGURADORA,
                SubmenuOps.VOLTAR
    }),
    EXCLUIR("Excluir", new SubmenuOps[]{
            SubmenuOps.EXCLUIR_CLIENTE,
            SubmenuOps.EXCLUIR_VEICULO,
            SubmenuOps.EXCLUIR_SINISTRO,
            SubmenuOps.VOLTAR
    }),
    GERAR_SINISTRO("Gerar sinistro", new SubmenuOps[]{ SubmenuOps.VOLTAR }),
    TRANSFERIR("Transferir seguro", new SubmenuOps[]{ SubmenuOps.VOLTAR }),
    CALCULAR("Calcular Receita Seguradora", new SubmenuOps[]{SubmenuOps.VOLTAR}),
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


