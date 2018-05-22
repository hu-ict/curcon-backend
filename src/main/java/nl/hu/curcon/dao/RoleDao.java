package nl.hu.curcon.dao;
import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.Role;
@Repository
public interface RoleDao extends GenericDao<Role>  {
	Role find(String name);
}