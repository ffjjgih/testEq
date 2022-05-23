package testeq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testeq.entity.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer>{

}
