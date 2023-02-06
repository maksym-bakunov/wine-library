package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;

@Component
public class WineMinPriceSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_NAME = "minPrice";
    public static final String FIELD_NAME = "price";

    @Override
    public Specification<Wine> getSpecification(String[] price) {
        return (root, query, cb) -> {
            Predicate predicate =
                    cb.greaterThanOrEqualTo(root.get(FIELD_NAME),
                            BigDecimal.valueOf(Double.valueOf(price[0])));
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_NAME;
    }
}
