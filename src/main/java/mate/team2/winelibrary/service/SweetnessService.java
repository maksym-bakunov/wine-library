package mate.team2.winelibrary.service;

import mate.team2.winelibrary.model.Sweetness;

import java.util.List;
import java.util.Optional;

public interface SweetnessService {
    Sweetness add(Sweetness sweetness);

    List<Sweetness> findAllSweetness();

    Sweetness findById(Integer id);
}
