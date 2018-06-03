package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.domain.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {
	
	@Override
	public Role find(int id) { 
		System.out.println(id);
		String query = "SELECT rol FROM Role as rol WHERE rol.id = "+id;          
		Role result= (Role) this.em.createQuery(query).getSingleResult();
		return result;
	}
}