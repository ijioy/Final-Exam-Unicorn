package Company;

import Enum.EJenisKelamin;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Candidate extends Person{
    private String pekerjaanYangdiLamar;
    private LocalDate tglMelamar;
    private BigDecimal permintaanGaji;

    public Candidate(){}
    public Candidate(String namaDepan, String namaBelakang, EJenisKelamin jenisKelamin,
                      LocalDate tanggalLahir, String tempatLahir, String nomorKtp,
                      String pekerjaanYangdiLamar, LocalDate tglMelamar, BigDecimal permintaanGaji){
        super(namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, nomorKtp);
        this.pekerjaanYangdiLamar = pekerjaanYangdiLamar;
        this.tglMelamar = tglMelamar;
        this.permintaanGaji = permintaanGaji;
    }

    @Override
    public void setNomorKtp(String nomorKtp) {
        super.setNomorKtp(nomorKtp);
    }
    @Override
    public String getNomorKtp() {
        return super.getNomorKtp();
    }

    public String printCandidate(){
        return String.format("""
                No Ktp  : %-11s, Nama Candidate : %s %s
                """, this.nomorKtp, this.namaDepan, this.getNamaDepan());
    }
    public void printInfo(){
        System.out.println(String.format("""
                Nama Karyawan       : %s %s
                Jenis kelamin       : %s
                Tanggal Lahir       : %s, Umur : (%s Tahun)
                TempatLahir         : %s
                No Ktp              : %s
                Pekerjaan yang Dilamar  : %s
                Tanggal Melamar     : %s
                Gaji Pokok          : %s
                """, this.namaDepan, this.namaBelakang, this.jenisKelamin,
                formatTanggal(this.tanggalLahir), ChronoUnit.YEARS.between(this.tanggalLahir, LocalDate.now()),
                this.tempatLahir, this.nomorKtp, this.pekerjaanYangdiLamar, formatTanggal(this.tglMelamar),
                formatUang(this.permintaanGaji)));
    }

    public void setPekerjaanYangdiLamar(String pekerjaanYangdiLamar) {
        this.pekerjaanYangdiLamar = pekerjaanYangdiLamar;
    }
    public String getPekerjaanYangdiLamar() {
        return pekerjaanYangdiLamar;
    }

    public void setTglMelamar(LocalDate tglMelamar) {
        this.tglMelamar = tglMelamar;
    }
    public LocalDate getTglMelamar() {
        return tglMelamar;
    }

    public void setPermintaanGaji(BigDecimal permintaanGaji) {
        this.permintaanGaji = permintaanGaji;
    }
    public BigDecimal getPermintaanGaji() {
        return permintaanGaji;
    }
}
