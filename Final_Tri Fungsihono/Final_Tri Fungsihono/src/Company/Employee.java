package Company;

import Enum.EJenisKelamin;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Employee extends Person{
    private String noKaryawan;
    private String posisi;
    private Department department;
    private LocalDate tglMulaiKerja;
    private BigDecimal gajiPokok;

    public Employee(){}
    public Employee(String noKaryawan,String namaDepan, String namaBelakang, EJenisKelamin jenisKelamin,
                    LocalDate tanggalLahir, String tempatLahir, String nomorKtp,
                    String posisi,
                    Department department, LocalDate tglMulaiKerja, BigDecimal gajiPokok){
        super(namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, nomorKtp);
        this.noKaryawan = noKaryawan;
        this.posisi = posisi;
        this.department = department;
        this.tglMulaiKerja = tglMulaiKerja;
        this.gajiPokok = gajiPokok;
    }

    public String printKaryawan(){
        return String.format("""
                No Karyawan : %-6s, Nama Karyawan : %s %s
                """, this.noKaryawan,this.namaDepan, this.namaBelakang);
    }

    public void printInfo(){
        System.out.println(String.format("""
                Nama Karyawan       : %s %s
                Jenis kelamin       : %s
                Tanggal Lahir       : %s, Umur : (%s Tahun)
                TempatLahir         : %s
                No Ktp              : %s
                No Karyawan         : %s
                Department          : %s
                Posisi              : %s
                Tanggal Mulai Kerja : %s, Lama kerja : (%s Tahun)
                Gaji Pokok          : %s
                """, this.namaDepan, this.namaBelakang, this.jenisKelamin,
                formatTanggal(this.tanggalLahir), ChronoUnit.YEARS.between(this.tanggalLahir, LocalDate.now()),
                this.tempatLahir, this.nomorKtp, this.noKaryawan,this.posisi, department.namaDepartment,
                formatTanggal(this.tglMulaiKerja), ChronoUnit.YEARS.between(this.tglMulaiKerja, LocalDate.now()),
                formatUang(this.gajiPokok)));
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    public String getPosisi() {
        return posisi;
    }

    public void setNoKaryawan(String noKaryawan) {
        this.noKaryawan = noKaryawan;
    }
    public String getNoKaryawan() {
        return noKaryawan;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }

    public void setTglMulaiKerja(LocalDate tglMulaiKerja) {
        this.tglMulaiKerja = tglMulaiKerja;
    }
    public LocalDate getTglMulaiKerja() {
        return tglMulaiKerja;
    }

    public void setGajiPokok(BigDecimal gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    public BigDecimal getGajiPokok() {
        return gajiPokok;
    }



}
