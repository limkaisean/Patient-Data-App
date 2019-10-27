package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadCSV {

    private List<Patient> patients = new ArrayList<>();

    //ReadCSV file to take in a String instead of a file.
    public List<Patient> readCSV(String csv) {
        String[] lines = csv.split("\\r?\\n");
        for(int i=1; i < lines.length; i++){
            createPatient(lines[i]);
        }
        return patients;
    }

    public List<Patient> readCSV(File file) throws IOException{
        var path = Paths.get(file.getAbsolutePath());
        Stream<String> lines = Files.lines(path);
        lines.skip(1).forEach(line -> createPatient(line));
        return patients;
    }
    private void createPatient(String line){
        String[] datas = line.split(",", -1);
        Patient patient = new Patient(datas);
        patients.add(patient);
    }


}
