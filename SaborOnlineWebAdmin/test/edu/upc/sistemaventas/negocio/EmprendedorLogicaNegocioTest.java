/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.utils.BusinessException;
import java.text.SimpleDateFormat;
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
public class EmprendedorLogicaNegocioTest {

  public EmprendedorLogicaNegocioTest() {
    
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
   * Test of buscarEmprendedor method, of class EmprendedorLogicaNegocio.
   */
  @Test
  public void testBuscarEmprendedor() {
    System.out.println("buscarEmprendedor");
    int idEmprendedor = 4;
    EmprendedorLogicaNegocio instance = new EmprendedorLogicaNegocio();
    EmprendedorDomain expResult = new EmprendedorDomain();
    expResult.setCorreo("mauriciofernandini@yahoo.es");
    EmprendedorDomain result = instance.buscarEmprendedor(idEmprendedor);
    assertEquals(expResult.getCorreo(), result.getCorreo());
  }

  /**
   * Test of registrarEmprendedor method, of class EmprendedorLogicaNegocio.
   */
  @Test
  public void testRegistrarEmprendedorOk() throws BusinessException, Exception {
    System.out.println("registrarEmprendedorOk");
    EmprendedorDomain emprendedor = new EmprendedorDomain();
    emprendedor.setApellidoPaterno("Pajuelo");
    emprendedor.setApellidoMaterno("Rubina");
    emprendedor.setNombres("Edgar");
    emprendedor.setCelular("987654321");
    emprendedor.setClave("123");
    emprendedor.setCorreo("edgar.pajuelo@gmail.com");
    emprendedor.setDireccion("Calle de Prueba 123 - Lince");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    emprendedor.setFechaNacimiento(sdf.parse("22/04/1980"));
    emprendedor.setNumeroDocumentoIdentidad("40503794");
    emprendedor.setTipoDocumentoIdentidad("1");
    emprendedor.setSexo("M");
    EmprendedorLogicaNegocio instance = new EmprendedorLogicaNegocio();
    instance.eliminarEmprendedorByCorreo(emprendedor.getCorreo());
    int unexpResult = -1;
    int result = instance.registrarEmprendedor(emprendedor);
    assertNotSame(unexpResult, result);
  }

  /**
   * Test of registrarEmprendedor method, of class EmprendedorLogicaNegocio.
   */
  @Test(expected=BusinessException.class)
  public void testRegistrarEmprendedorError() throws BusinessException, Exception {
    System.out.println("registrarEmprendedorError");
    EmprendedorDomain emprendedor = new EmprendedorDomain();
    emprendedor.setApellidoPaterno("Mestanza");
    emprendedor.setApellidoMaterno("Contreras");
    emprendedor.setNombres("Luz Maria");
    emprendedor.setCelular("789789876");
    emprendedor.setClave("444");
    emprendedor.setCorreo("luz.mestanza@gmail.com");
    emprendedor.setDireccion("Av. Bertello 1123 - Callao");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    emprendedor.setFechaNacimiento(sdf.parse("12/01/1981"));
    emprendedor.setNumeroDocumentoIdentidad("23456789");
    emprendedor.setTipoDocumentoIdentidad("1");
    emprendedor.setSexo("F");
    EmprendedorLogicaNegocio instance = new EmprendedorLogicaNegocio();
    int unexpResult = -1;
    int result = instance.registrarEmprendedor(emprendedor);
    assertNotSame(unexpResult, result);
  }
  
  /**
   * Test of actualizarEmprendedor method, of class EmprendedorLogicaNegocio.
   */
  @Test
  public void testActualizarEmprendedor() throws BusinessException, Exception {
    System.out.println("actualizarEmprendedor");
    EmprendedorDomain emprendedor = new EmprendedorDomain();
    emprendedor.setApellidoPaterno("Pajuelo");
    emprendedor.setApellidoMaterno("Rubina");
    emprendedor.setNombres("Edgar");
    emprendedor.setCelular("987654321");
    emprendedor.setClave("123");
    emprendedor.setCorreo("edgar.pajuelo@gmail.com");
    emprendedor.setDireccion("Calle de Prueba 123 - Lince");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    emprendedor.setFechaNacimiento(sdf.parse("22/04/1980"));
    emprendedor.setNumeroDocumentoIdentidad("40503794");
    emprendedor.setTipoDocumentoIdentidad("1");
    emprendedor.setSexo("M");
    EmprendedorLogicaNegocio instance = new EmprendedorLogicaNegocio();
    instance.actualizarEmprendedor(emprendedor);
  }

//  /**
//   * Test of eliminarEmprendedor method, of class EmprendedorLogicaNegocio.
//   */
//  @Test
//  public void testEliminarEmprendedor() {
//    System.out.println("eliminarEmprendedor");
//    int idEmprendedor = 0;
//    EmprendedorLogicaNegocio instance = new EmprendedorLogicaNegocio();
//    instance.eliminarEmprendedor(idEmprendedor);
//  }
  
}
