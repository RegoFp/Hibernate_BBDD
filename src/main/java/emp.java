
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Creación de las variables en relacióna a cada columna
//de la tabla de datos, emp
@Entity
@Table(name = "EMP")
public class emp {
    @Id
    @Column(name = "empno")
    private int empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Float mgr;
    @Column(name = "hiredate")
    private String hiredate;
    @Column(name = "sal")
    private float sal;
    @Column(name = "comm")
    private Float comm;
    @Column(name = "deptno")
    private Integer deptno;

    //Creación de los constructores
    //Constructor vacío
    public emp() {
    }

    public emp (int empno, String ename, String job, Float mgr, 
                String hiredate, Float sal, Float comm, Integer deptno){
        this.empno=empno;
        this.ename=ename;
        this.job=job;
        this.mgr=mgr;
        this.hiredate=hiredate;
        this.sal=sal;
        this.comm=comm;
        this.deptno=deptno;
    }
    
    //Setters y Getters
    //set y get empno
    public int getEmpno(){
        return empno;
    }
    public void setEmpno(int _empno){
        empno=_empno;
    }
    //et y get ename
    public String getEname(){
        return ename;
    }
    public void setEname(String _ename){
        this.ename=_ename;
    }
    //set y get job
    public String getJob(){
        return job;
    }
    public void setJob(String _job){
        job=_job;
    }
    //set y get mrg
    public Float getMgr(){
        return mgr;
    }
    public void setMgr(Float _mgr){
        mgr=_mgr;
    }
    //set y get hiredate
    public String getHiredate(){
        return hiredate;
    }
    public void setHiredate(String _hiredate){
        hiredate=_hiredate;
    }
    //set y get sal
    public Float getSal(){
        return sal;
    }
    public void setSal(float _sal){
        sal=_sal;
    }
    //set y get comm
    public Float getComm(){
        return comm;
    }
    public void setComm(float _comm){
        comm=_comm;
    }
    //set y get depno
    public Integer getDeptno(){
        return deptno;
    }
    public void setDeptno(Integer _deptno){
        deptno=_deptno;
    }
}




