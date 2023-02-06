package mate.team2.winelibrary.service.impl;

import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Sweetness;
import mate.team2.winelibrary.repository.SweetnessRepository;
import mate.team2.winelibrary.service.SweetnessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SweetnessServiceImpl implements SweetnessService {
    private final SweetnessRepository sweetnessRepository;

    public SweetnessServiceImpl(SweetnessRepository sweetnessRepository) {
        this.sweetnessRepository = sweetnessRepository;
    }

    @Override
    public Sweetness add(Sweetness sweetness) {
        return sweetnessRepository.save(sweetness);
    }

    @Override
    public Sweetness findById(Integer id) {
        return sweetnessRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public List<Sweetness> findAllSweetness() {
        return sweetnessRepository.findAll();
    }
}
