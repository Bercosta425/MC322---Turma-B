package pacote;

public enum SubmenuOps {
    CADASTRAR_CLIENTE_PF("Cadastrar cliente PF"),
    CADASTRAR_CLIENTE_PJ("Cadastrar cliente PJ"),
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradora"),


    LISTAR_PF_SEGURADORA("Listar Cliente PF por Seg."),
    LISTAR_PJ_SEGURADORA("Listar Cliente PJ por Seg."),
    LISTAR_SINISTRO_SEGURADORA("Listar Sinistros por Seg."),
    LISTAR_SINISTRO_CLIENTE("Listar sinistro por cliente"),
    LISTAR_VEICULO_CLIENTE("Listar veiculo por cliente"),
    LISTAR_VEICULO_SEGURADORA("Listar veiculo por Seg."),


    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO("Excluir veiculo"),
    EXCLUIR_SINISTRO("Excluir sinistro"),

    VOLTAR("Voltar");

    private final String descricao;

    SubmenuOps(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
