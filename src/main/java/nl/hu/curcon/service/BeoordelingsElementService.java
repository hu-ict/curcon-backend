package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;

/**
 * @author berend.wilkens, 30 mei 2017
 */
public interface BeoordelingsElementService {
	boolean delete(int id);

	boolean update(int beoordelingsElementId, BeoordelingsElementPostDto beoordelingsElementDto);

	BeoordelingsElementDto find(int id);

	int create(Toets toets, BeoordelingsElementPostDto beoordelingsElementDto);

	List<ToetsElementDto> getToetslementenByBeoordelingsElement(int beoordelingsElementId);
}
