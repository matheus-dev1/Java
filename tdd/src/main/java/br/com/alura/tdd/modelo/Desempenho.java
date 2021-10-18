package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	// Cada constante deve implementar este metodo.
	A_DESEJAR {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.03");
		}
	},
	BOM {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.15");
		}
	},
	OTIMO {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.2");
		}
	};
	
	// � um m�todo que n�o tem um corpo, ou seja, um m�todo n�o implementado.
	// Uma classe que cont�m um ou mais m�todos abstratos deve ser declarada // explicitamente como abstrata.
	// Essa classe, no entanto, pode ter m�todos concretos (n�o-abstratos).
	
	public abstract BigDecimal percentualReajuste();
}
