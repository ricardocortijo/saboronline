/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.CategoriaDomain;
import edu.upc.sistemaventas.dominio.DocumentoDomain;
import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import edu.upc.sistemaventas.dominio.SabioDomain;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class MySqlPlanNegocioDAO extends MySqlBaseDAO implements PlanNegocioDAO {

  public MySqlPlanNegocioDAO() throws Exception {
    super();
  }

  public PlanNegocioDomain getPlanNegocio(int idPlanNegocio) {
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idPlanNegocio);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        return planNegocio;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int registrarPlanNegocio(PlanNegocioDomain planNegocio) {
    int idCorrelativo = -1;
    String sql = "insert into plan_negocio ( titulo, id_categoria, vision_negocio, razonamiento_propuesta, tiempo_ejecucion_dias, inversion_total, ";
    sql += "                                 margen_neto_primer_anio, roi, id_documento, flag_viable, estado_plan_negocio, id_sabio ) ";
    sql += "                  values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, planNegocio.getTitulo());
      if (planNegocio.getCategoria() != null) {
        pstmt.setInt(2, planNegocio.getCategoria().getId());
      } else {
        pstmt.setNull(2, java.sql.Types.INTEGER);
      }
      pstmt.setString(3, planNegocio.getVisionNegocio());
      pstmt.setString(4, planNegocio.getRazonamientosPropuesta());
      pstmt.setFloat(5, planNegocio.getTiempoEjecucion());
      pstmt.setBigDecimal(6, planNegocio.getInversionTotal());
      pstmt.setBigDecimal(7, planNegocio.getMargenNeto());
      pstmt.setBigDecimal(8, planNegocio.getRoi());
      if (planNegocio.getDocumento() != null) {
        pstmt.setInt(9, planNegocio.getDocumento().getId());
      } else {
        pstmt.setNull(9, java.sql.Types.INTEGER);
      }
      pstmt.setString(10, planNegocio.getFlagViable());
      pstmt.setString(11, planNegocio.getEstadoPlanNegocio());
      if (planNegocio.getSabio() != null) {
        pstmt.setInt(12, planNegocio.getSabio().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
      }
      pstmt.executeUpdate();
      ResultSet rs = pstmt.getGeneratedKeys();
      if (rs.next()) {
        idCorrelativo = rs.getInt(1);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return idCorrelativo;
  }

  public void actualizarPlanNegocio(PlanNegocioDomain planNegocio) {
    String sql = "update plan_negocio ";
    sql += "         set titulo = ?, id_categoria = ?, vision_negocio = ?, razonamiento_propuesta = ?, tiempo_ejecucion_dias = ?, inversion_total = ?, ";
    sql += "             margen_neto_primer_anio = ?, roi = ?, id_documento = ?, flag_viable = ?, estado_plan_negocio = ?, id_sabio = ?, ";
    sql += "             mensaje_final = ? ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, planNegocio.getTitulo());
      if (planNegocio.getCategoria() != null) {
        pstmt.setInt(2, planNegocio.getCategoria().getId());
      } else {
        pstmt.setNull(2, java.sql.Types.INTEGER);
      }
      pstmt.setString(3, planNegocio.getVisionNegocio());
      pstmt.setString(4, planNegocio.getRazonamientosPropuesta());
      pstmt.setFloat(5, planNegocio.getTiempoEjecucion());
      pstmt.setBigDecimal(6, planNegocio.getInversionTotal());
      pstmt.setBigDecimal(7, planNegocio.getMargenNeto());
      pstmt.setBigDecimal(8, planNegocio.getRoi());
      if (planNegocio.getDocumento() != null) {
        pstmt.setInt(9, planNegocio.getDocumento().getId());
      } else {
        pstmt.setNull(9, java.sql.Types.INTEGER);
      }
      pstmt.setString(10, planNegocio.getFlagViable());
      pstmt.setString(11, planNegocio.getEstadoPlanNegocio());
      if (planNegocio.getSabio() != null) {
        pstmt.setInt(12, planNegocio.getSabio().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
      }
      pstmt.setString(13, planNegocio.getMensajeFinal());
      pstmt.setInt(14, planNegocio.getId());
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void actualizarEstadoPlanNegocio(int idPlanNegocio, String estado) {
    String sql = "update plan_negocio ";
    sql += "         set estado_plan_negocio = ? ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, estado);
      pstmt.setInt(2, idPlanNegocio);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarPlanNegocio(int idPlanNegocio) {
    String sql = "delete from plan_negocio ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idPlanNegocio);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public List<PlanNegocioDomain> buscarPlanesNegocio(String criterioBusqueda) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "             left join categoria c on ( pn.id_categoria = c.id ) ";
    sql += "       where ( pn.titulo like ? ";
    sql += "               or c.nombre like ? ";
    sql += "               or pn.vision_negocio like ? ";
    sql += "               or pn.razonamiento_propuesta like ? ) ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      for (int i = 1; i <= 4; i++) {
        pstmt.setString(i, "%" + criterioBusqueda + "%");
      }
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<PlanNegocioDomain> buscarPlanesNegocioPorTiempoEjecucion(float tiempoEjecucionInicio, float tiempoEjecucionFin) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.tiempo_ejecucion_dias >= ? ";
    sql += "         and pn.tiempo_ejecucion_dias <= ? ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setFloat(1, tiempoEjecucionInicio);
      pstmt.setFloat(2, tiempoEjecucionFin);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<PlanNegocioDomain> buscarPlanesNegocioPorInversionTotal(BigDecimal inversionTotalDesde, BigDecimal inversionTotalHasta) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.inversion_total >= ? ";
    sql += "         and pn.inversion_total <= ? ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setBigDecimal(1, inversionTotalDesde);
      pstmt.setBigDecimal(2, inversionTotalHasta);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<PlanNegocioDomain> buscarPlanesNegocioPorMargenNeto(BigDecimal margenNetoDesde, BigDecimal margenNetoHasta) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.margen_neto_primer_anio >= ? ";
    sql += "         and pn.margen_neto_primer_anio <= ? ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setBigDecimal(1, margenNetoDesde);
      pstmt.setBigDecimal(2, margenNetoHasta);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<PlanNegocioDomain> buscarPlanesNegocioPorROI(BigDecimal roiDesde, BigDecimal roiHasta) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.roi >= ? ";
    sql += "         and pn.roi <= ? ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setBigDecimal(1, roiDesde);
      pstmt.setBigDecimal(2, roiHasta);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<PlanNegocioDomain> obtenerPlanesNegocioPorSabio(int idSabio) {
    List<PlanNegocioDomain> listaPlanesNegocio = null;
    String sql = "select pn.* ";
    sql += "        from plan_negocio pn ";
    sql += "       where pn.id_sabio = ? ";
    try {
      listaPlanesNegocio = new ArrayList<PlanNegocioDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idSabio);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PlanNegocioDomain planNegocio = obtenerPlanNegocioLleno(rs);
        listaPlanesNegocio.add(planNegocio);
      }
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  private PlanNegocioDomain obtenerPlanNegocioLleno(ResultSet rs) throws Exception {
    PlanNegocioDomain planNegocio = new PlanNegocioDomain();
    planNegocio.setId(rs.getInt("id"));
    planNegocio.setTitulo(rs.getString("titulo"));
    planNegocio.setVisionNegocio(rs.getString("vision_negocio"));
    planNegocio.setRazonamientosPropuesta(rs.getString("razonamiento_propuesta"));
    planNegocio.setTiempoEjecucion(rs.getFloat("tiempo_ejecucion_dias"));
    planNegocio.setInversionTotal(rs.getBigDecimal("inversion_total"));
    planNegocio.setMargenNeto(rs.getBigDecimal("margen_neto_primer_anio"));
    planNegocio.setRoi(rs.getBigDecimal("roi"));
    planNegocio.setFlagViable(rs.getString("flag_viable"));
    planNegocio.setEstadoPlanNegocio(rs.getString("estado_plan_negocio"));
    if (rs.getObject("id_categoria") != null) {
      CategoriaDAO categoriaDao = new MySqlCategoriaDAO();
      CategoriaDomain categoria = categoriaDao.getCategoria(rs.getInt("id_categoria"));
      planNegocio.setCategoria(categoria);
    }
    if (rs.getObject("id_documento") != null) {
      DocumentoDAO documentoDao = new MySqlDocumentoDAO();
      DocumentoDomain documento = documentoDao.getDocumento(rs.getInt("id_documento"));
      planNegocio.setDocumento(documento);
    }
    if (rs.getObject("id_sabio") != null) {
      SabioDAO sabioDao = new MySqlSabioDAO();
      SabioDomain sabio = sabioDao.getSabio(rs.getInt("id_sabio"));
      planNegocio.setSabio(sabio);
    }
    return planNegocio;
  }
}
