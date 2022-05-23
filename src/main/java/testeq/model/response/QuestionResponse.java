package testeq.model.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import testeq.entity.Answer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
	private int id_question;
	private String text;
	private List<AnswerResponse> answers=new ArrayList<AnswerResponse>();
}
