package nl.hu.curcon.dao;

import org.springframework.stereotype.Repository;

import nl.hu.curcon.domain.Module;
import nl.hu.curcon.dto.ModuleDto;

	@Repository
	public interface ModuleDao extends GenericDao<Module>  {

	}