package mate.team2.winelibrary.repository.specification.wine;

import mate.team2.winelibrary.repository.specification.SpecificationProvider;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineNameSubstringSpecification implements SpecificationProvider<Wine> {
    public static final String FILTER_KEY = "search";
    public static final String FIELD_NAME = "name";

    @Override
    public Specification<Wine> getSpecification(String[] names) {
        return (root, query, cb) -> cb.like(root.get(FIELD_NAME), "%" + names[0] + "%");
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
