import java.awt.color.ICC_ColorSpace;

import javax.persistence.*;

@Entity
@Table(name="DEPT")
public class dept {
    @Id //Clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="deptno")
    private int deptno;
    @Column(name="dname")
    private String dname;
    @Column(name="loc")
    private String loc;


    public dept() {
    }

    //Constructor
    public dept(String _dname, String _loc){
        dname= _dname;
        loc= _loc;
    }

    public int getDeptno(){
        return deptno;
    }
    public String getDname(){
        return dname;
    }
    public String getLoc(){
        return loc;
    }
    public void setDeptno(int _deptno){
        this.deptno=_deptno;
    }
    public void setDname(String _dname){
        this.dname=_dname;
    }
    public void setLoc(String _loc){
        this.loc=_loc;
    }
    
}


