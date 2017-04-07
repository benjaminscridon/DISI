package model;

/**
 * Created by Beniamin on 4/6/2017.
 */
public enum InputFilesEnum {
    FILE_1("eil51.tsp"),
    FILE_2("eil76.tsp"),
    FILE_3("eil101.tsp"),
    FILE_4("a280.tsp"),
    FILE_5("nrw1379.tsp");

    private final String name;

    InputFilesEnum(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}

