package uk.ac.ucl.model;

public class Patient {

    private String id;
    private String birthdate;
    private String deathdate;
    private String ssn;
    private String drivers;
    private String passport;
    private String prefix;
    private String first;
    private String last;
    private String suffix;
    private String maiden;
    private String marital;
    private String race;
    private String ethnicity;
    private String gender;
    private String birthplace;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Patient(String[] data){
        this.id = data[0];
        this.birthdate = data[1];
        this.deathdate = data[2];
        this.ssn = data[3];
        this.drivers = data[4];
        this.passport = data[5];
        this.prefix = data[6];
        this.first = data[7];
        this.last = data[8];
        this.suffix = data[9];
        this.maiden = data[10];
        this.marital = data[11];
        this.race = data[12];
        this.ethnicity = data[13];
        this.gender = data[14];
        this.birthplace = data[15];
        this.address = data[16];
        this.city = data[17];
        this.state = data[18];
        this.zip = data[19];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(String deathdate) {
        this.deathdate = deathdate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getAge(){
        String birthdate = this.birthdate;
        String deathdate = this.deathdate;
        int birthYear = Integer.parseInt(birthdate.substring(0,4));
        if(deathdate.equals("")){
            return 2019 - birthYear;
        }
        int deathYear = Integer.parseInt(deathdate.substring(0,4));
        return deathYear - birthYear;
    }

    public String getName(){
        return getFirst() + " " + getLast();
    }
}
