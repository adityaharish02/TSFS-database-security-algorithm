package cryptography;

public class Age 
{
    public String addNoise(String age,char x)
    {
        int a = Integer.parseInt(age) + (int)x - 50;
        String b = String.valueOf(a);
        return b;
    }
    
    public String removeNoise(String age,char x)
    {
        int a = Integer.parseInt(age) - (int)x + 50;
        String b = String.valueOf(a);
        return b;
    }
}
