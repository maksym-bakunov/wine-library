package mate.team2.winelibrary.service.mapper;

public interface RequestDtoMapper <D, T>{
    D mapToModel(T t);
}
