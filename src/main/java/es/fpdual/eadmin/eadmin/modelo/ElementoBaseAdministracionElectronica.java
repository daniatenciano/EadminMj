package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract  class ElementoBaseAdministracionElectronica {
	
	protected final Integer codigo;
	protected final String nombre;
	protected final Date fechaCreacion;
	protected final Date fechaUltimaModificacion;
	protected final Boolean publico;
	
	public ElementoBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion, Boolean publico) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.publico = publico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}


	public Boolean getPublico() {
		return publico;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof ElementoBaseAdministracionElectronica) {
			final ElementoBaseAdministracionElectronica param = (ElementoBaseAdministracionElectronica)obj;
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.append(this.codigo, param.codigo);
			equalsBuilder.append(this.nombre, param.nombre);
			equalsBuilder.append(this.fechaCreacion, param.fechaCreacion);
			equalsBuilder.append(this.fechaUltimaModificacion, param.fechaUltimaModificacion);
			equalsBuilder.append(this.publico, param.publico);
			
			
			return equalsBuilder.isEquals();
		} 
		return false;
	}
	
	@Override
	public int hashCode() {
		final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		
		hashCodeBuilder.append(this.codigo);
		hashCodeBuilder.append(this.nombre);
		hashCodeBuilder.append(this.fechaCreacion);
		hashCodeBuilder.append(this.fechaUltimaModificacion);
		hashCodeBuilder.append(this.publico);
		
		return hashCodeBuilder.toHashCode();
	}
	
}
