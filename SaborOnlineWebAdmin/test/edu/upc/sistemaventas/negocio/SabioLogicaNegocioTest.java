/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.SabioDomain;
import edu.upc.sistemaventas.utils.BusinessException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardocortijo
 */
public class SabioLogicaNegocioTest {

  public SabioLogicaNegocioTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }
  
  /**
   * Test of registrarSabio method, of class SabioLogicaNegocio.
   */
  @Test
  public void testRegistrarSabioOk() throws BusinessException, Exception {
    System.out.println("registrarSabioOk");
    SabioDomain sabio = new SabioDomain();
    sabio.setApellidoPaterno("Guerra");
    sabio.setApellidoMaterno("Taipe");
    sabio.setNombres("Jorge");
    sabio.setCelular("879098897");
    sabio.setClave("xyz");
    sabio.setCorreo("jguerra@sbs.gob.pe");
    sabio.setDireccion("Jr. Los Jaspes 451 - San Juan de Lurigancho");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sabio.setFechaNacimiento(sdf.parse("19/08/1988"));
    sabio.setNumeroDocumentoIdentidad("44444444");
    sabio.setTipoDocumentoIdentidad("1");
    sabio.setSexo("M");
    sabio.setApelativo("jorgito_guerra");
    sabio.setResumenAutobiografico("Profesional con amplia experiencia laboral en la SBS.");
    sabio.setSitioWeb("http://jorgitoguerra.name");
    SabioLogicaNegocio instance = new SabioLogicaNegocio();
    instance.eliminarSabioByCorreo(sabio.getCorreo());
    int expResult = -1;
    int result = instance.registrarSabio(sabio);
    assertNotSame(expResult, result);
  }

  /**
   * Test of registrarSabio method, of class SabioLogicaNegocio.
   */
  @Test(expected=BusinessException.class)
  public void testRegistrarSabioError() throws BusinessException, Exception {
    System.out.println("registrarSabioError");
    SabioDomain sabio = new SabioDomain();
    sabio.setApellidoPaterno("Rodriguez");
    sabio.setApellidoMaterno("Condezo");
    sabio.setNombres("David");
    sabio.setCelular("988111222");
    sabio.setClave("abc");
    sabio.setCorreo("david.condezo@outlook.com");
    sabio.setDireccion("Av. de la Peruanidad 456 - Surco");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sabio.setFechaNacimiento(sdf.parse("22/04/1972"));
    sabio.setNumeroDocumentoIdentidad("12345678");
    sabio.setTipoDocumentoIdentidad("1");
    sabio.setSexo("M");
    sabio.setApelativo("the_david_wisdom");
    sabio.setResumenAutobiografico("Profesional con amplia experiencia laboral en la UPC.");
    sabio.setSitioWeb("http://davidcondezo.blogspot.com");
    SabioLogicaNegocio instance = new SabioLogicaNegocio();
    int expResult = -1;
    int result = instance.registrarSabio(sabio);
    assertNotSame(expResult, result);
  }

  /**
   * Test of obtenerPlanesNegocioPorSabio method, of class SabioLogicaNegocio.
   */
  @Test
  public void testObtenerPlanesNegocioPorSabio() {
    System.out.println("obtenerPlanesNegocioPorSabio");
    int idSabio = 1;
    SabioLogicaNegocio instance = new SabioLogicaNegocio();
    int expResult = 2;
    List result = instance.obtenerPlanesNegocioPorSabio(idSabio);
    assertEquals(expResult, result.size());
  }
  
}
