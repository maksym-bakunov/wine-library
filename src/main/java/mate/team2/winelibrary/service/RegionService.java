package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.RegionRequestDto;
import mate.team2.winelibrary.model.Region;

public interface RegionService {
    Region add(RegionRequestDto regionRequestDto);

    Region fineById(Integer id);

    List<Region> findAllRegions();
}
