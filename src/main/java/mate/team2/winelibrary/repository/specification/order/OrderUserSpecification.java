package mate.team2.winelibrary.repository.specification.order;

import javax.persistence.criteria.CriteriaBuilder;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class OrderUserSpecification implements SpecificationProvider<Order> {
    public static final String FILTER_KEY = "userId";
    public static final String FIELD_NAME = "user";

    @Override
    public Specification<Order> getSpecification(String[] users) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : users) {
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
