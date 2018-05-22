package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.ModuleDao;
import nl.hu.curcon.domain.Module;

@Repository
public class ModuleDaoImpl extends GenericDaoImpl<Module> implements ModuleDao {
	
	@Override
	public Module find(String name) {   
		String query = "SELECT mod FROM Modules as mod WHERE mod.name = '"+name+"'";          
		Module result= (Module) this.em.createQuery(query).getSingleResult();
		return result;
	}
}
