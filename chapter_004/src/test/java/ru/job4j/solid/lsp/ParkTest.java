package ru.job4j.solid.lsp;

import static org.hamcrest.core.Is.is;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ParkTest {

    @Ignore
    @Test
    public void whenParkTwoTrucksThenFull() {
        var park = new Park27(1, 2);
        assertThat(park.getTruckPlaces(), is(1));
        assertThat(park.getLightCarPlaces(), is(2));
        assertThat(park.canPark(new Truck()), is(true));
        park.park(new Truck());
        park.park(new Truck());
        assertThat(park.getTruckPlaces(), is(0));
        assertThat(park.getLightCarPlaces(), is(0));
        assertThat(park.canPark(new Truck()), is(false));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenNoParkIsFree() {
        var park = new Park27(0, 2);
        park.park(new Truck());
        park.park(new Truck());
    }

    @Ignore
    public void whenParkLightCar() {
        var park = new Park27(0, 1);
        var lc = new LightCar();
        assertThat(park.getLightCarPlaces(), is(1));
        park.park(lc);
        assertThat(park.getLightCarPlaces(), is(0));
    }

}
