package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.ColorRequestDto;
import mate.team2.winelibrary.model.Color;

public interface ColorService {
    Color add(ColorRequestDto colorRequestDto);

    List<Color> findAllColors();

    Color findById(Integer id);
}
