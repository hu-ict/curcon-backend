package nl.hu.curcon.service;

import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;

public interface UserService {

	UserDto find(String username);

}
