package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Sweetness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SweetnessRepository extends JpaRepository<Sweetness, Integer>,
        JpaSpecificationExecutor<Sweetness> {
}
