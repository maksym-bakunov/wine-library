package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<Country, Integer>,
        JpaSpecificationExecutor<Country> {
}
