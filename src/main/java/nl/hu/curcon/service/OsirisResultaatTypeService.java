package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.OsirisResultaatTypeDto;

/**
 * @author berend.wilkens
 *
 */
public interface OsirisResultaatTypeService {
	OsirisResultaatTypeDto create(OsirisResultaatTypeDto osirisResultaatTypeDto);

	void delete(int id);

	OsirisResultaatTypeDto update(OsirisResultaatTypeDto osirisResultaatTypeDto);

	OsirisResultaatTypeDto find(int id);

	List<OsirisResultaatTypeDto> findAll();
}
