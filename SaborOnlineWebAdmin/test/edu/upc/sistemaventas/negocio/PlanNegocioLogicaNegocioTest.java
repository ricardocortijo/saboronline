/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.*;
import edu.upc.sistemaventas.utils.BusinessException;
import edu.upc.sistemaventas.utils.Parametros;
import java.math.BigDecimal;
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
public class PlanNegocioLogicaNegocioTest {

  public PlanNegocioLogicaNegocioTest() {
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
   * Test of registrarPlanNegocio method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testRegistrarPlanNegocio() throws BusinessException, Exception {
    System.out.println("registrarPlanNegocio");
    PlanNegocioDomain planNegocio = new PlanNegocioDomain();
    planNegocio.setTitulo("Plan de Negocio No. 1");
    CategoriaDomain categoria = new CategoriaDomain();
    categoria.setId(1);
    categoria.setNombreCategoria("Agricultura");
    planNegocio.setCategoria(categoria);
    DocumentoDomain documento = new DocumentoDomain();
    documento.setId(1);
    documento.setNombreDocumento("Documento de Resumen del Plan de Negocio 001");
    planNegocio.setDocumento(documento);
    planNegocio.setVisionNegocio("Este plan es lo maximo!");
    planNegocio.setRazonamientosPropuesta("Se basa en las leyes del gobierno");
    planNegocio.setTiempoEjecucion(40f);
    planNegocio.setInversionTotal(new BigDecimal(500000));
    planNegocio.setMargenNeto(new BigDecimal(100000));
    planNegocio.setRoi(new BigDecimal(300000));
    planNegocio.setFlagViable("S");
    planNegocio.setEstadoPlanNegocio(Parametros.PLAN_PROYECTO_INICIADO);
    SabioLogicaNegocio sabioPlanNegocio = new SabioLogicaNegocio();
    SabioDomain sabio = sabioPlanNegocio.buscarSabio(2);
    planNegocio.setSabio(sabio);
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int unexpResult = -1;
    int result = instance.registrarPlanNegocio(planNegocio);
    assertNotSame(unexpResult, result);
  }

  /**
   * Test of validarPublicacionPlanNegocio method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testValidarPublicacionPlanNegocio() {
    System.out.println("validarPublicacionPlanNegocio");
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int idPlanNegocio = 2;
    boolean esAprobado = true;
    String mensajeFinal = "El proyecto es viable por completo.";
    boolean expResult = true;
    boolean result = instance.validarPublicacionPlanNegocio(idPlanNegocio, esAprobado, mensajeFinal);
    assertEquals(expResult, result);
  }

  /**
   * Test of buscarPlanesNegocio method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testBuscarPlanesNegocio() {
    System.out.println("buscarPlanesNegocio");
    String criterioBusqueda = "Industrial";
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int expResult = 1;
    List result = instance.buscarPlanesNegocio(criterioBusqueda);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of buscarPlanesNegocioPorTiempoEjecucion method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testBuscarPlanesNegocioPorTiempoEjecucion() {
    System.out.println("buscarPlanesNegocioPorTiempoEjecucion");
    float tiempoEjecucionDesde = 80.0F;
    float tiempoEjecucionHasta = 100.0F;
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int expResult = 3;
    List result = instance.buscarPlanesNegocioPorTiempoEjecucion(tiempoEjecucionDesde, tiempoEjecucionHasta);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of buscarPlanesNegocioPorInversionTotal method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testBuscarPlanesNegocioPorInversionTotal() {
    System.out.println("buscarPlanesNegocioPorInversionTotal");
    BigDecimal inversionTotalDesde = new BigDecimal(900000);
    BigDecimal inversionTotalHasta = new BigDecimal(1000000);
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int expResult = 1;
    List result = instance.buscarPlanesNegocioPorInversionTotal(inversionTotalDesde, inversionTotalHasta);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of buscarPlanesNegocioPorMargenNeto method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testBuscarPlanesNegocioPorMargenNeto() {
    System.out.println("buscarPlanesNegocioPorMargenNeto");
    BigDecimal margenNetoDesde = new BigDecimal(80000);
    BigDecimal margenNetoHasta = new BigDecimal(85000);
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int expResult = 2;
    List result = instance.buscarPlanesNegocioPorMargenNeto(margenNetoDesde, margenNetoHasta);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of buscarPlanesNegocioPorROI method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testBuscarPlanesNegocioPorROI() {
    System.out.println("buscarPlanesNegocioPorROI");
    BigDecimal roiDesde = new BigDecimal(200000);
    BigDecimal roiHasta = new BigDecimal(220000);
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    int expResult = 1;
    List result = instance.buscarPlanesNegocioPorROI(roiDesde, roiHasta);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of registrarPreguntaPlanNegocio method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testRegistrarPreguntaPlanNegocio() {
    System.out.println("registrarPreguntaPlanNegocio");
    int idPlanNegocio = 10;
    PreguntaDomain pregunta = new PreguntaDomain();
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    PlanNegocioDomain planNegocio = instance.getPlanNegocio(idPlanNegocio);
    pregunta.setPlanNegocio(planNegocio);
    pregunta.setTitulo("¿Se ha analizado el analisis de factibilidad social?");
    pregunta.setDescripcion("Por favor explique brevemente si se han encontrado indicios negativos en el proyecto con la comunidad");
    pregunta.setEstadoPregunta("R");
    pregunta.setRespuesta(null);
    int expResult = -1;
    int result = instance.registrarPreguntaPlanNegocio(idPlanNegocio, pregunta);
    assertNotSame(expResult, result);
  }

  /**
   * Test of actualizarRespuestaPreguntaPlanNegocio method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testActualizarRespuestaPreguntaPlanNegocio() {
    System.out.println("actualizarRespuestaPreguntaPlanNegocio");
    int idPlanNegocio = 10;
    int idPregunta = 1;
    String respuesta = "Si, todo esta bien";
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    instance.actualizarRespuestaPreguntaPlanNegocio(idPlanNegocio, idPregunta, respuesta);
  }

  /**
   * Test of comprarPlanNegocioPorTarjetaCredito method, of class PlanNegocioLogicaNegocio.
   */
  @Test
  public void testComprarPlanNegocioPorTarjetaCredito() {
    System.out.println("comprarPlanNegocioPorTarjetaCredito");
    int idPlanNegocio = 1;
    int idEmprendedor = 4;
    String direccionEntrega = "Calle Los Jazmines 231 - Urb. Maranga, San Miguel";
    EmprendedorLogicaNegocio emprendedorLogica = new EmprendedorLogicaNegocio();
    PlanNegocioLogicaNegocio instance = new PlanNegocioLogicaNegocio();
    BancoDomain banco = new BancoDomain();
    banco.setId(2);
    banco.setNombreBanco("Banco Cheverengue");
    EmprendedorDomain emprendedor = emprendedorLogica.buscarEmprendedor(idEmprendedor);
    TarjetaCreditoDomain infoTarjeta = new TarjetaCreditoDomain();
    infoTarjeta.setBanco(banco);
    infoTarjeta.setNumeroTarjeta("193-123-456-0001");
    infoTarjeta.setFechaCaducidad("11/14");
    infoTarjeta.setCodigoVerificacion("789");
    infoTarjeta.setEmprendedor(emprendedor);
    DocumentoDomain expResult = new DocumentoDomain();
    expResult.setId(1);
    DocumentoDomain result = instance.comprarPlanNegocioPorTarjetaCredito(idPlanNegocio, idEmprendedor, infoTarjeta, direccionEntrega);
    assertEquals(expResult.getId(), result.getId());
  }
}
