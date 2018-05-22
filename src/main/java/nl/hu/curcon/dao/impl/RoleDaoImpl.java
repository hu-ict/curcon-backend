package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.domain.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {
	
	@Override
	public Role find(String name) {   
		String query = "SELECT rol FROM Roles as rol WHERE rol.name = '"+name+"'";          
		Role result= (Role) this.em.createQuery(query).getSingleResult();
		return result;
	}
}