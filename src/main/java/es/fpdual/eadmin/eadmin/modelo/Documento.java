package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

public class Documento extends ElementoBaseAdministracionElectronica {

	private final EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico);
		this.estado = estado;
	}

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion, Boolean publico,
			Integer estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico);

		
		switch (estado) {
		case 1:
			this.estado = EstadoDocumento.ACTIVO;
			break;
		case 2:
			this.estado = EstadoDocumento.APROBADO;
			break;
		case 3:
			this.estado = EstadoDocumento.ELIMINADO;
			break;
		default:
			this.estado = null;
			break;
		}

	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}

}
