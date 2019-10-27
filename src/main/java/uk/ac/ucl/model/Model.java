package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Model
{
  // The example code in this class should be replaced by your Model class code.
  private List<Patient> patients;
  public Model(){
    this.patients = new ArrayList<>();
  }

  //Separate the patients list data into pages
  public List<Patient> getPatientsbyPages(List<Patient> list,int start, int interval)
  {
    List<Patient> page = new ArrayList<>();
    for(int i = start; i < (start + interval); i++){
      if(i<list.size()) {
        page.add(list.get(i));
      }
    }
    return page;
  }

  public List<Patient> getYoungest(){
    List<Patient> youngest = new ArrayList<>();
    youngest.add(patients.get(0));
    for(Patient patient: patients){
      if(youngest.get(0).getAge() > patient.getAge()){
        youngest.clear();
        youngest.add(patient);
      }
      else if(youngest.get(0).getAge() == patient.getAge()){
        youngest.add(patient);
      }
    }
    return youngest;
  }

  public List<Patient> getOldest(){
    List<Patient> oldest = new ArrayList<>();
    oldest.add(patients.get(0));
    for(Patient patient: patients){
      if(oldest.get(0).getAge() < patient.getAge()){
        oldest.clear();
        oldest.add(patient);
      }
      else if(oldest.get(0).getAge() == patient.getAge()){
        oldest.add(patient);
      }
    }
    return oldest;
  }

  public String getAverageAge(){
    double total = 0;
    int size = patients.size();
    DecimalFormat df = new DecimalFormat("#.##");
    for(Patient patient : patients){
      total += patient.getAge();
    }
    double average = total/size;
    String averageAge = df.format(average);
    return averageAge;
  }

  public int getChildren(){
    int count = 0;
    for(Patient patient: patients){
      if(patient.getAge() <= 12){
        count += 1;
      }
    }
    return count;
  }

  public int getTeenagers(){
    int count = 0;
    for(Patient patient: patients){
      if(patient.getAge() >= 13 && patient.getAge() <= 17){
        count += 1;
      }
    }
    return count;
  }

  public int getAdults(){
    int count = 0;
    for(Patient patient: patients){
      if(patient.getAge() >= 18 && patient.getAge() <= 59){
        count += 1;
      }
    }
    return count;
  }

  public int getElders(){
    int count = 0;
    for(Patient patient: patients){
      if(patient.getAge() >= 60){
        count += 1;
      }
    }
    return count;
  }

  public List<Patient> filterByGender(List<Patient> list, String gender){
    List<Patient> results = new ArrayList<>();
    for(Patient patient: list){
      if(gender.equals("M") && patient.getGender().equals("M")){
        results.add(patient);
      }
      else if(gender.equals("F") && patient.getGender().equals("F")){
        results.add(patient);
      }
      else if(gender.equals("both")){
        results.add(patient);
      }
    }
    return results;
  }

  public List<Patient> filterByAge(List<Patient> list, int minAge, int maxAge){
    List<Patient> results = new ArrayList<>();
    for(Patient patient: list){
      if(patient.getAge() >= minAge && patient.getAge() <= maxAge){
        results.add(patient);
      }
    }
    return results;

  }

  public List<Patient> getPatients(){ return patients;}

  public int getNoOfPatients(){ return patients.size();}

  public String displayData(String id){
    StringBuilder sb = new StringBuilder("");
    for(Patient patient : patients){
      if (id.compareTo(patient.getId()) == 0){
        sb.append("id: " + patient.getId() + "\n");
        sb.append("birthdate: " + patient.getBirthdate() + "\n");
        sb.append("deathdate: " + patient.getDeathdate() + "\n");
        sb.append("ssn: " + patient.getSsn() + "\n");
        sb.append("drivers : " + patient.getDrivers() + "\n");
        sb.append("passport: " + patient.getPassport() + "\n");
        sb.append("prefix: " + patient.getPrefix() + "\n");
        sb.append("first: " + patient.getFirst() + "\n");
        sb.append("last: " + patient.getLast() + "\n");
        sb.append("suffix: " + patient.getSuffix() + "\n");
        sb.append("maiden: " + patient.getMaiden() + "\n");
        sb.append("marital: " + patient.getMarital() + "\n");
        sb.append("race: " + patient.getRace() + "\n");
        sb.append("ethnicity: " + patient.getEthnicity() + "\n");
        sb.append("gender: " + patient.getGender() + "\n");
        sb.append("birthplace: " + patient.getBirthplace() + "\n");
        sb.append("address: " + patient.getAddress() + "\n");
        sb.append("city: " + patient.getCity() + "\n");
        sb.append("state: " + patient.getState() + "\n");
        sb.append("zip: " + patient.getZip());
      }
    }
    return sb.toString();

  }

  public List<Patient> search(String keyword, String value){
      List<Patient> results = new ArrayList<>();
      for(Patient patient : patients){
          if(value.compareTo("name") == 0 && patient.getName().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("id") == 0 && patient.getId().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("birthdate") == 0 && patient.getBirthdate().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("deathdate") == 0 && patient.getDeathdate().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("ssn") == 0 && patient.getSsn().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("drivers") == 0 && patient.getDrivers().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("passport") == 0 && patient.getPassport().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("prefix") == 0 && patient.getPrefix().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("suffix") == 0 && patient.getSuffix().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("maiden") == 0 && patient.getMaiden().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("marital") == 0 && patient.getMarital().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("race") == 0 && patient.getRace().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("ethnicity") == 0 && patient.getEthnicity().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("birthplace") == 0 && patient.getBirthplace().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("address") == 0 && patient.getAddress().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("city") == 0 && patient.getCity().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("state") == 0 && patient.getState().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
          else if(value.compareTo("zip") == 0 && patient.getZip().toLowerCase().contains(keyword.toLowerCase())){
              results.add(patient);
          }
      }
      return results;
  }

    public String convertStreamtoString(InputStream inputStream) throws IOException
    {
        String csvContent = new String();
        int data = inputStream.read();
        while(data != -1)
        {
            char aChar = (char) data;
            csvContent += aChar;
            data = inputStream.read();
        }
        inputStream.close();
        return csvContent;
    }

  public void readFile(String csvContent) throws IOException
  {
    patients.clear();
    ReadCSV csv = new ReadCSV();
    patients = csv.readCSV(csvContent);
  }

  public void readFile(File file) throws IOException
  {
      patients.clear();
      ReadCSV csv = new ReadCSV();
      patients = csv.readCSV(file);
  }

}
