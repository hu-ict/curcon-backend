package nl.hu.curcon.dao;

import java.util.List;

/**
 * @author berend.wilkens, 27 apr. 2017
 * GenericDao
 * @param <T>
 */
public interface GenericDao<T>{
        T save(final T t);
        void delete(final Object id);
        T update(final T t);
        T find(final Object id);
        List<T> findAll();
		List<T> findAll(String orderByField);
}
