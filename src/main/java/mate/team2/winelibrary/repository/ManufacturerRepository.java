package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ManufacturerRepository  extends JpaRepository<Manufacturer, Integer>,
        JpaSpecificationExecutor<Manufacturer> {
}
