package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.ColorRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Color;
import mate.team2.winelibrary.repository.ColorRepository;
import mate.team2.winelibrary.service.ColorService;
import mate.team2.winelibrary.service.mapper.ColorMapper;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    public ColorServiceImpl(ColorRepository colorRepository, ColorMapper colorMapper) {
        this.colorRepository = colorRepository;
        this.colorMapper = colorMapper;
    }

    @Override
    public Color add(ColorRequestDto colorRequestDto) {
        Color color = colorMapper.mapToModel(colorRequestDto);
        return colorRepository.save(color);
    }

    @Override
    public List<Color> findAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color findById(Integer id) {
        return colorRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
