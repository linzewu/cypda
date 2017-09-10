package com.xs.cypda.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author linzewu
 *
 */
@Entity
@Table(name = "veh_inspection_viewer",schema="vis_outsyn")
public class User {
	
	@Column
	@Id
	private String sfzmhm;
	@Column
	private String xm;
	@Column
	private String ywlx;
	@Column
	private String cllx;
	@Column
	private String syxz;
	@Column
	private String glbm;
	@Column
	private String syglbm;
	@Column
	private String fzjg;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gxrq;
	
	@Column
	private Character csbj;
	@Column
	private String bz;
	@Column
	private String shbj;
	@Column
	private String jyw;
	@Column
	private String shyj;
	@Column
	private Character zt;
	@Column
	private Character bjcsbj;
	@Column
	private String jczbh;
	@Column
	private String cyzgzbh;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date cyzgzyxqz;
	@Column
	private String cyzgzffdw;
	@Column
	private String cyydj;
	@Column
	private String sfmj;
	public String getSfzmhm() {
		return sfzmhm;
	}
	public String getXm() {
		return xm;
	}
	public String getYwlx() {
		return ywlx;
	}
	public String getCllx() {
		return cllx;
	}
	public String getSyxz() {
		return syxz;
	}
	public String getGlbm() {
		return glbm;
	}
	public String getSyglbm() {
		return syglbm;
	}
	public String getFzjg() {
		return fzjg;
	}
	public String getBz() {
		return bz;
	}
	public String getShbj() {
		return shbj;
	}
	public String getJyw() {
		return jyw;
	}
	public String getShyj() {
		return shyj;
	}
	public String getJczbh() {
		return jczbh;
	}
	public String getCyzgzbh() {
		return cyzgzbh;
	}
	public String getCyzgzffdw() {
		return cyzgzffdw;
	}
	public String getCyydj() {
		return cyydj;
	}
	public String getSfmj() {
		return sfmj;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public void setSyxz(String syxz) {
		this.syxz = syxz;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public void setSyglbm(String syglbm) {
		this.syglbm = syglbm;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public void setShbj(String shbj) {
		this.shbj = shbj;
	}
	public void setJyw(String jyw) {
		this.jyw = jyw;
	}
	public void setShyj(String shyj) {
		this.shyj = shyj;
	}
	public void setJczbh(String jczbh) {
		this.jczbh = jczbh;
	}
	public void setCyzgzbh(String cyzgzbh) {
		this.cyzgzbh = cyzgzbh;
	}
	public void setCyzgzffdw(String cyzgzffdw) {
		this.cyzgzffdw = cyzgzffdw;
	}
	public void setCyydj(String cyydj) {
		this.cyydj = cyydj;
	}
	public void setSfmj(String sfmj) {
		this.sfmj = sfmj;
	}
	public Date getGxrq() {
		return gxrq;
	}
	public Date getCyzgzyxqz() {
		return cyzgzyxqz;
	}
	public void setGxrq(Date gxrq) {
		this.gxrq = gxrq;
	}
	public void setCyzgzyxqz(Date cyzgzyxqz) {
		this.cyzgzyxqz = cyzgzyxqz;
	}
	public Character getCsbj() {
		return csbj;
	}
	public Character getZt() {
		return zt;
	}
	public Character getBjcsbj() {
		return bjcsbj;
	}
	public void setCsbj(Character csbj) {
		this.csbj = csbj;
	}
	public void setZt(Character zt) {
		this.zt = zt;
	}
	public void setBjcsbj(Character bjcsbj) {
		this.bjcsbj = bjcsbj;
	}


}
