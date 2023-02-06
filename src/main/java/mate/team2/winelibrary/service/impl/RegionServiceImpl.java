package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.RegionRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Region;
import mate.team2.winelibrary.repository.RegionRepository;
import mate.team2.winelibrary.service.RegionService;
import mate.team2.winelibrary.service.mapper.RegionMapper;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public RegionServiceImpl(RegionRepository regionRepository, RegionMapper regionMapper) {
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper;
    }

    @Override
    public Region add(RegionRequestDto regionRequestDto) {
        return regionRepository.save(regionMapper.mapToModel(regionRequestDto));
    }

    @Override
    public Region fineById(Integer id) {
        return regionRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findAll();
    }
}
