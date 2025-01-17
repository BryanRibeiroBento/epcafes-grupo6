package com.epcafes.model.enums;

public enum TipoMaquina {

    ABANADOR_CEREAL("ABANADOR_CEREAL"),
    ADUBADORA_AUTOPROPELIDA("ADUBADORA_AUTOPROPELIDA"),
    APLICADOR_AUTOPROPELIDO("APLICADOR_AUTOPROPELIDO"),
    ATOMIZADOR_COSTAL_MOTORIZADO("ATOMIZADOR_COSTAL_MOTORIZADO"),
    CAMINHAO("CAMINHÃO"),
    COLHEDORA_AUTOMOTRIZ_CAFE("COLHEDORA_AUTOMOTRIZ_CAFE"),
    COLHEDORA_CAFE("COLHEDORA_CAFE"),
    MICROTRATOR("MICROTRATOR"),
    MOTORROÇADEIRA("MOTORROÇADEIRA"),
    PA_CARREGADEIRA("PA_CARREGADEIRA"),
    PULVERIZADOR("PULVERIZADOR"),
    ROÇADEIRA_MANUAL("ROÇADEIRA_MANUAL"),
    SOPRADOR("SOPRADOR"),
    TRATOR("TRATOR"),
    TRATOR_DE_RODA_PEQUENO_PORTE("TRATOR_DE_RODA_PEQUENO_PORTE"),
    TRITURADOR("TRITURADOR"),
    OUTROS("OUTROS");

    private final String tipoMaquinaCode;

    private TipoMaquina(String tipoMaquinaCode) {
        this.tipoMaquinaCode = tipoMaquinaCode;

    }

    public String getTipoMaquinaCode() {
        return tipoMaquinaCode;
    }

}
