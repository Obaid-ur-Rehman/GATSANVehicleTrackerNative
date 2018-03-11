package gatsan.vehicletracker.models;

/**
 * Created by XSS on 11/03/2018.
 */

public class user {
    private String name, email, phone, expirationTime;

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }

    public void setEmail(String e)
    {
        email = e;
    }
    public String getEmail()
    {
        return email;
    }

    public void setPhone(String p)
    {
        phone = p;
    }
    public String getPhone()
    {
        return phone;
    }

    public void setExpirationTime(String et)
    {
        expirationTime = et;
    }
    public String getExpirationTime()
    {
        return expirationTime;
    }

    public String toString()
    {
        return name + "," + email + "," + phone + "," + expirationTime;
    }
}
