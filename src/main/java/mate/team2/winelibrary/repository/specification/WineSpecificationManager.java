package mate.team2.winelibrary.repository.specification;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineSpecificationManager implements SpecificationManager {
    private Map<String, SpecificationProvider<Wine>> providersMap;

    public WineSpecificationManager(List<SpecificationProvider<Wine>> wineSpecification) {
        this.providersMap = wineSpecification.
                stream().
                collect(Collectors.toMap(SpecificationProvider::getFilterKey,
                Function.identity()));
    }

    @Override
    public Specification get(String filterKey, String[] params) {
        if (!providersMap.containsKey(filterKey)) {
           throw new RuntimeException("Key " + filterKey + " not supported!");
        }
        return providersMap.get(filterKey).getSpecification(params);
    }
}
