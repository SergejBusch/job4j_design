package ru.job4j.hibernate.lazyInitializationexception;

import lombok.Data;
import ru.job4j.hibernate.onetomany.CarModel;

import javax.persistence.*;

@Data
@Entity
public class CarsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand carBrand;

    public static CarsModel of(String name, CarBrand carBrand) {
        var carModel = new CarsModel();
        carModel.name = name;
        carModel.carBrand = carBrand;
        return carModel;
    }
}
