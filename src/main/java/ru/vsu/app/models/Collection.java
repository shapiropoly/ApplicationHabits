//package ru.vsu.app.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "collections")
//public class Collection {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "collection_id", nullable = false)
//    private int id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "image")
//    private String image;
//
//
//    public Collection() {
//    }
//
//    public Collection(int id, String title, String description, String image) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.image = image;
//    }
//}
