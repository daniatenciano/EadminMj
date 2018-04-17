package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Date;
import java.util.List;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class RepositorioDocumentoImplTest {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private RepositorioDocumentoImpl repositorioDocumento;
	private final Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
			FECHA_ULTIMA_MODIFICACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);

	private DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		this.mapper = mock(DocumentoMapper.class);

		this.repositorioDocumento = new RepositorioDocumentoImpl(this.mapper);
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		this.repositorioDocumento.altaDocumento(documento);

		verify(this.mapper).insertarDocumento(this.documento);

	}
	

	@Test
	public void deberiaModificarUnDocumento() {
		
		when(mapper.modificarDocumento(this.documento)).thenReturn(1);
		
		this.repositorioDocumento.modificarDocumento(this.documento);

		verify(this.mapper).modificarDocumento(this.documento);

	}
	

	@Test(expected = IllegalArgumentException.class)
	public void deberiaLanzarExcepcionSiIntentamosModificarUnDocumentoQueNoExiste() {
		when(this.mapper.modificarDocumento(this.documento)).thenReturn(0);
		this.repositorioDocumento.modificarDocumento(this.documento);

	}

	
	@Test
	public void deberiaEliminarUnDocumento() {

		this.repositorioDocumento.eliminarDocumento(this.documento.getCodigo());

		verify(this.mapper).eliminarDocumento(this.documento.getCodigo());
	}


	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		when(mapper.selectDocumento(this.documento.getCodigo())).thenReturn(this.documento);
		

		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(CODIGO_DOCUMENTO);

		assertThat(resultado, is(this.documento));

	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() throws Exception {
		
		//Declaracion
	
		List<Documento> todosLosDocumentos =  Arrays.asList(this.documento);
		
		//Entrenamiento

		when(this.mapper.seleccionarTodosLosDocumentos()).thenReturn(todosLosDocumentos);
		
		//Prueba
		final List<Documento> resultado = repositorioDocumento.obtenerTodosLosDocumentos();
		
		//Verificación
		assertThat(resultado, hasSize(1));
		assertThat(resultado, hasItem(this.documento));
		
		
	}
}
