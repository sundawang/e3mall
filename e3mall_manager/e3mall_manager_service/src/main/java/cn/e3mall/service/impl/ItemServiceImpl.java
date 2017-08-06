package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem selectByPrimaryKey(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}
	/**
	 * @Param page rows
	 * @return DataDridResult
	 */
	@Override
	public DataGridResult getItemlist(Integer page, Integer rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		
		//将list放入分页信息类
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		DataGridResult result = new DataGridResult();
		//将查询的值封装到工具类中
		Long total = pageInfo.getTotal();
		result.setTotal(total.intValue());
		result.setRows(list);
		return result;
	}

}
