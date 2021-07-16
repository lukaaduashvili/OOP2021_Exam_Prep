package Sem10;

public class EnrollementFilter implements Filter{
    private int enroll;

    public EnrollementFilter(int enroll) {
        this.enroll = enroll;
    }

    @Override
    public boolean filter(Student st) {
        return enroll == st.getEnrollmentYear();
    }
}
