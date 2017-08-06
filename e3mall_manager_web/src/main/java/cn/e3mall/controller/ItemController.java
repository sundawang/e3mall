package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 * 物品的表现层
 * @author SdwTo
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{id}")
	@ResponseBody
	public TbItem selectById(@PathVariable Long id){
		TbItem tbItem = itemService.selectByPrimaryKey(id);
		System.out.println(tbItem);
		return tbItem;
	}
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 通用页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/**@throws Exception
	 * @param page=1  rows=30
	 * @return 
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemlist(Integer page,Integer rows) throws Exception{
		DataGridResult result = itemService.getItemlist(page, rows);
		return result;
	}
}
