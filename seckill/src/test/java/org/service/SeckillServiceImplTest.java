package org.service;


import java.util.List;

import javax.annotation.Resource;

import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.entity.Seckill;
import org.exception.RepeatKillException;
import org.exception.SeckillClosedException;
import org.exception.SeckillException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"
	})

public class SeckillServiceImplTest {
	
	@Resource
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		for(Seckill seckill : list){
			System.out.println(seckill);
		}
	}

	@Test
	public void testGetById() {
		Seckill seckill = seckillService.getById(1001l);
		System.out.println(seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		Exposer exposer = seckillService.exportSeckillUrl(1001l);
		System.out.println(exposer);
	}

	@Test
	public void testExecuteSeckill() {
		try{
			SeckillExecution seckillExecution = seckillService.executeSeckill(1001l, 18538039201L, "c869ea96abe7117caa47438b9246b943");
			System.out.println(seckillExecution);
		}catch(RepeatKillException e1){
			e1.printStackTrace();
		}catch(SeckillClosedException e2){
			e2.printStackTrace();
		}catch(SeckillException e3){
			e3.printStackTrace();
		}
	}

//	◊€∫œ≤‚ ‘√Î…±¡˜≥Ã
	@Test
	public void testSeckillLogic(){
		Exposer exposer = seckillService.exportSeckillUrl(1001l);
		if(exposer.isExposed()){
			SeckillExecution seckillExecution = seckillService.executeSeckill(exposer.getSeckillId(), 
					18533333231L, exposer.getMd5());
			System.out.println(seckillExecution);
		}else{
			System.out.println("exposer =" + exposer);
		}
	}
}
