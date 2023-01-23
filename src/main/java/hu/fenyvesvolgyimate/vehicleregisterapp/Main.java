package hu.fenyvesvolgyimate.vehicleregisterapp;

import hu.fenyvesvolgyimate.vehicleregisterapp.controller.VehicleController;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.FileVehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.VehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.controller.VehicleConsoleController;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenterImpl;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;
import hu.fenyvesvolgyimate.vehicleregisterapp.view.VehicleConsoleView;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vehicleStorage = new FileVehicleRepository();
        VehiclePresenter vehicleConsolePresenter = new VehiclePresenterImpl();

        VehicleRegister vehicleRegister = new VehicleRegister(vehicleStorage, vehicleConsolePresenter);
        VehicleController vehicleController = new VehicleConsoleController(vehicleRegister, vehicleRegister);

        VehicleConsoleView vehicleConsoleView = new VehicleConsoleView(vehicleController);
        vehicleConsoleView.start();
    }
}