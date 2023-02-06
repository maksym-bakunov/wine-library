package mate.team2.winelibrary.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.repository.WineRepository;
import mate.team2.winelibrary.repository.specification.WineSpecificationManager;
import mate.team2.winelibrary.service.WineService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    private final WineSpecificationManager wineSpecificationManager;

    public WineServiceImpl(WineRepository wineRepository, WineSpecificationManager wineSpecificationManager) {
        this.wineRepository = wineRepository;
        this.wineSpecificationManager = wineSpecificationManager;
    }

    @Override
    public List<Wine> findAll() {
        return wineRepository.findAll();
    }

    @Override
    public Wine add(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public Wine findById(Integer id) {
        return wineRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public List<Wine> findAllByCriteria(Map<String, String> param,
                                        PageRequest pageRequest) {
        Specification<Wine> specification = null;

        for(Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals("page") || entry.getKey().equals("count") ||
                    entry.getKey().equals("sortBy")) {
                continue;
            }
            Specification<Wine> sp =
                    wineSpecificationManager.get(entry.getKey(), entry.getValue().split(","));
            specification = specification == null ? Specification.where(sp) : specification.and(sp);
        }

        return wineRepository.findAll(specification, pageRequest).toList();
    }

    @Override
    public List<Wine> findAllByCriteria(Map<String, String> param) {
        Specification<Wine> specification = null;

        for(Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals("page") || entry.getKey().equals("count") || entry.getKey().equals("sortBy")) {
                continue;
            }
            Specification<Wine> sp =
                    wineSpecificationManager.get(entry.getKey(), entry.getValue().split(","));
            specification = specification == null ? Specification.where(sp) : specification.and(sp);
        }
        return wineRepository.findAll(specification);
    }

    @Override
    public Long getQuantity(Map<String, String> param) {
        Specification<Wine> specification = null;

        for(Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals("page") || entry.getKey().equals("count")) {
                continue;
            }
            Specification<Wine> sp =
                    wineSpecificationManager.get(entry.getKey(), entry.getValue().split(","));
            specification = specification == null ? Specification.where(sp) : specification.and(sp);
        }
        return wineRepository.findAll(specification).stream().count();
    }
    @Override
    public List<WineRepository.QuantityByCountries> findAllQuantityByCountry() {
        return wineRepository.quantityByCountries();
    }

    @Override
    public Set<Integer> getYears(Map<String, String> param) {
        return findAllByCriteria(param).stream().map(Wine::getYear).collect(Collectors.toSet());
    }
}
