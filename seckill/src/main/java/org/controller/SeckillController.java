package org.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.dto.SeckillResult;
import org.entity.Seckill;
import org.enumers.SeckillStatusEnum;
import org.exception.RepeatKillException;
import org.exception.SeckillClosedException;
import org.exception.SeckillException;
import org.service.SeckillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeckillController {

	@Resource
	private SeckillService seckillService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(Model model, @PathVariable Long seckillId) {
		if (seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if (seckill == null) {
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}
	
	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable Long seckillId) {
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			System.out.println(exposer);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			result = new SeckillResult<Exposer>(false, e.getMessage());
		} 
		return result;
	}

	@RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable Long seckillId, @PathVariable String md5,
			@CookieValue(value = "killPhone", required = false) Long phone) {

		System.out.println("execute kill begin");
		if (phone == null) {
			return new SeckillResult<SeckillExecution>(false, "Î´×¢²á");
		}

		SeckillResult<SeckillExecution> result;
		try {
			SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
			result = new SeckillResult<SeckillExecution>(true, execution);
		} catch (RepeatKillException e1) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatusEnum.REPEAT_KILL);
			result = new SeckillResult<SeckillExecution>(true, execution);
		} catch (SeckillClosedException e2) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatusEnum.END);
			result = new SeckillResult<SeckillExecution>(true, execution);
		} catch (SeckillException e3) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatusEnum.INNER_ERROR);
			result = new SeckillResult<SeckillExecution>(true, execution);
		}
		return result;
	}
	
	@RequestMapping(value = "/time/now", method = RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		Date now = new Date(System.currentTimeMillis());
		return new SeckillResult<Long>(true, now.getTime());
	}

}
