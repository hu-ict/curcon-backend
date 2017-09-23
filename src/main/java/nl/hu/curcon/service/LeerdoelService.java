package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;

/**
 * @author berend.wilkens
 *
 */
public interface LeerdoelService {
	void delete(int leerdoelId);

	boolean update(int leerdoelId, LeerdoelPostDto leerdoelDto);

	LeerdoelDto find(int leerdoelId);

	List<LeerdoelDto> findAll();

	int create(Cursus cursus, LeerdoelPostDto leerdoelDto);

	List<ToetsElementDto> getToetslementenByLeerdoel(int leerdoelId);

	int createToetsElementByLeerdoel(int leerdoelId, ToetsElementPostDto toetsElementDto);
}
