package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class WineSweetnessSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "sweetness";
    public static final String FIELD_NAME = "sweetness";

    @Override
    public Specification<Wine> getSpecification(String[] sweetness) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : sweetness) {
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
