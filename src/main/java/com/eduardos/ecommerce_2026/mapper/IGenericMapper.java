package com.eduardos.ecommerce_2026.mapper;

public interface IGenericMapper<T, RequestDTO, ResponseDTO> {

    T toEntity(RequestDTO dto);

    ResponseDTO toResponse(T t);

    void updateEntityFromDto(RequestDTO dto, T t);
}