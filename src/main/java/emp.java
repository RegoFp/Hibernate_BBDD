import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int deptno;

    public emp() {
    }

    public emp (int empno, String ename, String job, Float mgr, String hiredate, Float sal, Float comm, int deptno){
        this.empno=empno;
        this.ename=ename;
        this.job=job;
        this.mgr=mgr;
        this.hiredate=hiredate;
        this.sal=sal;
        this.comm=comm;
        this.deptno=deptno;
    }

    public int getEmpno(){
        return empno;
    }
    public String getEname(){
        return ename;
    }
    public String getJob(){
        return job;
    }
    public Float getMgr(){
        return mgr;
    }
    public String getHiredate(){
        return hiredate;
    }
    public Float getSal(){
        return sal;
    }
    public Float getComm(){
        return comm;
    }
    public float getDeptno(){
        return deptno;
    }
    
    public void setEmpno(int _empno){
        empno=_empno;
    }
    public void setEname(String _ename){
        this.ename=_ename;
    }
    public void setJob(String _job){
        job=_job;
    }
    public void setMgr(Float _mgr){
        mgr=_mgr;
    }
    public void setHiredate(String _hiredate){
        hiredate=_hiredate;
    }
    public void setSal(float _sal){
        sal=_sal;
    }
    public void setComm(float _comm){
        comm=_comm;
    }
    public void setDeptno(int _deptno){
        deptno=_deptno;
    }
}




