package mate.team2.winelibrary.service;

import java.util.List;
import java.util.Optional;
import mate.team2.winelibrary.dto.request.SortRequestDto;
import mate.team2.winelibrary.model.Sort;

public interface SortService {
    Sort add(SortRequestDto sortRequestDto);

    List<Sort> findAllSorts();

    Sort findById(Integer id);
}
