package es.fpdual.eadmin.eadmin.modelo;

import org.assertj.core.util.Arrays;

public enum EstadoDocumento {
	
	ACTIVO(1), APROBADO(2), ELIMINADO(3);
	//public static final EstadoDocumento ACTIVO = new EstadoDocumento(1);

	private final int codigo;
	
	private EstadoDocumento(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
//	public static EstadoDocumento obtenerCodigo(Integer codigo) {
//		return Arrays.asList(EstadoDocumento.values()).stream()
//		.filter(codigoLista ->codigoLista.getCodigo() == codigo.intValue()).findAny().orElse(null);
//	}
	
	
}
