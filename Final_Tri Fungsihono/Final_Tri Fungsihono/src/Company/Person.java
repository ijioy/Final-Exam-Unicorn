package Company;

import Enum.EJenisKelamin;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Person {
    protected String namaDepan;
    protected String namaBelakang;
    protected EJenisKelamin jenisKelamin;
    protected LocalDate tanggalLahir;
    protected String tempatLahir;
    protected String nomorKtp;

    public Person(){}
    public Person(String namaDepan, String namaBelakang, EJenisKelamin jenisKelamin, LocalDate tanggalLahir,
                  String tempatLahir, String nomorKtp){
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;;
        this.tempatLahir = tempatLahir;
        this.nomorKtp = nomorKtp;
    }

    public static String formatValue(Object value, Locale locale) {
        if (value instanceof LocalDate) {
            LocalDate date = (LocalDate) value;
            // Format date based on the provided locale
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                    .withLocale(locale);
            return date.format(dateFormatter);
        } else if (value instanceof BigDecimal) {
            BigDecimal amount = (BigDecimal) value;
            // Format currency based on the provided locale
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            return currencyFormatter.format(amount);
        } else {
            // Handle unsupported types or throw an exception
            return "Unsupported type";
        }
    }

    public static String formatTanggal(LocalDate tgl){
        String format;
        Locale indo = new Locale("id", "ID");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", indo);
        format = dateTimeFormatter.format(tgl);
        return format;
    }
    public String formatUang(BigDecimal uang) {
        Locale indo = new Locale("id", "ID");
        String currencyFormat = NumberFormat.getCurrencyInstance(indo).format(uang); // format tidak bisa menerima value null
        return currencyFormat;
    }


    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }
    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }
    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setJenisKelamin(EJenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public EJenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }
    public String getNomorKtp() {
        return nomorKtp;
    }
}
