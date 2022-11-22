package pe.edu.upao.sistemas.tiendaropa.task.repositories;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.tiendaropa.task.models.Task;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskRepository {
    private List<Task> db = new ArrayList<>();

    public List<Task> list(){
        return db;
    }

    public Task create(Task task){
        task.id = db.size() + 1;
        db.add(task);
        return task;
    }
}
