public class Contractor {

    private String name = "";      // The Contractor Name. Note: A single word
    private String location = "";  // City Location.
    private int ownerID;     // The Owner Id.

    public Contractor() {

    }

    public Contractor(String name, String location, int ownerID) {
        setName(name);
        setLocation(location);
        setOwnerID(ownerID);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", name, location, ownerID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
