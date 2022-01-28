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

    }




