package nl.hu.curcon.service;

import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;

/**
 * @author berend.wilkens
 *
 */
public interface TrefwoordService {
	void delete(int id);

	boolean update(TrefwoordPostDto trefwoordDto);

	TrefwoordDto find(int id);

	int create(Leerlijn leerlijn, TrefwoordPostDto trefwoordDto);
}
