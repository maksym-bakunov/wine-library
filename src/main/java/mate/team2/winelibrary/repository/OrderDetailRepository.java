package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>,
        JpaSpecificationExecutor<OrderDetail> {
    List<OrderDetail> findAllByOrderId(Integer order_id);
}
