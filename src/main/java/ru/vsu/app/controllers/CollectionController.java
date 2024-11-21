package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Collection;
import ru.vsu.app.services.CollectionService;

import java.util.List;

@Controller
@RequestMapping("/collections")
@AllArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    // получить список коллекций
    @GetMapping
    public List<Collection> listCollection() {
        return collectionService.getAllCollection();
    }

    // добавить коллекцию
    @PostMapping("add_collection")
    public Collection addCollection(@RequestBody Collection collection) {
        return collectionService.addCollection(collection);
    }

    // изменить коллекцию
    @PutMapping("update_collection")
    public Collection updateCollection(Collection collection) {
        return collectionService.updateCollection(collection);
    }

    // удалить коллекцию
    @DeleteMapping("delete_collection/{id}")
    public void deleteCollection(@PathVariable Integer id) {
        collectionService.deleteCollection(id);
    }

    // получить коллекцию по id
    @GetMapping("/{id}")
    public Collection getCollectionById(@PathVariable Integer id) {
        return collectionService.getCollectionById(id);
    }
}
