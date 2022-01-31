package com.mycompany.hibernate_bbdd;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class emp {
    @Column(name = "empno")
    private int empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private int mgr;
    @Column(name = "hiredate")
    private Date hiredate;
    @Column(name = "sal")
    private float sal;
    @Column(name = "comm")
    private float comm;
    @Id
    @Column(name = "deptno")
    private float deptno;

    public emp (int empno, String ename, String job, int mgr, Date hiredate, float sal, float comm, float deptno){
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
    public int getMgr(){
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
        this.empno=_empno;
    }
    public void setEname(String _ename){
        this.ename=_ename;
    }
    public void setJob(String _job){
        this.job=_job;
    }
    public void setMgr(int _mgr){
        this.mgr=_mgr;
    }
    public void setHiredate(Date _hiredate){
        this.hiredate=_hiredate;
    }
    public void setSal(float _sal){
        this.sal=_sal;
    }
    public void setComm(float _comm){
        this.comm=_comm;
    }
    public void setDeptno(float _deptno){
        this.deptno=_deptno;
    }
}




