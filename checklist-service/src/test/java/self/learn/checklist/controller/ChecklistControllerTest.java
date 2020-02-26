package self.learn.checklist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import self.learn.checklist.service.ChecklistService;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ChecklistControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ChecklistService checklistService;
	
	@Test
	public void shouldInvokeServiceAndReturnOk() throws Exception {
		// GIVEN
		when(checklistService.getAllTasks()).thenReturn(new ArrayList<>());
		
		// WHEN
		mockMvc.perform(get("/api/getAllTodos"))
				.andExpect(status().isOk());
		
		// THEN
		verify(checklistService, times(1)).getAllTasks();
	}
}
