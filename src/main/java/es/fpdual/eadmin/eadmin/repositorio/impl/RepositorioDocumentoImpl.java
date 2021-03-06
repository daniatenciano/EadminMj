package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private DocumentoMapper mapper;

	private Documento documentos;

	@Autowired
	public RepositorioDocumentoImpl(DocumentoMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void altaDocumento(Documento documento) {
		
		this.mapper.insertarDocumento(documento);
			
			
//		if (documentos.contains(documento)) {
//			throw new IllegalArgumentException("El documento ya existe");
//		}
//		
//		documentos.add(documento);
		
		
	}

	@Override
	public void modificarDocumento(Documento documento) {

		final int modificado = this.mapper.modificarDocumento(documento);
		
		if(modificado == 0) {
			throw new IllegalArgumentException("No se encuentra el documento");
		}
	
	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		this.mapper.eliminarDocumento(codigo);
	}

	
	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		
		return this.mapper.selectDocumento(codigo);
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.mapper.seleccionarTodosLosDocumentos();
	}


}