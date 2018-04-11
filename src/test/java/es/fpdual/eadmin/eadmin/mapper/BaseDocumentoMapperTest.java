package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;


public abstract class BaseDocumentoMapperTest {

	private Documento documento1;

	@Autowired
	private DocumentoMapper mapper;
	private Date fecha = new Date();

	@Before
	public void deberiaInicializarEnCadaTest() {
		documento1 = new Documento(1, "documento1", fecha, fecha, true, EstadoDocumento.APROBADO);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {

		// DECLARACION

		// ENTRENAMIENTO

		// EJECUCION
		final int resultado = this.mapper.insertarDocumento(this.documento1);

		// VERIFICACION
		assertThat(resultado, is(1));

	}
}
