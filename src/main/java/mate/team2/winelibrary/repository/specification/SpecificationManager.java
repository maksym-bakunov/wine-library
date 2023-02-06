package mate.team2.winelibrary.repository.specification;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationManager<T> {
    Specification<T> get(String keyValue, String[] params);
}
