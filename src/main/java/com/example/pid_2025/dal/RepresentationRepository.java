package com.example.pid_2025.dal;
import com.example.pid_2025.entities.Location;
import com.example.pid_2025.entities.Representation;
import com.example.pid_2025.entities.Show;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.List;
public interface RepresentationRepository extends CrudRepository<Representation, Long> {
    List<Representation> findByShow(Show show);
    List<Representation> findByLocation(Location location);
    List<Representation> findByWhen(LocalDateTime when);
}