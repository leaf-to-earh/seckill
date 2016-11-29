package org.dao;

import javax.annotation.Resource;

import org.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		int success = successKilledDao.insertSuccessKilled(1001L, 18338069211L);
		System.out.println(success);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		SuccessKilled sk =successKilledDao.queryByIdWithSeckill(1000L, 1111111111);
		System.out.println(sk);
		System.out.println(sk.getSeckill());
	}

}
