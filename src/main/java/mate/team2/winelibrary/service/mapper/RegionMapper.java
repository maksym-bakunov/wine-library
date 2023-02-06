package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.RegionRequestDto;
import mate.team2.winelibrary.dto.response.RegionResponseDto;
import mate.team2.winelibrary.model.Region;
import mate.team2.winelibrary.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper implements RequestDtoMapper< Region, RegionRequestDto>,
        ResponseDtoMapper<RegionResponseDto, Region> {

    private final CountryService countryService;

    public RegionMapper(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public RegionResponseDto mapToDto(Region region) {
        RegionResponseDto regionResponseDto = new RegionResponseDto();
        regionResponseDto.setId(region.getId());
        regionResponseDto.setName(region.getName());
        regionResponseDto.setCountry(region.getCountry());
        return regionResponseDto;
    }

    @Override
    public Region mapToModel(RegionRequestDto regionRequestDto) {
        Region region = new Region();
        region.setName(regionRequestDto.getName());
        region.setCountry(countryService.findById(regionRequestDto.getCountryId()));
        return region;
    }
}
