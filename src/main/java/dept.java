

import javax.persistence.*;

//Creación de cada variable en relación a cada tabla
//de la base de datos, dept
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

    //Creación de constructores
    //Constructor vacío
    public dept() {
    }
    
    public dept(String _dname, String _loc){
        dname= _dname;
        loc= _loc;
    }
    //Creación de setters y getters
    //get y set deptno
    public int getDeptno(){
        return deptno;
    }
    public void setDeptno(int _deptno){
        this.deptno=_deptno;
    }
    //get y set dname
    public String getDname(){
        return dname;
    }
        public void setDname(String _dname){
        this.dname=_dname;
    }
    //get y set loc
    public String getLoc(){
        return loc;
    }
    public void setLoc(String _loc){
        this.loc=_loc;
    }
    
}


