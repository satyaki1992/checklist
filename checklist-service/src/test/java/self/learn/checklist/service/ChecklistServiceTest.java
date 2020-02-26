package self.learn.checklist.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import self.learn.checklist.dto.ChecklistCreationDto;
import self.learn.checklist.model.Checklists;
import self.learn.checklist.repository.ChecklistRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChecklistServiceTest {
	
	@InjectMocks
	private ChecklistService checklistService;
	@Mock
	private ChecklistRepository checklistRepository;
	
	@Test
	public void testMe() {
		//GIVEN
		when(checklistRepository.save(any(Checklists.class))).thenReturn(new Checklists());
		
		//WHEN
		final ChecklistCreationDto checklistCreationDto = checklistService.createTodo(getChecklist());
		
		//THEN
		verify(checklistRepository).save(any(Checklists.class));
		assertEquals("dummy_name", checklistCreationDto.getName());
		assertEquals("dummy_description", checklistCreationDto.getDescription());
	}
	
	private ChecklistCreationDto getChecklist() {
		return ChecklistCreationDto.builder()
				.name("dummy_name")
				.description("dummy_description")
				.todoClientCreation(LocalDateTime.now())
				.build();
	}
}