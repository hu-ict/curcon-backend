package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public interface ToetsService {
	int create(Cursus cursus, ToetsPostDto toetsDto);

	void delete(int toetsId);

	boolean update(int toetsId, ToetsPostDto toetsDto);

	ToetsDto find(int toetsId);

	int createBeoordelingsElementByToets(int toetsId, BeoordelingsElementPostDto beoordelingsElementPostDto);

	List<BeoordelingsElementDto> findBeoordelingsElementenByToets(int toetsId);

}
