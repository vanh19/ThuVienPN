package anhmvph25860.fpoly.mob204_md18302_ph25860.model;

public class ThanhVien {
    private int matv;
    private String hoten;
    private String namsinh;

    public ThanhVien(int matv, String hoten, String namsinh) {
        this.matv = matv;
        this.hoten = hoten;
        this.namsinh = namsinh;
    }

    public int getMatv() {
        return matv;
    }

    public void setMatv(int matv) {
        this.matv = matv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }
}
