package es.fpdual.eadmin.eadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {
	
	int insertarDocumento(@Param("documento") Documento documento);
	
	int eliminarDocumento(@Param("codigo") int codigo);
	
	int actualizarDocumento(@Param("documento") Documento documento1);
	
	Documento selectDocumento(@Param("codigo") int codigo);
	
	boolean contains(DocumentoMapper mapper);
	
	int modificarDocumento(@Param("codigo") Documento documento);
	
	List<Documento> seleccionarTodosLosDocumentos();
			
	
}
