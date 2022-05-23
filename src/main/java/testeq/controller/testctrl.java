package testeq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testeq.model.response.QuestionResponse;
import testeq.model.response.TestResponse;
import testeq.service.TestService;

@RestController
@RequestMapping("/api/v1")
public class testctrl {
	@Autowired
	private TestService	testService;
	@GetMapping("/question/getall")
	public List<QuestionResponse> getall() {
		return this.testService.getall();
	}
	
	@PostMapping("/test")
	public TestResponse test(@RequestBody List<Integer> asws) {
		return this.testService.test(asws);
	}
}
