package com.scaler.todowithdb.notes;

import com.scaler.todowithdb.tasks.TaskEntity;
import com.scaler.todowithdb.tasks.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class NotesRepositoryTest {
    @Autowired private TasksRepository tasksRepository;

    @Test
    public void canCreateTask() {
        TaskEntity task = new TaskEntity();
        task.name = "test task";
        task.dueDate = new Date();
        tasksRepository.save(task);

        TaskEntity savedTask = tasksRepository.findAll().get(0);

        assertEquals("test task", savedTask.name);

        System.out.println(savedTask);
    }
}
