package Company;

public class Department {
    protected String namaDepartment;
    protected String kepalaDepartment;
    protected int noRuangKerja;
    protected int lantaiRuangKerja;

    public Department(){}
    public Department(String namaDepartment, String kepalaDepartment, int noRuangKerja, int lantaiRuangKerja){
        this.namaDepartment = namaDepartment;
        this.kepalaDepartment = kepalaDepartment;
        this.noRuangKerja = noRuangKerja;
        this.lantaiRuangKerja = lantaiRuangKerja;
    }

    public void printInfo(){
        System.out.print(String.format("""
                %-25s %-19s %-8s %-8s
                """, this.namaDepartment, this.kepalaDepartment, this.noRuangKerja, this.lantaiRuangKerja));
    }

    public void setNamaDepartment(String namaDepartment) {
        this.namaDepartment = namaDepartment;
    }
    public String getNamaDepartment() {
        return namaDepartment;
    }

    public void setKepalaDepartment(String kepalaDepartment) {
        this.kepalaDepartment = kepalaDepartment;
    }
    public String getKepalaDepartment() {
        return kepalaDepartment;
    }

    public void setNoRuangKerja(int noRuangKerja) {
        this.noRuangKerja = noRuangKerja;
    }
    public int getNoRuangKerja() {
        return noRuangKerja;
    }

    public void setLantaiRuangKerja(int lantaiRuangKerja) {
        this.lantaiRuangKerja = lantaiRuangKerja;
    }
    public int getLantaiRuangKerja() {
        return lantaiRuangKerja;
    }
}
