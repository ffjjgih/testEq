package testeq.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testeq.entity.Answer;
import testeq.entity.ChooseAnswer;
import testeq.entity.Question;
import testeq.entity.Test;
import testeq.model.response.AnswerResponse;
import testeq.model.response.Choose_AnswerResponse;
import testeq.model.response.QuestionResponse;
import testeq.model.response.TestResponse;
import testeq.repo.AnswerRepo;
import testeq.repo.ChooseAnswerRepo;
import testeq.repo.QuestionRepo;
import testeq.repo.TestRepo;


@Service
public class TestService {
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private AnswerRepo answerRepo;
	
	@Autowired
	private TestRepo testRepo;
	
	@Autowired
	private ChooseAnswerRepo chooseAnswerRepo;
	
	public List<QuestionResponse> getall(){
		List<Question> questions= this.questionRepo.findAll();
		List<QuestionResponse> responses=new ArrayList<QuestionResponse>();
		for(Question question:questions) {
			QuestionResponse response=new QuestionResponse();
			response.setId_question(question.getId());
			response.setText(question.getText());
			List<Answer> answers=this.answerRepo.findByQuestionId(question.getId());
			List<AnswerResponse> answerResponses=new ArrayList<AnswerResponse>();
			for(Answer answer:answers) {
				AnswerResponse answerResponse=new AnswerResponse();
				answerResponse.setId(answer.getId());
				answerResponse.setText(answer.getText());
				answerResponses.add(answerResponse);
			}
			response.setAnswers(answerResponses);
			responses.add(response);
		}
		return responses;
	}
	
	public TestResponse test(List<Integer> requests) {
		List<Answer> answers=new ArrayList<Answer>();
		TestResponse response=new TestResponse();
		List<Choose_AnswerResponse> responses=new ArrayList<Choose_AnswerResponse>();
		for(Integer id:requests) {
			Answer answer=new Answer();
			answer=this.answerRepo.getById(id);
			answers.add(answer);
		}
		float summark=0;
		for(Answer answer:answers) {
			Question question=new Question();
			Choose_AnswerResponse choose_AnswerResponse=new Choose_AnswerResponse();
			question=this.questionRepo.getById(answer.getQuestionId());
			choose_AnswerResponse.setAnswerId(answer.getId());
			choose_AnswerResponse.setAnswerText(answer.getText());
			choose_AnswerResponse.setMark(answer.getMark());
			choose_AnswerResponse.setQuestionId(question.getId());
			choose_AnswerResponse.setQuestionText(question.getText());
			summark+=answer.getMark();
			responses.add(choose_AnswerResponse);
		}
		response.setChoose_AnswerResponses(responses);
		Test test=new Test();
		test.setCreatedDate(new java.util.Date());
		test.setMark(summark);
		int testId=this.testRepo.save(test).getId();
		for(Integer id:requests) {
			ChooseAnswer chooseAnswer=new ChooseAnswer();
			chooseAnswer.setTestId(testId);
			chooseAnswer.setCreatedDate(new java.util.Date());
			chooseAnswer.setTestId(testId);
			this.chooseAnswerRepo.save(chooseAnswer);
		}
		
		response.setId(testId);
		response.setSumMark(summark);
		return response;
	}
}
