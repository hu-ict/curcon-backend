package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.LeerlijnPostDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;

/**
 * @author berend.wilkens, 30 mei 2017
 */
public interface LeerlijnService {
	LeerlijnDto create(LeerlijnPostDto leerlijnDto);

	void delete(int id);

	LeerlijnDto update(LeerlijnPostDto leerlijnDto);

	LeerlijnDto find(int id);

	List<LeerlijnDto> findAll();

	int createTrefwoordByLeerlijn(int leerlijnId, TrefwoordPostDto trefwoordDto);

	List<TrefwoordDto> findTrefwoordenByLeerlijn(int leerlijnId);
	
	
}
