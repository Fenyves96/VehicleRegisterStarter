package org.example;

import org.example.controller.VehicleConsoleController;
import org.example.controller.VehicleController;
import org.example.dao.FileVehicleRepository;
import org.example.dao.VehicleRepository;
import org.example.interactor.JsonVehicleRegister;
import org.example.interactor.VehicleRegister;
import org.example.presenter.VehicleConsolePresenter;
import org.example.presenter.VehicleUserInterface;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleStorage = new FileVehicleRepository();
        VehicleUserInterface vehicleConsolePresenter = new VehicleConsolePresenter();

        VehicleRegister vehicleRegister = new JsonVehicleRegister(vehicleStorage, vehicleConsolePresenter);
        VehicleController vehicleController = new VehicleConsoleController(vehicleRegister);

        vehicleController.start();
    }
}