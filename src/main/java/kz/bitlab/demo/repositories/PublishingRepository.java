package kz.bitlab.demo.repositories;

import kz.bitlab.demo.models.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingRepository extends JpaRepository<Publishing, Long> {
}
