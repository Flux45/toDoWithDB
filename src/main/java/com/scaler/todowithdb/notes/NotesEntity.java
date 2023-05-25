package com.scaler.todowithdb.notes;

import com.scaler.todowithdb.common.BaseEntity;
import com.scaler.todowithdb.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name= "notes")
@Getter

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotesEntity extends BaseEntity {

    @Column(name = "title", nullable = false, length = 100)
    String title;

    @Column(name = "body", nullable = false, length = 1000)
    String body;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    TaskEntity task;

    public void setTask(TaskEntity task) {
        this.task = task;
    }

}
