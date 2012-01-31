package org.projects.graduates.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * å­¦æ ¡
 * @author zjzhai
 *
 */
@Entity
@Table(name="_schools")
public class School {
	//ÖĞÎÄddddÑÔÂÛ
	private Area area;

	// å­¦æ ¡åç§°
	private String name;

	// å­¦æ ¡ä»£ç 
	private String code;
	
}
