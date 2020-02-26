package self.learn.checklist.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ChecklistCreationDto {
	
	@NotNull
	private String name;
	private String description;
	private LocalDateTime todoClientCreation;
	private LocalDateTime todoBackendCreation;
	
	public String toString() {
		return "name is: " + name + ", description is: " + description + ", clientTime: " + todoClientCreation
				+ ", todoBackendCreation: " + LocalDateTime.now();
	}
}
