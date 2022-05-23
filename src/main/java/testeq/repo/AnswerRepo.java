package testeq.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testeq.entity.Answer;
import testeq.entity.Question;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer>{
	List<Answer> findByQuestionId(int questionId);
}
