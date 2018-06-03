package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.FunctionDao;
import nl.hu.curcon.domain.Function;

@Repository
public class FunctionDaoImpl extends GenericDaoImpl<Function> implements FunctionDao {
		
		@Override
		public Function find(int id) {   
			String query = "SELECT func FROM Function func WHERE func.id ="+id;          
			return (Function) this.em.createQuery(query).getSingleResult();  
		}
	}
