package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.SortRequestDto;
import mate.team2.winelibrary.dto.response.SortResponseDto;
import mate.team2.winelibrary.model.Sort;
import org.springframework.stereotype.Component;

@Component
public class SortMapper  implements RequestDtoMapper<Sort, SortRequestDto>,
        ResponseDtoMapper<SortResponseDto, Sort> {

    @Override
    public SortResponseDto mapToDto(Sort sort) {
        SortResponseDto sortResponseDto = new SortResponseDto();
        sortResponseDto.setId(sort.getId());
        sortResponseDto.setName(sort.getName());
        return sortResponseDto;
    }

    @Override
    public Sort mapToModel(SortRequestDto sortRequestDto) {
        Sort sort = new Sort();
        sort.setName(sortRequestDto.getName());
        return sort;
    }
}
