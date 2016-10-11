/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.CategoriaDomain;
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
public class CategoriaLogicaNegocioTest {

  public CategoriaLogicaNegocioTest() {
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
   * Test of buscarCategoria method, of class CategoriaLogicaNegocio.
   */
  @Test
  public void testBuscarCategoria() {
    System.out.println("buscarCategoria");
    int idCategoria = 1;
    CategoriaLogicaNegocio instance = new CategoriaLogicaNegocio();
    CategoriaDomain expResult = new CategoriaDomain();
    expResult.setId(1);
    expResult.setNombreCategoria("Agricultura");
    CategoriaDomain result = instance.buscarCategoria(idCategoria);
    assertEquals(expResult.getNombreCategoria(), result.getNombreCategoria());
  }

  /**
   * Test of buscarCategoriasPorPadre method, of class CategoriaLogicaNegocio.
   */
  @Test
  public void testBuscarCategoriasPorPadre() {
    System.out.println("buscarCategoriasPorPadre");
    int idCategoriaPadre = 2;
    CategoriaLogicaNegocio instance = new CategoriaLogicaNegocio();
    int expResult = 2;
    List result = instance.buscarCategoriasPorPadre(idCategoriaPadre);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of registrarCategoria method, of class CategoriaLogicaNegocio.
   */
  @Test
  public void testRegistrarCategoria() {
    System.out.println("registrarCategoria");
    CategoriaLogicaNegocio instance = new CategoriaLogicaNegocio();
    CategoriaDomain categoria = new CategoriaDomain();
    categoria.setNombreCategoria("Servicios");
    categoria.setDescripcion("Servicios Varios");
    instance.eliminarCategoriaByNombre(categoria.getNombreCategoria());
    int expResult = -1;
    int result = instance.registrarCategoria(categoria);
    assertNotSame(expResult, result);
  }

  /**
   * Test of actualizarCategoria method, of class CategoriaLogicaNegocio.
   */
  @Test
  public void testActualizarCategoria() {
    System.out.println("actualizarCategoria");
    CategoriaDomain categoria = new CategoriaDomain();
    categoria.setNombreCategoria("Servicios");
    categoria.setDescripcion("Servicios Varios Modificado");
    CategoriaLogicaNegocio instance = new CategoriaLogicaNegocio();
    instance.actualizarCategoria(categoria);
  }

  /**
   * Test of eliminarCategoria method, of class CategoriaLogicaNegocio.
   */
  @Test
  public void testEliminarCategoria() {
    System.out.println("eliminarCategoria");
    CategoriaLogicaNegocio instance = new CategoriaLogicaNegocio();
    CategoriaDomain categoria = instance.buscarCategoriaPorNombre("Servicios");
    instance.eliminarCategoria(categoria.getId());
  }
  
}
