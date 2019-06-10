package pl.edu.agh.pharmoptim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.pharmoptim.entity.Job;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Override
    Optional<Job> findById(Long id);
}
