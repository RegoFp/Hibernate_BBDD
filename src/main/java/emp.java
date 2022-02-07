import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class emp {
    @Column(name = "empno")
    private int empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private float mgr;
    @Column(name = "hiredate")
    private Date hiredate;
    @Column(name = "sal")
    private float sal;
    @Column(name = "comm")
    private float comm;
    @Id
    @Column(name = "deptno")
    private int deptno;

    public emp() {
    }

    public emp (int empno, String ename, String job, int mgr, Date hiredate, float sal, float comm, int deptno){
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
    public float getMgr(){
        return mgr;
    }
    public Date getHiredate(){
        return hiredate;
    }
    public float getSal(){
        return sal;
    }
    public float getComm(){
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
    public void setMgr(int _mgr){
        mgr=_mgr;
    }
    public void setHiredate(Date _hiredate){
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




