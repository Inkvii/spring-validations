package inkvii.validations;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

	@Autowired
	private Validator validator;

	public CustomRequest padNameWithAge(CustomRequest request) throws RuntimeException {
		System.out.println("> padNameWithAge - " + request.toString());

		validateRequest(request);

		var result = new CustomRequest(request.getName() + request.getAge(), request.getAge());

		validateRequest(result);

		System.out.println("< padWithAge - " + result.toString());
		return result;
	}

	private void validateRequest(CustomRequest request) throws RuntimeException {
		var requestViolations = validator.validate(request);
		if (!requestViolations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			requestViolations.stream().forEach(violation -> sb.append(violation.getMessage()));
			throw new RuntimeException(sb.toString());
		}
	}
}
