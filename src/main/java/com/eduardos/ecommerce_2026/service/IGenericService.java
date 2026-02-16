package com.eduardos.ecommerce_2026.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, RequestDTO, ResponseDTO, ID> {
//    T save(T t) throws Exception;
//    void saveAll(List<T> T) throws Exception;
//    List<T> findAll() throws Exception;
//
//    Optional<T> findById(ID id) throws Exception;
//
//    T update(ID id, T t) throws Exception;
//
//    void delete(ID id) throws Exception;

    // DTOs
    ResponseDTO saveDTO(RequestDTO requestDTO) throws Exception;
    List<ResponseDTO> findAllDTO() throws Exception;
    Optional<ResponseDTO> findByIdDTO(ID id) throws Exception;
    ResponseDTO updateDTO(ID id, RequestDTO requestDTO) throws Exception;
}
