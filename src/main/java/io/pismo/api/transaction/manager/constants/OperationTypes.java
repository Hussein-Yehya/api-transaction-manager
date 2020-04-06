package io.pismo.api.transaction.manager.constants;

import lombok.Getter;

@Getter
public enum OperationTypes {
	
	COMPRA_A_VISTA("COMPRA A VISTA"),
	COMPRA_PARCELADA("COMPRA PARCELADA"),
	SAQUE("SAQUE"),
	PAGAMENTO("PAGAMENTO");
	
	private String label;
	
	private OperationTypes(String label) {
		this.label = label;
	}
	
}
