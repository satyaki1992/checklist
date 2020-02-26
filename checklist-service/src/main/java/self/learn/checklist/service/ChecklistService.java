package self.learn.checklist.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import self.learn.checklist.dto.ChecklistCreationDto;
import self.learn.checklist.model.Checklists;
import self.learn.checklist.repository.ChecklistRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ChecklistService {
	
	private ChecklistRepository checklistRepository;
	
	public ChecklistCreationDto createTodo(final ChecklistCreationDto checklistCreationDto) {
		//TODO: chain of responsibility
		
		final Checklists checklists = Checklists.builder()
				.name(checklistCreationDto.getName())
				.description(checklistCreationDto.getDescription())
				.clientTriggerTime(checklistCreationDto.getTodoClientCreation())
				.backendPersistTime(LocalDateTime.now())
				.build();
		checklistRepository.save(checklists);
		return ChecklistCreationDto.builder()
				.name(checklists.getName())
				.description(checklists.getDescription())
				.build();
	}
	
	public List<ChecklistCreationDto> getAllTasks() {
		
		final List<ChecklistCreationDto> checklistCreationDtoList = new ArrayList<>();
		final List<Checklists> checklistsList = checklistRepository.findAll();
		checklistsList.stream()
				.forEach(checklistObj -> {
					checklistCreationDtoList.add(
							ChecklistCreationDto.builder()
							.name(checklistObj.getName())
							.description(checklistObj.getDescription())
							.todoClientCreation(checklistObj.getClientTriggerTime())
							.todoBackendCreation(checklistObj.getBackendPersistTime())
							.build());
				});
		return checklistCreationDtoList;
	}
}
