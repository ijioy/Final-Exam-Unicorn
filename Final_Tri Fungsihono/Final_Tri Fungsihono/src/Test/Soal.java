package Test;

public class Soal {
    protected String soalSatu;

    public Soal(){}
    public Soal(String soalSatu){
        this.soalSatu = soalSatu;
    }
    public void printSoal(){
        System.out.println(String.format("""
                %s
                """, this.soalSatu));
    }

    public void setSoalSatu(String soalSatu) {
        this.soalSatu = soalSatu;
    }
    public String getSoalSatu() {
        return soalSatu;
    }
}
