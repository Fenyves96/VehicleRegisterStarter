package hu.fenyvesvolgyimate.vehicleregisterapp;

import hu.fenyvesvolgyimate.vehicleregisterapp.controller.VehicleController;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.FileVehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.VehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.JsonVehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.controller.VehicleConsoleController;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehicleConsolePresenter;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehicleUserInterface;
import hu.fenyvesvolgyimate.vehicleregisterapp.view.VehicleConsoleView;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleStorage = new FileVehicleRepository();
        VehicleUserInterface vehicleConsolePresenter = new VehicleConsolePresenter();

        VehicleRegister vehicleRegister = new JsonVehicleRegister(vehicleStorage, vehicleConsolePresenter);
        VehicleController vehicleController = new VehicleConsoleController(vehicleRegister);

        VehicleConsoleView vehicleConsoleView = new VehicleConsoleView(vehicleController);
        vehicleConsoleView.start();
    }
}