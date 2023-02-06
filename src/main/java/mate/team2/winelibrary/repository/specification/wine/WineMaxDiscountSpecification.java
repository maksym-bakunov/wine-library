package mate.team2.winelibrary.repository.specification.wine;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineMaxDiscountSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "maxDiscount";
    public static final String FIELD_NAME = "discount";

    @Override
    public Specification<Wine> getSpecification(String[] discounts) {
        return (root, query, cb) -> {
            Predicate predicate =
                    cb.lessThanOrEqualTo(root.get(FIELD_NAME),
                            BigDecimal.valueOf(Double.valueOf(discounts[0])));
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
