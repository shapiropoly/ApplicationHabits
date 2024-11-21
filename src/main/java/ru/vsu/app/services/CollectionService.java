package ru.vsu.app.services;

import ru.vsu.app.models.Collection;

import java.util.List;

public interface CollectionService {
    List<Collection> getAllCollection();

    Collection addCollection(Collection collection);

    Collection updateCollection(Collection collection);

    void deleteCollection(Integer id);

    Collection getCollectionById(Integer id);
}
