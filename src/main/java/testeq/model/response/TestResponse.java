package testeq.model.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestResponse {
	private int id;
	private float sumMark;
	private List<Choose_AnswerResponse> choose_AnswerResponses=new ArrayList<Choose_AnswerResponse>();
}
