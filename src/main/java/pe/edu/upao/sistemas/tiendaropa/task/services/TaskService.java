package pe.edu.upao.sistemas.tiendaropa.task.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.tiendaropa.task.models.Task;
import pe.edu.upao.sistemas.tiendaropa.task.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    final private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> list(){
        return taskRepository.list();
    }

    public Task create(Task task){
        return taskRepository.create(task);
    }
}
