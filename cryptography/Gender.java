package cryptography;

public class Gender 
{
    public String genderToNumber(String gender)
    {
        String number=new String();
        if(gender.equals("Male"))
            number="5";
        else if(gender.equals("Female"))
            number = "15";
        return number;
    }
    public String numberToGender(String number)
    {
        String gender=new String();
        if(number.equals("5"))
            gender="Male";
        else if(number.equals("15"))
            gender = "Female";
        return gender;
    }
}


