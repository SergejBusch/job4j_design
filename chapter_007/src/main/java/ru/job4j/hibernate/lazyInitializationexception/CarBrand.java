package ru.job4j.hibernate.lazyInitializationexception;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "carBrand")
    private List<CarsModel> models = new ArrayList<>();

    public static CarBrand of(String name) {
        var carBrand = new CarBrand();
        carBrand.name = name;
        return carBrand;
    }

    public void addCarModel(CarsModel carsModel) {
        this.models.add(carsModel);
    }
}
