package ru.job4j.hibernate.onetomany;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarModel> models = new ArrayList<>();

    public static Car of(String name) {
        Car car = new Car();
        car.name = name;
        return car;
    }

    public void addModel(CarModel model) {
        this.models.add(model);
    }

    public void addAllModels(Collection<CarModel> models) {
        this.models.addAll(models);
    }
}
