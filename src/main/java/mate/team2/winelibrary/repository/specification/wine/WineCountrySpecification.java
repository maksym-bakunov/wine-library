package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class WineCountrySpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "country";
    public static final String FIELD_NAME = "country";

    @Override
    public Specification<Wine> getSpecification(String[] countries) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : countries) {
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
