package com.little.cloud.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class SuccessKilled implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seckillId;
	private Long userId;
	private Integer state;
	private Date createTime;

}
