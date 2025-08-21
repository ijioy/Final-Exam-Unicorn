import Company.Candidate;
import Company.Department;

import Company.Employee;
import Enum.EJenisKelamin;
import Interview.JadwalInterview;
import Test.Soal;
import Test.WaktuTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class Recruitment {
    private static Scanner scan = new Scanner(System.in);
    private static LinkedList<Department> daftarDepartment = new LinkedList<>();
    private static HashMap<String, Candidate> daftarCandidate = new HashMap<>();
    private static TreeMap<String, Employee> daftarEmployee = new TreeMap<>();
    private static LinkedList<JadwalInterview> daftarInterview = new LinkedList<>();
    private static LinkedList<WaktuTest> daftarTest = new LinkedList<>();
    public static LinkedList<Soal> tipeSoal = new LinkedList<>();

    public static void main(){
        inputDepartment();
        inputCandidate();
        inputEmployee();
        inputSoal();
        menuUtama();

    }
    public static void inputDepartment(){
        daftarDepartment.add(new Department("IT Department","Walter McConkey", 5, 1));
        daftarDepartment.add(new Department("Finance Department","Irma Spencer", 2, 1));
        daftarDepartment.add(new Department("HR Department","Charlie Meyer", 6, 2));
    }
    public static void inputCandidate(){
        daftarCandidate.put("9187439271",new Candidate("Amos", "Pike", EJenisKelamin.L,
                LocalDate.of(1991, 12, 2), "Kokomo", "9187439271",
                "Programmer", LocalDate.of(2018, 11, 1), new BigDecimal(10_000_000)));

        daftarCandidate.put("8231749873",new Candidate("Brenda", "Cavin", EJenisKelamin.P,
                LocalDate.of(1951, 11, 28), "New York", "8231749873",
                "Accountant", LocalDate.of(2018, 11, 4), new BigDecimal(15_000_000)));

        daftarCandidate.put("1234913279",new Candidate("Billy", "Smith", EJenisKelamin.L,
                LocalDate.of(1966, 8, 18), "Redmond", "1234913279",
                "Salesman", LocalDate.of(2018, 10, 10), new BigDecimal(12_000_000)));

        daftarCandidate.put("1793741932",new Candidate("Joseph", "Barnes", EJenisKelamin.L,
                LocalDate.of(1996, 8, 1), "New York", "1793741932",
                "Programmer", LocalDate.of(2018, 11, 4), new BigDecimal(13_000_000)));

        daftarCandidate.put("2779348728",new Candidate("Eloise", "Stites", EJenisKelamin.P,
                LocalDate.of(1941, 7, 14), "Southfield", "2779348728",
                "Salesman", LocalDate.of(2018, 11, 1), new BigDecimal(15_000_000)));

        daftarCandidate.put("8934712934",new Candidate("Allie", "Gordon", EJenisKelamin.P,
                LocalDate.of(1974, 2, 12), "Southfield", "8934712934",
                "Programmer", LocalDate.of(2018, 11, 4), new BigDecimal(11_000_000)));

        daftarCandidate.put("8927347778",new Candidate("Cynthia", "Thompson", EJenisKelamin.P,
                LocalDate.of(1987, 11, 22), "Chandler", "8927347778",
                "Manager", LocalDate.of(2018, 11, 1), new BigDecimal(10_000_000)));

    }
    public static void inputEmployee(){
        daftarEmployee.put("1234", new Employee("1234", "Harda", "Tamu", EJenisKelamin.L,
                LocalDate.of(2000, 11, 1), "Wonosobo","1234567890123456", "Programmer",
                daftarDepartment.get(0), LocalDate.of(2024, 12, 1), new BigDecimal(8_000_000)));
        daftarEmployee.put("1256", new Employee("1256", "Dila", "Dila", EJenisKelamin.L,
                LocalDate.of(2000, 8, 1), "Palembang","1234567890098765","Salesman",
                daftarDepartment.get(0), LocalDate.of(2024, 10, 2), new BigDecimal(8_300_000)));
        daftarEmployee.put("1278", new Employee("1278", "Tom", "Lembong", EJenisKelamin.L,
                LocalDate.of(1996, 11, 1), "Jakarta","1234567890234567", "Accountant",
                daftarDepartment.get(1), LocalDate.of(2024, 1, 5), new BigDecimal(9_000_000)));
        daftarEmployee.put("1290", new Employee("1290", "Ahok", "Hoka", EJenisKelamin.L,
                LocalDate.of(1988, 12, 1), "Batam","1234567890876543","Programmer",
                daftarDepartment.get(2), LocalDate.of(2022, 8, 4), new BigDecimal(10_000_000)));

    }
    public static void inputSoal(){
        tipeSoal.add(new Soal(String.format("""
                1 + 1 =
                """)));
        tipeSoal.add(new Soal(String.format("""
                1 x 5 =
                """)));
        tipeSoal.add(new Soal(String.format("""
                5 / 1 =
                """)));
        tipeSoal.add(new Soal(String.format("""
                6 - 100 =
                """)));
    }

    public static void menuUtama(){
        System.out.print(String.format("""
                        1. Daftar Kandidat
                        2. Daftar Karyawan
                        3. Membuat Waktu/Detail Interview Kandidat
                        4. Membuat Waktu/Detail Test Kandidat
                        5. Menerima Kandidat
                        6. List Interview dan Test
                        7. Exit
                        Pilih Inputan >>>"""));
        int menu = Integer.parseInt(scan.nextLine().trim());
        switch (menu){
            case 1:
                daftarKandidat();
                menuUtama();
            case 2:
                daftarKaryawan();
                menuUtama();
            case 3:
                jadwalInterview();
                menuUtama();
            case 4:
                jadwalTest();
                menuUtama();
            case 5:
                tambahKaryawan();
                menuUtama();
            case 6:
                printInfoInterviewdanTest();
                menuUtama();
            case 7:
                break;
            default:
                menuUtama();
        }
    }
    public static void daftarKandidat(){
        System.out.println("====================Daftar Kandidat====================");
        int no = 1;
        for (Candidate candidate: daftarCandidate.values()){
            System.out.print(no++ +". "+candidate.printCandidate());
        }
        System.out.println("=======================================================");
        System.out.print(String.format("""
                        1. Melihat Detail Kandidat
                        2. Menu Utama
                        Pilih Inputan >>>"""));
        int menu = Integer.parseInt(scan.nextLine().trim());
        switch (menu){
            case 1:
                printCandidate();
            case 2:
                menuUtama();
            default:
                daftarKandidat();
        }
    }
    public static void printCandidate(){
        boolean isBreak = false;
        do {
            try {
                System.out.print("Masukkan No Ktp Candidate : ");
                String ktp = scan.nextLine().trim();
                for (Candidate calon:daftarCandidate.values()){
                    if (calon.getNomorKtp().equalsIgnoreCase(ktp)){
                        System.out.println("=======================================================");
                        calon.printInfo();
                        isBreak = true;
                    }
                }
                System.out.println("=======================================================");
            }catch (Exception e){
                System.out.println("Masukkan No Ktp Dengan Benar");
            }
        }while (!isBreak);
    }

    public static void daftarKaryawan(){
        System.out.println("====================Daftar Karyawan====================");
        int no = 1;
        for (Employee employee: daftarEmployee.values()){
            System.out.print(no++ +". "+employee.printKaryawan());
        }
        System.out.println("=======================================================");
        System.out.print(String.format("""
                        1. Melihat Detail Karyawan
                        2. Menu Utama
                        Pilih Inputan >>>"""));
        int menu = Integer.parseInt(scan.nextLine().trim());
        switch (menu){
            case 1:
                printKaryawan();
            case 2:
                menuUtama();
            default:
                daftarKaryawan();
        }
    }
    public static void printKaryawan(){
        boolean isBreak = false;
        do {
            try {
                System.out.print("Masukkan No Karyawan Pegawai : ");
                String noKaryawan = scan.nextLine().trim();
                for (Employee employee:daftarEmployee.values()){
                    if (employee.getNoKaryawan().equals(noKaryawan)){
                        System.out.println("=======================================================");
                        employee.printInfo();
                        isBreak = true;
                    }
                }
                System.out.println("=======================================================");
            }catch (Exception e){
                System.out.println("Masukkan No Karyawan Dengan Benar"+ e.getMessage());
            }
        }while (!isBreak);
    }

    public static void jadwalInterview(){
        boolean jadwal = false;
        String kandidat = null;
        boolean adaKandidat = false;
        Candidate selectedCandidate = null;
        do {
            System.out.println("=======================================================");
            int no = 1;
            for (Candidate candidate: daftarCandidate.values()){
                System.out.print(no++ +"."+candidate.printCandidate());
            }
            System.out.println("=======================================================");
            try {
                System.out.print("Masukkan No Ktp Kandidat : ");
                kandidat = scan.nextLine().trim();
                for (Candidate candidate: daftarCandidate.values()){
                   if (candidate.getNomorKtp().equalsIgnoreCase(kandidat)){
                       selectedCandidate = daftarCandidate.get(kandidat);
                       adaKandidat = true;
                       jadwal = true;
                   }
                }

            }catch (Exception e){
                System.out.println("Masukkan No Ktp Kandidat dengan Benar");
            }
        }while (!jadwal);

        LocalDate tanggal = null;
        if (adaKandidat){
            jadwal = false;
            do {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    System.out.print("Masukkan Tanggal Interview (contoh: 31-12-2023): ");
                    String inputTanggal = scan.nextLine().trim();
                    tanggal = LocalDate.parse(inputTanggal, formatter);
                    jadwal = true;
                }catch (Exception e){
                    System.out.println("Masukkan Tanggal Dengan Benar");
                }
            }while (!jadwal);

            LocalTime jam = null;
            jadwal = false;
            do {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    System.out.print("Masukkan Jam Interview (contoh: 09:00 atau 14:30): ");
                    String inputJam = scan.nextLine().trim();
                    jam = LocalTime.parse(inputJam, formatter);
                    jadwal = true;
                }catch (Exception e){
                    System.out.println("Masukkan Jam Dengan Benar");
                }
            }while (!jadwal);

            jadwal = false;
            String pic = null;
            boolean karyawan = false;
            Employee selectedPic = null;
            do {
                System.out.println("=======================================================");
                int no = 1;
                for (Employee employee: daftarEmployee.values()){
                    System.out.print(no++ +"."+employee.printKaryawan());
                }
                System.out.println("=======================================================");
                try {
                    System.out.print("Masukkan No Karyawan PIC : ");
                    pic = scan.nextLine().trim();
                    for (Employee employee: daftarEmployee.values()){
                        if (employee.getNoKaryawan().equalsIgnoreCase(pic)){
                            selectedPic = daftarEmployee.get(pic);
                            karyawan = true;
                            jadwal = true;
                        }
                    }
                }catch (Exception e){
                    System.out.println("Masukkan No Ktp Kandidat dengan Benar");
                }
            }while (!jadwal);

            if (karyawan){
                daftarInterview.add(new JadwalInterview( selectedCandidate,
                        tanggal, jam, selectedPic));
            }
        }
    }

    public static void jadwalTest(){
        boolean jadwal = false;
        String kandidat = null;
        boolean adaKandidat = false;
        Candidate selectedCandidate = null;
        do {
            System.out.println("=======================================================");
            int no = 1;
            for (Candidate candidate: daftarCandidate.values()){
                System.out.print(no++ +"."+candidate.printCandidate());
            }
            System.out.println("=======================================================");
            try {
                System.out.print("Masukkan No Ktp Kandidat : ");
                kandidat = scan.nextLine().trim();
                for (Candidate candidate: daftarCandidate.values()){
                    if (candidate.getNomorKtp().equalsIgnoreCase(kandidat)){
                        selectedCandidate = daftarCandidate.get(kandidat);
                        adaKandidat = true;
                        jadwal = true;
                    }
                }

            }catch (Exception e){
                System.out.println("Masukkan No Ktp Kandidat dengan Benar");
            }
        }while (!jadwal);

        LocalDate tanggal = null;
        if (adaKandidat){
            jadwal = false;
            do {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    System.out.print("Masukkan Tanggal Interview (contoh: 31-12-2023): ");
                    String inputTanggal = scan.nextLine().trim();
                    tanggal = LocalDate.parse(inputTanggal, formatter);
                    jadwal = true;
                }catch (Exception e){
                    System.out.println("Masukkan Tanggal Dengan Benar");
                }
            }while (!jadwal);

            LocalTime jam = null;
            jadwal = false;
            do {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    System.out.print("Masukkan Jam Interview (contoh: 09:00 atau 14:30): ");
                    String inputJam = scan.nextLine().trim();
                    jam = LocalTime.parse(inputJam, formatter);
                    jadwal = true;
                }catch (Exception e){
                    System.out.println("Masukkan Tanggal Dengan Benar");
                }
            }while (!jadwal);

            int menit = 0;
            jadwal = false;
            do {
                try {
                    System.out.print("Masukkan Durasi Test Dalam Menit: ");
                    menit = Integer.parseInt(scan.nextLine().trim());
                    jadwal = true;
                }catch (Exception e){
                    System.out.println("Masukkan Durasi Test Dalam Menit Dengan Benar");
                }
            }while (!jadwal);

            jadwal = false;
            String pic = null;
            boolean karyawan = false;
            Employee selectedPic = null;
            do {
                System.out.println("=======================================================");
                int no = 1;
                for (Employee employee: daftarEmployee.values()){
                    System.out.print(no++ +"."+employee.printKaryawan());
                }
                System.out.println("=======================================================");
                try {
                    System.out.print("Masukkan No Karyawan PIC : ");
                    pic = scan.nextLine().trim();
                    for (Employee employee: daftarEmployee.values()){
                        if (employee.getNoKaryawan().equalsIgnoreCase(pic)){
                            selectedPic = daftarEmployee.get(pic);
                            karyawan = true;
                            jadwal = true;
                        }
                    }
                }catch (Exception e){
                    System.out.println("Masukkan No Ktp Kandidat dengan Benar");
                }
            }while (!jadwal);

            int soal = 0;
            jadwal = false;
            do {
                try {
                    int jumlahSoal = tipeSoal.size();
                    System.out.print("Masukkan Tipe Soal 1 - "+ jumlahSoal +" : ");
                    soal = Integer.parseInt(scan.nextLine().trim());
                    if (soal > 0 && soal <= jumlahSoal){
                        jadwal = true;
                    }
                }catch (Exception e){
                    System.out.println("Masukkan Tipe Soal dengan benar Dengan Benar");
                }
            }while (!jadwal);

            if (karyawan){
                daftarTest.add(new WaktuTest(selectedCandidate, tanggal, jam, selectedPic, menit, soal));
            }
        }
    }

    public static void printInfoInterviewdanTest(){
        System.out.print(String.format("""
                1. Daftar Jadwal Interview
                2. Daftar Jadwal Test
                3. Menu Utama
                Masukkan Pilihan >>"""));
        int print = Integer.parseInt(scan.nextLine().trim());
        switch (print){
            case 1:
                printInterview();
                menuUtama();
            case 2:
                printTest();
                menuUtama();
            default:
                menuUtama();
        }
    }
    public static void printInterview(){
        System.out.print(String.format("""
                ======================================Jadwal Interview======================================
                %-21s %-16s %-10s %s 
                """, "Nama Kandidat", "Tanggal Test", "Jam Test", "Nama PIC"));
        for (JadwalInterview interview:daftarInterview){
            interview.printInfo();
        }
    }
    public static void printTest(){
        System.out.print(String.format("""
                =========================================Jadwal Test========================================
                %-23s %-16s %-10s %-20s %-6s  %s
                """, "Nama Kandidat", "Tanggal Test", "Jam Test","Nama PIC", "Durasi", "Tipe Soal"));
        for (WaktuTest test:daftarTest){
            test.printInfo();
        }
    }

    public static void tambahKaryawan(){
        System.out.println("====================Daftar Kandidat====================");
        int no = 1;
        for (Candidate candidate: daftarCandidate.values()){
            System.out.print(no++ +". "+candidate.printCandidate());
        }
        System.out.println("=======================================================");
        System.out.print(String.format("""
                        1. Pilih Kandidat Yang Ketrima
                        2. Menu Utama
                        Pilih Inputan >>>"""));
        int menu = Integer.parseInt(scan.nextLine().trim());
        switch (menu){
            case 1:
                pilihKandidat();
            case 2:
                menuUtama();
            default:
                daftarKandidat();
        }
    }
    public static void pilihKandidat(){
        boolean isBreak = false;
        boolean adaKandidat = false;
        String ktp = null;
        do {
            try {
                System.out.print("Masukkan No Ktp Kandidat Yang Ketrima : ");
                ktp = scan.nextLine().trim();
                for (Candidate calon:daftarCandidate.values()){
                    if (calon.getNomorKtp().equalsIgnoreCase(ktp)){
                        adaKandidat = true;
                        isBreak = true;
                    }
                }
                System.out.println("=======================================================");
            }catch (Exception e){
                System.out.println("Masukkan No Ktp Dengan Benar");
            }
        }while (!isBreak);

        if (adaKandidat){
            String namaDepan = null,
                    namaBelakang = null,
                    tempatLahir  = null,
                    nomorKtp = null,
                    posisi  = null;
            EJenisKelamin jenisKelamin = null;
            LocalDate tanggalLahir = null;
            LocalDate tglMulaiKerja = null;
            if (adaKandidat){
                for (Candidate candidate:daftarCandidate.values()){
                    if (candidate.getNomorKtp().equalsIgnoreCase(ktp)){
                        namaDepan = candidate.getNamaDepan();
                        namaBelakang = candidate.getNamaBelakang();
                        tempatLahir = candidate.getTempatLahir();
                        nomorKtp = candidate.getNomorKtp();
                        posisi = candidate.getPekerjaanYangdiLamar();
                        jenisKelamin = candidate.getJenisKelamin();
                        tanggalLahir = candidate.getTanggalLahir();
                        tglMulaiKerja = LocalDate.now();
                    }
                }
            }

            isBreak = false;
            String noKaryawan = null;
            do {
                try {
                    System.out.print("Masukkan No Karyawan Untuk Kandidat Yang Ketrima : ");
                    noKaryawan = scan.nextLine().trim();
                    for (Employee employee:daftarEmployee.values()){
                        if (!employee.getNoKaryawan().equalsIgnoreCase(noKaryawan)){
                            isBreak = true;
                        }
                    }
                    System.out.println("=======================================================");
                }catch (Exception e){
                    System.out.println("Masukkan No Karyawan Baru Dengan Benar");
                }
            }while (!isBreak);

            isBreak = false;
            BigDecimal gaji= null;
            BigDecimal tempGaji = null;
            do {
                try {
                    System.out.print("Masukkan Gaji Untuk Kandidat Yang Ketrima Sesuai Kesepakatan : ");
                    String gajiBaru = scan.nextLine().trim();
                    tempGaji = new BigDecimal(gajiBaru);
                    if (tempGaji.compareTo(BigDecimal.ZERO) != 0) {
                        isBreak = true;
                    }else {
                        System.out.println("Gaji Tidak Boleh 0");
                    }
                }catch (Exception e){
                    System.out.println("Masukkan Gaji Dengan Benar");
                }
            }while (!isBreak);

            isBreak = false;
            Department department = null;
            System.out.println(String.format("""
                    %-25s %-15s %-8s %-8s""", "Nama Department", "Kepala Department","Ruangan","Lantai"));
            for (Department depart:daftarDepartment){
                depart.printInfo();
            }
            do {
                try {
                    System.out.print("Masukkan Department Untuk Kandidat Yang Ketrima : ");
                    String bagian = scan.nextLine().trim();
                    for (Department depart:daftarDepartment){
                        if (depart.getNamaDepartment().equalsIgnoreCase(bagian)){
                            department = depart;
                            isBreak = true;
                        }
                    }
                }catch (Exception e){
                    System.out.println("Masukkan Nama Department Dengan Benar");
                }
            }while (!isBreak);

            if (!noKaryawan.isEmpty()){
                daftarCandidate.remove(ktp);
                daftarEmployee.put(noKaryawan, new Employee(noKaryawan, namaDepan, namaBelakang, jenisKelamin, tanggalLahir, tempatLahir, nomorKtp,
                        posisi, department, tglMulaiKerja, gaji));
            }
        }
    }
}
