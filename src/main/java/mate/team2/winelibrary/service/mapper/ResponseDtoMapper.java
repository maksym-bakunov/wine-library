package mate.team2.winelibrary.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
