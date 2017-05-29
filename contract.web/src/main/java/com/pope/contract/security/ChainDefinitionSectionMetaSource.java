package com.pope.contract.security;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.pope.contract.entity.system.Permission;
import com.pope.contract.service.system.PermissionService;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	@Autowired
	private PermissionService permissionService;
	
	private String filterChainDefinitions; 
	
	 /** 
     * 默认premission字符串 
     */  
    public static final String PREMISSION_STRING="perms[\"{0}\"]";
	
	@Override
	public Section getObject() throws Exception { 

		List<Permission> pers=permissionService.selectAll();
		Ini ini = new Ini();  
        //加载默认的url  
        ini.load(filterChainDefinitions);  
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        for (Iterator<Permission> it = pers.iterator(); it.hasNext();) {  
        	  
        	Permission per = it.next();  
            //如果不为空值添加到section中  
            if(!StringUtils.isEmpty(per.getCode()) && !StringUtils.isEmpty(per.getUrl())) { 
            	String url=per.getUrl();
            	if(url.indexOf(",")>=0){
            		String[] url2=url.split(",");
            		for(String s:url2){
            			section.put(s,  MessageFormat.format(PREMISSION_STRING,per.getCode()));
            		}
            	}else{
            		section.put(per.getUrl(),  MessageFormat.format(PREMISSION_STRING,per.getCode()));
            	}
            }
        }  
       section.put("/**", "authc");
		return section;
	}

	@Override
	public Class<?> getObjectType() {
		return this.getClass();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
	 public void setFilterChainDefinitions(String filterChainDefinitions) {  
	        this.filterChainDefinitions = filterChainDefinitions;  
	 } 

}
