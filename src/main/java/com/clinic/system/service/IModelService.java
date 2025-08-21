package com.clinic.system.service;

import java.util.List;

public interface IModelService<R,ID, Q,U> {
    List<R> findAll();

    R findById(ID id);

    R create(Q request);

    R update(ID id, U request);

    void delete(ID id);
}
