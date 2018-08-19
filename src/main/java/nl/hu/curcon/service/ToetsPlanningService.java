package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.ToetsPlanningDto;

/**
 * @author berend.wilkens
 *
 */
public interface ToetsPlanningService {
	ToetsPlanningDto create(ToetsPlanningDto toetsPlanningDto);

	void delete(int id);

	ToetsPlanningDto update(ToetsPlanningDto toetsPlanningDto);

	ToetsPlanningDto find(int id);

	List<ToetsPlanningDto> findAll();
}
