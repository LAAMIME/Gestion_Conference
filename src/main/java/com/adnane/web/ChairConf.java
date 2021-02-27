package com.adnane.web;

public class ChairConf {

	private Long iduser;
	private Long idconf;
	
	public ChairConf(Long iduser, Long idconf) {
		super();
		this.iduser = iduser;
		this.idconf = idconf;
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public Long getIdconf() {
		return idconf;
	}

	public void setIdconf(Long idconf) {
		this.idconf = idconf;
	}
}
