package mvc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import service.SpitterService;
import dao.Spittle;



public class HomeControllerTest {
	private static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	@Test
	public void shouldDisplayRecentSpittles(){
		List<Spittle> expectedSpittles = new LinkedList<Spittle>();
		expectedSpittles.add(new Spittle());
		expectedSpittles.add(new Spittle());
		expectedSpittles.add(new Spittle());
		SpitterService service = mock(SpitterService.class);
		when(service.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);
		HomeController controller = new HomeController(service);
		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);
		assertEquals("home", viewName);
		assertSame(expectedSpittles, model.get("spittles"));
		verify(service).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
	}
}
