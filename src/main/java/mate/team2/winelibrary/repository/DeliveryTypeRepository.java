package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Integer>,
        JpaSpecificationExecutor<DeliveryType> {
}
