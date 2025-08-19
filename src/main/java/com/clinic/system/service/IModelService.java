package com.clinic.system.service;

import java.util.List;

public interface IModelService<R,ID, Q,U> {
    List<R> findAll();

    R findById(Long ID);

    R create(Q request);

    R update(Long ID, U request);

    void delete(Long ID);
}
