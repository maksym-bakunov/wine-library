package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ColorRepository extends JpaRepository<Color, Integer>,
        JpaSpecificationExecutor<Color> {
}
