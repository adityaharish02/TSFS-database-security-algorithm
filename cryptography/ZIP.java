package cryptography;

public class ZIP 
{
    public String addNoise(String zip,char x)
    {
        long a = Integer.parseInt(zip) + (int)x * 3;
        String b = String.valueOf(a);
        return b;
    }
    
    public String removeNoise(String zip,char x)
    {
        int a = Integer.parseInt(zip) - (int)x * 3;
        String b = String.valueOf(a);
        return b;
    }
}
