package com.little.cloud.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Seckill implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long seckillId;
	private String name;
	private Long number;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	private Integer version;

}
