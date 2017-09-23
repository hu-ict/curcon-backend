package nl.hu.curcon.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.hu.curcon.dao.GenericDao;


/**
 * Created by Frits on 12-5-2015.
 */

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    protected Class<T> type;

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        //noinspection unchecked
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public T save(final T t) {
        this.em.persist(t);
        this.em.flush();
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T find(final Object id) {
        return this.em.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);
    }


    @SuppressWarnings("unchecked")
	@Override
    public List<T> findAll() {
        return (List<T>) this.em.createQuery("from " + type.getName()).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> findAll(String orderByField) {
        return (List<T>) this.em.createQuery("from " + type.getName() + " order by " + orderByField).getResultList();
    }
}


