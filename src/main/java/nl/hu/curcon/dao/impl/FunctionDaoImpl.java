package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.FunctionDao;
import nl.hu.curcon.domain.Function;

@Repository
public class FunctionDaoImpl extends GenericDaoImpl<Function> implements FunctionDao {
		
		@Override
		public Function find(String name) {   
			String query = "SELECT func FROM Functions as func WHERE func.name = '"+name+"'";          
			return (Function) this.em.createQuery(query).getSingleResult();  
		}
	}
