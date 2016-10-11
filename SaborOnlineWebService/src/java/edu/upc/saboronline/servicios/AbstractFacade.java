/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author milan
 */
public abstract class AbstractFacade<T> {

  private Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected abstract EntityManager getEntityManager();

  public T buscar(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public void registrar(T entity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
    if (constraintViolations.size() > 0) {
      Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
      while (iterator.hasNext()) {
        ConstraintViolation<T> cv = iterator.next();
        System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
        //JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
      }
    } else {
      getEntityManager().persist(entity);
    }
  }

  public void actualizar(T entity) {
    getEntityManager().merge(entity);
  }

  public void eliminar(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }

}
