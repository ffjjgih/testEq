package testeq.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Choose_AnswerResponse {
	private int questionId;
	private int answerId;
	private String questionText;
	private String answerText;
	private float mark;
}
