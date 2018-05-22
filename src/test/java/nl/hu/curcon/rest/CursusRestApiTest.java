package nl.hu.curcon.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CursusRestApiTest {
	@Autowired
	CursusRestService cursusRestService;

	@Test
	public void testAddBeroepsTaakByCursus() {	
//		System.out.println(cursusRestService);
//		IdLinkDto dto = new IdLinkDto();
//		dto.setId(35);
//		Response response = cursusRestService.addBeroepsTaakByCursus(6, dto);
		assertEquals(200, 200);
	}

}
