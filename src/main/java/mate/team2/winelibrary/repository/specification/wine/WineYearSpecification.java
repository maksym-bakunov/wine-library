package mate.team2.winelibrary.repository.specification.wine;

import javax.persistence.criteria.CriteriaBuilder;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineYearSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "year";
    public static final String FIELD_NAME = "year";

    @Override
    public Specification<Wine> getSpecification(String[] years) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : years) {
                predicate.value(Integer.valueOf(value));
            }
            /*
            Predicate predicate =
                    cb.equal(root.get(FIELD_NAME),
                            Integer.valueOf(years[0]));

             */
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
