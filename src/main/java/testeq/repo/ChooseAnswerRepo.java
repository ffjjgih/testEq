package testeq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testeq.entity.ChooseAnswer;

@Repository
public interface ChooseAnswerRepo extends JpaRepository<ChooseAnswer, Integer>{

}
