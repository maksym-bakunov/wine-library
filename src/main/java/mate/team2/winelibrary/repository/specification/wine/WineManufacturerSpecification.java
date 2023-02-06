package mate.team2.winelibrary.repository.specification.wine;

import javax.persistence.criteria.CriteriaBuilder;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineManufacturerSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "manufacturer";
    public static final String FIELD_NAME = "manufacturer";

    @Override
    public Specification<Wine> getSpecification(String[] manufacturers) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : manufacturers) {
                predicate.value(Integer.valueOf(value));
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
