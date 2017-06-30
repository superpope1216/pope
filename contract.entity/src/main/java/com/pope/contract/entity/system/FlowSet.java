package com.pope.contract.entity.system;

import java.io.Serializable;

public class FlowSet implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String type;

    private Integer px;

    private String name;
    
    private String shType;
    
    private Role sjzdName;
    

	private Sjzd sjzdType;
    
    private Sjzd sjzdShType;

    public Role getSjzdName() {
		return sjzdName;
	}

	public void setSjzdName(Role sjzdName) {
		this.sjzdName = sjzdName;
	}

    public Sjzd getSjzdType() {
		return sjzdType;
	}

	public void setSjzdType(Sjzd sjzdType) {
		this.sjzdType = sjzdType;
	}

	public Sjzd getSjzdShType() {
		return sjzdShType;
	}

	public void setSjzdShType(Sjzd sjzdShType) {
		this.sjzdShType = sjzdShType;
	}

	public String getShType() {
		return shType;
	}

	public void setShType(String shType) {
		this.shType = shType;
	}

	public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPx() {
        return px;
    }

    public void setPx(Integer px) {
        this.px = px;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}