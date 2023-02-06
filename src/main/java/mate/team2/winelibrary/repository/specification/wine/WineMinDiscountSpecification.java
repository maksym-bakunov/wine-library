package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;

@Component
public class WineMinDiscountSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "minDiscount";
    public static final String FIELD_NAME = "discount";

    @Override
    public Specification<Wine> getSpecification(String[] discounts) {
        return (root, query, cb) -> {
            Predicate predicate =
                    cb.greaterThanOrEqualTo(root.get(FIELD_NAME),
                            BigDecimal.valueOf(Double.valueOf(discounts[0])));
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
