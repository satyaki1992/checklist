package self.learn.checklist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import self.learn.checklist.model.Checklists;

@Repository
public interface ChecklistRepository extends MongoRepository<Checklists, Integer> {

}
