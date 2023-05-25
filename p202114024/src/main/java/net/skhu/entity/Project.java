package net.skhu.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Project{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    int progress;
    String priority;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="project")
    List<Assignment> assignment;

    @ManyToOne
    @JoinColumn(name = "managerId")
    Manager manager;

}

