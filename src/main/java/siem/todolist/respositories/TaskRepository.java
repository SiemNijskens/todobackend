package siem.todolist.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siem.todolist.models.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
}
