package self.learn.checklist.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import self.learn.checklist.dto.ChecklistCreationDto;
import self.learn.checklist.service.ChecklistService;

import javax.validation.Valid;
import java.util.List;

/**
 * The endpoints for basic operation of a to-do app
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ChecklistController {
	
	private ChecklistService checklistService;
	
	@GetMapping("/getAllTodos")
	public ResponseEntity<List<ChecklistCreationDto>> getAllTodos() {
		return new ResponseEntity<List<ChecklistCreationDto>>(checklistService.getAllTasks(), HttpStatus.OK);
	}
	
	@PostMapping("/createTodo")
	public ResponseEntity<ChecklistCreationDto> createTodo(@Valid @RequestBody final ChecklistCreationDto checklistCreationDto) {
		return new ResponseEntity<ChecklistCreationDto>(checklistService.createTodo(checklistCreationDto), HttpStatus.OK);
	}
}
