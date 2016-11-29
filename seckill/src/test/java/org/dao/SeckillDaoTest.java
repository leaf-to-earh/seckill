package org.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

//	ע��daoʵ��������
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryById(){
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	
	@Test
	public void testQueryAll(){
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for(Seckill sk : seckills){
			System.out.println(sk);
		}
	}
	
	@Test
	public void testReduceQuantity() {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceQuantity(1000L, killTime);
		System.out.println(updateCount);
	}
	
	
}
