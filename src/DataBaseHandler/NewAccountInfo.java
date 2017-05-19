/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseHandler;

/**
 *
 * @author blj0011
 */
public class NewAccountInfo
{
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private double iniCheckingDeposit;
    private double iniSavingsDeposite;
    private boolean createChecking;
    private boolean createSavings;

    
    public NewAccountInfo()
    {
        
    }
    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip)
    {
        this.zip = zip;
    }

    /**
     * @return the iniCheckingDeposit
     */
    public double getIniCheckingDeposit()
    {
        return iniCheckingDeposit;
    }

    /**
     * @param iniCheckingDeposit the iniCheckingDeposit to set
     */
    public void setIniCheckingDeposit(double iniCheckingDeposit)
    {
        this.iniCheckingDeposit = iniCheckingDeposit;
    }

    /**
     * @return the iniSavingsDeposite
     */
    public double getIniSavingsDeposite()
    {
        return iniSavingsDeposite;
    }

    /**
     * @param iniSavingsDeposite the iniSavingsDeposite to set
     */
    public void setIniSavingsDeposite(double iniSavingsDeposite)
    {
        this.iniSavingsDeposite = iniSavingsDeposite;
    }

    /**
     * @return the createChecking
     */
    public boolean isCreateChecking()
    {
        return createChecking;
    }

    /**
     * @param createChecking the createChecking to set
     */
    public void setCreateChecking(boolean createChecking)
    {
        this.createChecking = createChecking;
    }

    /**
     * @return the createSavings
     */
    public boolean isCreateSavings()
    {
        return createSavings;
    }

    /**
     * @param createSavings the createSavings to set
     */
    public void setCreateSavings(boolean createSavings)
    {
        this.createSavings = createSavings;
    }
    
}
