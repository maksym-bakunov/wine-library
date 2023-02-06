package mate.team2.winelibrary.repository.specification;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationManagerImpl<T> implements SpecificationManager {
    private  Map<String, SpecificationProvider<T>> providersMap;

    public SpecificationManagerImpl(List<SpecificationProvider<T>> wineSpecification) {
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
