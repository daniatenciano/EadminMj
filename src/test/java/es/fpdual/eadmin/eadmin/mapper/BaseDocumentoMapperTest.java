package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.util.Utilidades;


@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	private Documento documento1;

	@Autowired
	private DocumentoMapper mapper;


	@Before
	public void deberiaInicializarEnCadaTest() {
		documento1 = new Documento(1, "documento1",Utilidades.asDate(LocalDate.of(2015, 1, 5)),Utilidades.asDate(LocalDate.of(2015, 5, 2)), true, EstadoDocumento.APROBADO);
	}
	
	@Test
	public void deberiaInsertarUnDocumento() throws Exception {

		// DECLARACION

		// ENTRENAMIENTO

		// EJECUCION
		final int documento = this.mapper.insertarDocumento(documento1);

		// VERIFICACION
		assertThat(documento, is(1));

	}

	
	@Test
	public void deberiaEliminarDocumento() throws Exception {
				
				// DECLARACION

				// ENTRENAMIENTO
		 	this.mapper.insertarDocumento(documento1);
				// EJECUCION
			   
				final int resultado = this.mapper.eliminarDocumento(1); 

				// VERIFICACION
				assertThat(resultado, is(1));
			
	}
	
	@Test
	public void deberiaActualizarTodosLosCamposDeUnDocumento() throws Exception {
		// DECLARACION
		Documento documentoActualizado = new Documento(1, "documento mod", Utilidades.asDate(LocalDate.of(2015, 11, 13)),
				Utilidades.asDate(LocalDate.of(2015, 1, 29)), true, EstadoDocumento.ACTIVO);
		// ENTRENAMIENTO

		// EJECUCION
		 this.mapper.insertarDocumento(this.documento1);
		final int resultado = this.mapper.actualizarDocumento(documentoActualizado); 
		
		// VERIFICACION
		assertThat(resultado, is(1));
		final Documento documentoModificado = this.mapper.selectDocumento(1);
		assertThat(documentoModificado, is(documentoActualizado));
	}
	

	
//	@Test
//	public void deberiaRecuperarDocumentoPorCodigo() throws Exception {
//		
//	}
	
		
	@Test
	public void deberiaSeleccionarDocumento() throws Exception  {
		// DECLARACION
		Documento docume;
		// ENTRENAMIENTO
		 this.mapper.insertarDocumento(documento1);
		// EJECUCION
		
		docume = mapper.selectDocumento(1); 

		// VERIFICACION
		assertThat(docume, is(documento1));

	}

}
