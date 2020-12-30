package enity;

public class Province {
    private Integer id;
    private String pname;
    private String sname;
    private String capital;

    public Province() {
    }

    public Province(Integer id, String pname, String sname, String capital) {
        this.id = id;
        this.pname = pname;
        this.capital = capital;
        this.sname = sname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

}


