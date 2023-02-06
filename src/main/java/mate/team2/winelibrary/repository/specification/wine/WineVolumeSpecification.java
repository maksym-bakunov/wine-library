package mate.team2.winelibrary.repository.specification.wine;

import javax.persistence.criteria.CriteriaBuilder;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WineVolumeSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "volume";
    public static final String FIELD_NAME = "volume";

    @Override
    public Specification<Wine> getSpecification(String[] volumes) {

        return (root, query, cb) -> {
            CriteriaBuilder.In<BigDecimal> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : volumes) {
                predicate.value(BigDecimal.valueOf(Double.valueOf(value)));
            }

            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
