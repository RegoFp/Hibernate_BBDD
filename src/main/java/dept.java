import java.awt.color.ICC_ColorSpace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class dept {
    @Id //Clave primaria
    @Column(name="deptno")
    private int deptno;
    @Column(name="dname")
    private String dname;
    @Column(name="loc")
    private String loc;
    
    
    //Constructor
    public dept(int _deptno, String _dname, String _loc){
        this.deptno = _deptno;
        this.dname=_dname;
        this.loc=_loc;
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


