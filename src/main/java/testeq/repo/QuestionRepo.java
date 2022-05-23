package testeq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testeq.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

}
