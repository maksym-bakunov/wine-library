package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.SweetnessRequestDto;
import mate.team2.winelibrary.dto.response.SweetnessResponseDto;
import mate.team2.winelibrary.model.Sweetness;
import org.springframework.stereotype.Component;

@Component
public class SweetnessMapper implements RequestDtoMapper<Sweetness, SweetnessRequestDto>,
        ResponseDtoMapper<SweetnessResponseDto, Sweetness> {
    @Override
    public Sweetness mapToModel(SweetnessRequestDto sweetnessRequestDto) {
        Sweetness sweetness = new Sweetness();
        sweetness.setName(sweetnessRequestDto.getName());
        return sweetness;
    }

    @Override
    public SweetnessResponseDto mapToDto(Sweetness sweetness) {
        SweetnessResponseDto sweetnessResponseDto = new SweetnessResponseDto();
        sweetnessResponseDto.setId(sweetness.getId());
        sweetnessResponseDto.setName(sweetness.getName());
        return sweetnessResponseDto;
    }
}
