package inkvii.validations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomRequest {
	@NotBlank(message = "Name must not be empty because it might explode!")
	@Size(min = 2, max = 5, message = "Name is too fat or too tiny, depends on whom you ask!")
	private String name;
	@Positive(message = "We dont like unborns")
	private int age;
}
