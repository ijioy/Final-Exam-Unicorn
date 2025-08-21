package Enum;

public enum EJenisKelamin {
    L("Laki-laki"),
    P("Perempuan");

    private String labelJK;
    EJenisKelamin(String labelJK){
        this.labelJK = labelJK;
    }

    @Override
    public String toString() {
        return this.labelJK;
    }
}
