package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;
import nl.hu.curcon.dto.post.ToetsElementPutDto;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public interface ToetsElementService {
	int create(Leerdoel leerdoel, ToetsElementPostDto toetsElementDto);

	boolean delete(int toetsElementId);

	boolean update(int toetsElementId, ToetsElementPutDto toetsElementDto);

	ToetsElementDto find(int toetsElementId);

	List<ToetsElementDto> findAll();

}
