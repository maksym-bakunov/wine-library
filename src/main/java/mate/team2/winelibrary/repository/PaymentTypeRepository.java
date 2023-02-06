package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>,
        JpaSpecificationExecutor<PaymentType> {
}
