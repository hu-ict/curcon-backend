package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.PeriodeDto;

/**
 * @author berend.wilkens
 *
 */
public interface PeriodeService {
	PeriodeDto create(PeriodeDto periodeDto);

	void delete(int id);

	PeriodeDto update(PeriodeDto periodeDto);

	PeriodeDto find(int id);

	List<PeriodeDto> findAll();
}
