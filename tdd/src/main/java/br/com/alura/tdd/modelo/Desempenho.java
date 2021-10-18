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
	
	// É um método que não tem um corpo, ou seja, um método não implementado.
	// Uma classe que contém um ou mais métodos abstratos deve ser declarada // explicitamente como abstrata.
	// Essa classe, no entanto, pode ter métodos concretos (não-abstratos).
	
	public abstract BigDecimal percentualReajuste();
}
