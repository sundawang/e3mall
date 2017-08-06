package cn.e3mall.service;

import cn.e3mall.common.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	 TbItem selectByPrimaryKey(Long id);
	 DataGridResult getItemlist(Integer page,Integer rows);
}
