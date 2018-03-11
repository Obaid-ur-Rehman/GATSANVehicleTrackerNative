package gatsan.vehicletracker.models;

/**
 * Created by XSS on 11/03/2018.
 */

public class device {
    private String name;
    private String uniqueID;
    private String lastUpdate;
    private String model;
    private String contact;
    private String dbID;

    public void setDBID(String id)
    {
        dbID = id;
    }

    public String getDBID()
    {
        return dbID;
    }

    public void setUID(String uid)
    {
        uniqueID = uid;
    }

    public String getID()
    {
        return uniqueID;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public void setLastUpdate(String lu)
    {
        lastUpdate = lu;
    }

    public String getLastUpdate()
    {
        return lastUpdate;
    }

    public void setModel(String m)
    {
        model = m;
    }

    public String getModel()
    {
        return model;
    }

    public void setContact(String c)
    {
        contact = c;
    }

    public String getContact()
    {
        return contact;
    }

    public String toString()
    {
        return "di,"+name + "," + uniqueID + "," + lastUpdate + "," + model + "," + contact;
    }


}