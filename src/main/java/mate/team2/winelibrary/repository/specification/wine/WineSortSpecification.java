package mate.team2.winelibrary.repository.specification.wine;

import javax.persistence.criteria.CriteriaBuilder;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineSortSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "sort";
    public static final String FIELD_NAME = "sort";

    @Override
    public Specification<Wine> getSpecification(String[] sorts) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : sorts) {
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
