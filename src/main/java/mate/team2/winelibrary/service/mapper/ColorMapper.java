package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.ColorRequestDto;
import mate.team2.winelibrary.dto.response.ColorResponseDto;
import mate.team2.winelibrary.model.Color;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper implements RequestDtoMapper<Color, ColorRequestDto>,
        ResponseDtoMapper<ColorResponseDto, Color> {

    @Override
    public ColorResponseDto mapToDto(Color color) {
        ColorResponseDto colorResponseDto = new ColorResponseDto();
        colorResponseDto.setId(color.getId());
        colorResponseDto.setName(color.getName());
        return colorResponseDto;
    }

    @Override
    public Color mapToModel(ColorRequestDto colorRequestDto) {
        Color color = new Color();
        color.setName(colorRequestDto.getName());
        return color;
    }
}
