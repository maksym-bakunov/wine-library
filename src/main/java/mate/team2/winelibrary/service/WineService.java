package mate.team2.winelibrary.service;

import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.repository.WineRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WineService {
    List<Wine> findAll();

    Wine add(Wine wine);

    Wine findById(Integer id);

    Long getQuantity(Map<String, String> param);

    List<Wine> findAllByCriteria(Map<String, String> param);

    List<Wine> findAllByCriteria(Map<String, String> param, PageRequest pageRequest);

    List<WineRepository.QuantityByCountries> findAllQuantityByCountry();

    Set<Integer> getYears(Map<String, String> param);
}
