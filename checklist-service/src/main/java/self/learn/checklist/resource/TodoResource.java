package self.learn.checklist.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import self.learn.checklist.dto.ChecklistCreationDto;
import self.learn.checklist.service.ChecklistService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoResource {
	private ChecklistService checklistService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ChecklistCreationDto>> getAllTodos() {
		return new ResponseEntity<>(checklistService.getAllTasks(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ChecklistCreationDto> createTodo(@Valid @RequestBody final ChecklistCreationDto checklistCreationDto) {
		return new ResponseEntity<>(checklistService.createTodo(checklistCreationDto), HttpStatus.CREATED);
	}
}
