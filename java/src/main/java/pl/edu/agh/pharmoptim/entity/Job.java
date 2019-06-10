package pl.edu.agh.pharmoptim.entity;

import lombok.*;
import pl.edu.agh.pharmoptim.model.JobStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@Builder
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer oralDose;
    private Integer infDose;
    private Integer infTime;
    private Integer individualCount;
    private Integer femaleCount;
    private Integer minAge;
    private Integer maxAge;
    private Integer tEnd;
    private Integer seed;
    private String status;
    private String pathToPopulation;
    private String pathToNewDf;
}
