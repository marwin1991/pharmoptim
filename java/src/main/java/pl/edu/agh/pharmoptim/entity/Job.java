package pl.edu.agh.pharmoptim.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Setter
@Getter
@Builder
@Entity
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
}
