package oop.model.enums;

public enum Gender {
    MAN("Mężczyzna"), WOMAN("Kobieta");

    private final String genderName;

    public String getGenderName() {  //getter pobierający nazwę płci
        return genderName;
    }

    Gender(String genderName) {  //konstruktorv typu wyliczeniowego
        this.genderName = genderName;


    }
}


