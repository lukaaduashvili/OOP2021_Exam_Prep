package Sem10;

public class FirstNameFilter implements Filter{
    private String firstName;

    public FirstNameFilter(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean filter(Student st) {
        return firstName.equals(st.getFirstName());
    }
}
