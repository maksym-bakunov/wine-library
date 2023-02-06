package mate.team2.winelibrary.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import mate.team2.winelibrary.dto.request.WineRequestDto;
import mate.team2.winelibrary.dto.response.WineResponseDto;
import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.repository.WineRepository;
import mate.team2.winelibrary.service.WineService;
import mate.team2.winelibrary.service.mapper.RequestDtoMapper;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/wines")
public class WineController {
    private final WineService wineService;
    private final ResponseDtoMapper<WineResponseDto, Wine> responseDtoMapper;
    private final RequestDtoMapper<Wine, WineRequestDto> requestDtoMapper;

    public WineController(WineService wineService,
                          ResponseDtoMapper<WineResponseDto, Wine> responseDtoMapper,
                          RequestDtoMapper<Wine, WineRequestDto> requestDtoMapper) {
        this.wineService = wineService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    public WineResponseDto add(@RequestBody @Valid WineRequestDto wineRequestDto) {
        return responseDtoMapper.mapToDto(wineService.add(requestDtoMapper.mapToModel(wineRequestDto)));
    }

    @GetMapping("{id}")
    public WineResponseDto findById(@PathVariable("id") @Min(1) int id) {
        return responseDtoMapper.mapToDto(wineService.findById(id));
    }


    @GetMapping//@ApiOperation("Getting list of wines with pagination and sorting")
    public List<WineResponseDto> getAll(@RequestParam (defaultValue = "20") Integer count,
                                        @RequestParam (defaultValue = "0") Integer page,
                                        @RequestParam (defaultValue = "name") String sortBy,
                                        @RequestParam Map<String, String> param) {

        List<Sort.Order> orders = new ArrayList<>();
        //if (sortBy.contains("")) {
            String[] sortingFields = sortBy.split(";");

            for (String field : sortingFields) {
                Sort.Order order;
                if (field.contains(":")) {
                    String[] fieldAndDirection = field.split(":");
                    order = new Sort.Order(Sort.Direction.valueOf(fieldAndDirection[1]),
                            fieldAndDirection[0]);
                }
                else {
                    order = new Sort.Order(Sort.Direction.ASC, field);
                }
                orders.add(order);
            }
        //} else {
        //    Sort.Order order = new Sort.Order(Sort.Direction.ASC, sortBy);
        //    orders.add(order);
        //}

        Sort sort = Sort.by(orders);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        return wineService.findAllByCriteria(param, pageRequest)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/quantity-by-countries")
    public List<WineRepository.QuantityByCountries> getQtyByCountries() {
        return wineService.findAllQuantityByCountry();
    }

    @GetMapping("/quantity")
    public Long getQuantity(@RequestParam Map<String, String> param) {
        return wineService.getQuantity(param);
    }

    @GetMapping("/years")
    public Set<Integer> findYears(@RequestParam Map<String, String> param) {
        return wineService.getYears(param);
    }
}
