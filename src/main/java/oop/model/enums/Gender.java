package oop.model.enums;

public enum Gender {
    MAN("Mężczyzna"), WOMAN("Kobieta");

    private final String genderName;

    public String getGenderName() {  //getter pobierający nazwę płci
        return genderName;
    }

    Gender(String genderName) {  //konstruktorrvtypu wyliczeniowego
        this.genderName = genderName;


    }
}


