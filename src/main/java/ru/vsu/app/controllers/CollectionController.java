package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Collection;
import ru.vsu.app.services.CollectionService;

import java.util.List;

@RequestMapping("/api/v1/")
@AllArgsConstructor
@RestController
public class CollectionController {

    private final CollectionService collectionService;

    // получить список коллекций
    @GetMapping("collections")
    public List<Collection> listCollection() {
        return collectionService.getAllCollection();
    }

    // добавить коллекцию
    @PostMapping("add_collection")
    public Collection addCollection(@RequestBody Collection collection) {
        return collectionService.addCollection(collection);
    }

    // изменить коллекцию
    @PutMapping("update_collection/{id}")
    public Collection updateCollection(@PathVariable Integer id,
                                       @RequestBody Collection collection) {
        return collectionService.updateCollection(id, collection);
    }

    // удалить коллекцию
    @DeleteMapping("delete_collection/{id}")
    public void deleteCollection(@PathVariable Integer id) {
        collectionService.deleteCollection(id);
    }

    // получить коллекцию по id
    @GetMapping("collections/{id}")
    public Collection getCollectionById(@PathVariable Integer id) {
        return collectionService.getCollectionById(id);
    }
}
