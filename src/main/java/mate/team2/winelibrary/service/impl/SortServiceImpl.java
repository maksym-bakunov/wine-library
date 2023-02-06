package mate.team2.winelibrary.service.impl;

import mate.team2.winelibrary.dto.request.SortRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Sort;
import mate.team2.winelibrary.repository.SortRepository;
import mate.team2.winelibrary.service.SortService;
import mate.team2.winelibrary.service.mapper.SortMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SortServiceImpl implements SortService {
    private final SortRepository sortRepository;
    private final SortMapper sortMapper;

    public SortServiceImpl(SortRepository sortRepository, SortMapper sortMapper) {
        this.sortRepository = sortRepository;
        this.sortMapper = sortMapper;
    }

    @Override
    public Sort add(SortRequestDto sortRequestDto) {
        Sort sort = sortMapper.mapToModel(sortRequestDto);
        return sortRepository.save(sort);
    }

    @Override
    public List<Sort> findAllSorts() {
        return sortRepository.findAll();
    }

    @Override
    public Sort findById(Integer id) {
        return sortRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
