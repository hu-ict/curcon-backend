package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.BloomNiveauDto;

/**
 * Created by Vidjinder on 22-6-2015.
 */
public interface BloomNiveauService {
	BloomNiveauDto create(BloomNiveauDto bloomNiveauDto);

	void delete(int id);

	BloomNiveauDto update(BloomNiveauDto bloomNiveauDto);

	BloomNiveauDto find(int id);

	List<BloomNiveauDto> findAll();
}
