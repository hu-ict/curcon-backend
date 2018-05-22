package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.post.DocentPostDto;

/**
 * @author berend.wilkens, 4 mei 2017
 */
public interface DocentService {
	void delete(int docentId);

	boolean update(int docentId, DocentPostDto docentDto);

	DocentDto find(int docentId);

	List<DocentDto> findAll();

	int create(Organisatie organisatie, DocentPostDto docentDto);

}
