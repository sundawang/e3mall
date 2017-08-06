package cn.e3mall.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {
	
	@Test
	public void demo1(){
		//初始化spring容器
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获取mapper代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//设置分页信息
		PageHelper.startPage(1, 10);
		//查询list
		TbItemExample example = new TbItemExample();
		List<TbItem> list = mapper.selectByExample(example);
		
		//将list放入分页信息中
		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
		
		//打印
		System.out.println(info.getTotal());
		System.out.println(info.getEndRow());
		System.out.println(info.getList());
		
	}
}
