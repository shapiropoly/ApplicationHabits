package ru.vsu.app.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Collection;
import ru.vsu.app.repositories.CollectionRepository;
import ru.vsu.app.services.CollectionService;

import jakarta.transaction.Transactional;


import java.util.List;

@AllArgsConstructor
@Service
@Primary
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;

    @Override
    public List<Collection> getAllCollection() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection addCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public Collection updateCollection(Integer id, Collection collection) {
        Collection existingCollection = collectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Коллекция c id: "+ id + " не найдена"));

        existingCollection.setTitle(collection.getTitle());
        existingCollection.setDescription(collection.getDescription());
        existingCollection.setImage(collection.getImage());

        return collectionRepository.save(existingCollection);
    }

    @Transactional
    @Override
    public void deleteCollection(Integer id) {
        collectionRepository.deleteById(id);
    }

    @Override
    public Collection getCollectionById(Integer id) {
        return collectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                "Коллекция c id: "+ id + " не найдена"));
    }
}
