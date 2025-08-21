package Interview;

import Company.Candidate;
import Company.Employee;
import Company.Person;

import java.time.LocalDate;
import java.time.LocalTime;

public class JadwalInterview {
    private Candidate candidate;
    private LocalDate tglTest;
    private LocalTime jamTest;
    private Employee pICTest;

    public JadwalInterview(){}
    public JadwalInterview(Candidate candidate, LocalDate tglTest, LocalTime jamTest, Employee pICTest){
        this.candidate = candidate;
        this.tglTest = tglTest;
        this.jamTest = jamTest;
        this.pICTest = pICTest;
    }
    public void printInfo(){
        System.out.println(String.format("""
                %s %-14s %-16s %-10s %s %s
                """, candidate.getNamaDepan(), candidate.getNamaBelakang(),
                Person.formatTanggal(this.tglTest), this.jamTest, pICTest.getNamaDepan(), pICTest.getNamaBelakang()));
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    public Candidate getCandidate() {
        return candidate;
    }

    public void setTglTest(LocalDate tglTest) {
        this.tglTest = tglTest;
    }
    public LocalDate getTglTest() {
        return tglTest;
    }

    public void setJamTest(LocalTime jamTest) {
        this.jamTest = jamTest;
    }
    public LocalTime getJamTest() {
        return jamTest;
    }

    public void setpICTest(Employee pICTest) {
        this.pICTest = pICTest;
    }
    public Employee getpICTest() {
        return pICTest;
    }
}
