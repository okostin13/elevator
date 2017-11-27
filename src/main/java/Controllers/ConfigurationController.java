package Controllers;

import Configurators.*;
import Core.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConfigurationController implements Controller {


    private BuildingConfigurator buildingConfigurator;
    private ElevatorsConfigurator elevatorsConfigurator;
    private ShaftConfigrator shaftConfigrator;
    private FloorConfigurator floorConfigurator;
    private PersonsConfigurator personsConfigurator;


    private Building building;
    private List<Shaft> shafts;
    private List<Floor> floors;
    private List<Elevator> elevators;

    public Building getBuilding() {
        return building;
    }

    public List<Shaft> getShafts() {
        return shafts;
    }

    public List<Floor> getFloors() {
        return floors;
    }


    public List<Elevator> getElevators() {
        return elevators;
    }

    public List<Person> getPersons() {
        return persons;
    }

    private List<Person> persons;

    public void configAll() {

        buildingConfigurator = new BuildingConfigurator();

        building = buildingConfigurator.configure().get(0);

        floorConfigurator = new FloorConfigurator(building);

        shaftConfigrator = new ShaftConfigrator(building);

        personsConfigurator = new PersonsConfigurator(building);

        floors = floorConfigurator.configure();

        shafts = shaftConfigrator.configure();

        elevatorsConfigurator = new ElevatorsConfigurator(shafts, building);

        elevators = elevatorsConfigurator.configure();

        persons = personsConfigurator.configure();

        floorConfigurator.addPersons(persons);

    }
}
