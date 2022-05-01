package org.tms.test;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.model.Car;

@Log4j2
public class CarTest {

  @Test
  public void compareCarTest() {
    Car car1 = new Car("bmw", "3", "red");
    Car car2 = new Car("bmw", "3", "red");
    Car car3 = new Car();
    car3.setColor("red");
    car3.setBrand("bmw");
    car3.setModel("3");
    Car car4 = Car.builder()
        .brand("bmw")
        .model("3")
        .color("red")
        .build();
    Assert.assertEquals(car1, car4);
  }

  @Test
  public void loggerTest() {
    log.fatal("fatal");
    log.error("error");
    log.warn("warn");
    log.info("info");
    log.debug("debug");
    log.trace("trace");
  }

}
