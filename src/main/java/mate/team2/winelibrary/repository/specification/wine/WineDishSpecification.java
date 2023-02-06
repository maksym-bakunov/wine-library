package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;

@Component
public class WineDishSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "dish";
    public static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] dishes) {
        return (root, query, cb) -> {
            root.join("dishes", JoinType.INNER);

            CriteriaBuilder.In<Integer> predicate = cb.in(root.join("dishes").get(FIELD_NAME));
            for (String value : dishes) {
                predicate.value(Integer.valueOf(value));
            }
            query.groupBy(root.get("id"));
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
