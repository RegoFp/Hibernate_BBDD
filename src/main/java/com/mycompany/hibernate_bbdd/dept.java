package com.mycompany.hibernate_bbdd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.color.ICC_ColorSpace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Developer
 */

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
    
    
    
}


