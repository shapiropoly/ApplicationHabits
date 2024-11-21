package ru.vsu.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Collection;
import ru.vsu.app.repositories.CollectionRepository;

import java.util.List;

@Service
public class CollectionService {
    private CollectionRepository collectionRepository;

    @Autowired
    public void setCollectionRepository(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public void add(Collection collection) {
        collectionRepository.save(collection);
    }
}
