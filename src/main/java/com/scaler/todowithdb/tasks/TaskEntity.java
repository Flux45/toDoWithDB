package com.scaler.todowithdb.tasks;

import com.scaler.todowithdb.common.BaseEntity;
import com.scaler.todowithdb.notes.NotesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name= "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "due_date", nullable = false)
    public Date dueDate;

    @Column(name = "done", nullable = false, columnDefinition = "boolean default false")
    public boolean done;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<NotesEntity> notes;

    public void setNotes(List<NotesEntity> notes) {
        this.notes = notes;
    }


}
