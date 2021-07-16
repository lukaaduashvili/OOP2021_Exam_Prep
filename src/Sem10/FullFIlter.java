package Sem10;

public class FullFIlter implements Filter{
    private String firstName;
    private String lastName;
    private Integer enroll;

    public FullFIlter(String firstName, String lastName, Integer enroll) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enroll = enroll;
    }

    @Override
    public boolean filter(Student st) {
        if(firstName != null && !st.getFirstName().equals(firstName))
            return false;
        if(lastName != null && !st.getLastName().equals(lastName))
            return false;
        if(enroll != null && st.getEnrollmentYear() != enroll)
            return false;

        return true;
    }
}
