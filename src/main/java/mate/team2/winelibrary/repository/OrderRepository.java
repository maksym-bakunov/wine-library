package mate.team2.winelibrary.repository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import mate.team2.winelibrary.model.Order;
import mate.team2.winelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer>,
        JpaSpecificationExecutor<Order> {
    List<Order> findByEmail(String email);
    Optional<Order> findById(Integer id);

    @Transactional
    @Modifying
    @Query("update Order o set o.user = ?1 where o.email = ?2")
    void setUserIdByUserId(User user, String email);
}
