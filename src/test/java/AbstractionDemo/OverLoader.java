package AbstractionDemo;

public class OverLoader
{
    public String employeeInfo(String strName,String strSurname)
    {
        String fullName = strName +" "+ strSurname;
        return fullName;
    }

    public String employeeInfo(String strName,String strSurname,String empNum)
    {
        String fullName = strName +" "+ strSurname +" "+ empNum;
        return fullName;
    }


}
