package serialization;

import java.util.List;

public class exampleC {
    private String name;
    private String job;
    private List<String> skills;

    private Addressclass address;
    private ContactClass contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Addressclass getAddress() {
        return address;
    }

    public void setAddress(Addressclass address) {
        this.address = address;
    }

    public ContactClass getContact() {
        return contact;
    }

    public void setContact(ContactClass contact) {
        this.contact = contact;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
