package nl.hu.curcon.dao;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Module;

@Repository
public interface FunctionDao extends GenericDao<Function>  {
	Function find(int id);
}
