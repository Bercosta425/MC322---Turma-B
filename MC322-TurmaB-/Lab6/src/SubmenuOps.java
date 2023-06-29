public enum SubmenuOps {
    CADASTRAR_CLIENTE_PF("Cadastrar cliente PF"),
    CADASTRAR_CLIENTE_PJ("Cadastrar cliente PJ"),
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradora"),
    CADASTRAR_CONDUTOR("Cadastrar Classes.Condutor"),


    LISTAR_PF_SEGURADORA("Listar Classes.Cliente PF por Seg."),
    LISTAR_PJ_SEGURADORA("Listar Classes.Cliente PJ por Seg."),
    LISTAR_SINISTRO_SEGURADORA("Listar Sinistros por Seg."),
    SEGURO_SEGURADORA("Listar seguro por seguradora"),
    LISTAR_SINISTRO_CONDUTOR("Listar sinistro por condutor"),
    LISTAR_SINISTRO_SEGURO("Listar sinistro por seguro"),
    LISTAR_CONDUTOR_SEGURO("Listar condutor por seguro"),
    LISTAR_FROTA_CLIENTEPJ("Listar frota por cliente de pessoa jurídica"),
    LISTAR_VEICULO_CLIENTEPF("Listar veiuclo por cliente de pessoa física"),
    LISTAR_SINISTRO_CLIENTE("Listar sinistro por cliente"),
    LISTAR_VEICULO_CLIENTE("Listar veiculo por cliente"),
    LISTAR_VEICULO_SEGURADORA("Listar veiculo por Seg."),


    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO_FROTA("Excluir veiculo de frota"),
    EXCLUIR_VEICULO_CLIENTEPF("Excluir veiculo de cliente PF"),
    EXCLUIR_SEGURO("Excluir seguro"),
    EXCLUIR_CONDUTOR("Excluir condutor"),
    EXCLUIR_FROTA("Excluir frota"),
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
