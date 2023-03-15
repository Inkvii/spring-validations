package inkvii.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private CustomService service;

	@PostMapping("/")
	public ResponseEntity<CustomRequest> testValidations(@RequestBody CustomRequest request) {
		System.out.println("> testValidations - Test validations is running");

		CustomRequest modifiedRequest = service.padNameWithAge(request);

		System.out.println("< testValidations");
		return ResponseEntity.ok(modifiedRequest);
	}
}
