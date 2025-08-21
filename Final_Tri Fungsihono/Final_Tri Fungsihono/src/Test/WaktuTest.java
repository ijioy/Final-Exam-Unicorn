package Test;

import Company.Candidate;
import Company.Employee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class WaktuTest {
    private Candidate candidateTest;
    private LocalDate tglTest;
    private LocalTime jamTest;
    private Employee pICTest;
    private int durasiTest;
    private int soalTest;

    public WaktuTest(){}
    public WaktuTest(Candidate candidateTest, LocalDate tglTest, LocalTime jamTest, Employee pICTest,
                     int durasiTest, int soalTest){
        this.candidateTest = candidateTest;
        this.tglTest = tglTest;
        this.jamTest = jamTest;
        this.pICTest = pICTest;
        this.durasiTest = durasiTest;
        this.soalTest = soalTest;
    }

    public void printInfo(){
        System.out.println(String.format("""
                        %s %-16s %-15s %-10s %s %-15s %-7s %s 
                        """, candidateTest.getNamaDepan(), candidateTest.getNamaBelakang(),
                formatTanggal(this.tglTest), this.jamTest, pICTest.getNamaDepan(), pICTest.getNamaBelakang(),
                this.durasiTest,  this.soalTest));

    }
    private String formatJam(LocalTime jam){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatJam= jam.format(formatter);
        return  formatJam;
    }
    private String formatTanggal(LocalDate tgl){
        String format;
        Locale indo = new Locale("id", "ID");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", indo);
        format = dateTimeFormatter.format(tgl);
        return format;
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

    public void setDurasiTest(int durasiTest) {
        this.durasiTest = durasiTest;
    }
    public int getDurasiTest() {
        return durasiTest;
    }

    public void setSoalTest(int soalTest) {
        this.soalTest = soalTest;
    }
    public int getSoalTest() {
        return soalTest;
    }
}
