package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    Role findAllByStatus(Byte status);
}