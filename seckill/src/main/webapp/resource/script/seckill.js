//存放交互逻辑的js代码
//模块化js
var seckill = {
	// 封闭秒杀相关的url
	URL : {
		now : function(){
			return '/seckill/time/now';
		},
		exposer : function(seckillId){
			return '/seckill/' + seckillId + "/exposer";
		},
		execution : function(seckillId, md5){
			return '/seckill/' + seckillId + '/' + md5 + '/execution';
		}
	},
	//验证手机号
	validatePhone : function(phone) {
		if (phone && phone.length == 11 && !isNaN(phone)) {
			return true;
		} else {
			return false;
		}
	},
	handleSeckill : function(seckillId, node) {
		// 处理秒杀逻辑
		node.hide()
			.html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
		$.post(seckill.URL.exposer(seckillId), {}, function(result){
			console.log("After kill:" + result);
			//在回调函数中执行交互流程
			if(result && result['success']){
				var exposer = result['data'];
				if(exposer['exposed']){
					//开始秒杀
					var md5 = exposer['md5'];
					var killUrl = seckill.URL.execution(seckillId, md5);
					console.log("秒杀地址：" + killUrl);
					$('#killBtn').one("click", function(){
						//1.禁用按钮
						$(this).addClass('disabled');
						//2.发送秒杀请求，执行秒杀
						$.post(killUrl, {}, function(result){
							if(result && result['success']){
								var killResult = result['data'];
								var status = killResult['status'];
								var statusInfo = killResult['statusInfo'];
								//3.显示秒杀结果
								node.html('<span class="label label-success">' + statusInfo + '</span>');
							}
						});
					});
					node.show();
				}else{
					var now = exposer['now'];
					var start = exposer['start'];
					var end = exposer['end'];
					seckill.countdown(seckillId, now, start, end);
				}
			}else{
				console.log("result:" + result);
			}
		});
	},
	//计时判断
	countdown : function(seckillId, nowTime, startTime, endTime) {
		var seckillBox = $('#seckill-box');
		if (nowTime > endTime) {
			//秒杀结束
			seckillBox.html("秒杀结束！");
		} else if (nowTime < startTime){
			var killTime = new Date(Number(startTime) + 1000);
			//秒杀未开始，开始倒计时
			seckillBox.countdown(killTime,function(event){
				var format = event.strftime("秒杀倒计时： %D天 %H时 %M分 %S秒");
				seckillBox.html(format);
			}).on("finish.countdown", function(){
				seckill.handleSeckill(seckillId, seckillBox);
			});
		} else {
			//秒杀开始
			seckill.handleSeckill(seckillId, seckillBox);
		}
	},
	// 详情页秒杀逻辑
	detail : {
		// 详情页初始化
		init : function(params) {
			// 在cookie中查找手机号
			var killPhone = $.cookie("killPhone");
			// 验证手机号
			if (!seckill.validatePhone(killPhone)) {
				// 绑定手机号，控制输出
				var killPhoneModal = $('#killPhoneModal');
				killPhoneModal.modal({
					show : true,// 显示弹出层
					backdrop : 'static',// 禁止位置移动
					keyboard : false// 关闭键盘事件
				});
				$('#killPhoneBtn').click(function(){
					var inputPhone = $('#killPhoneKey').val();
					console.log("inputPhone:"+inputPhone);//TODO
					if(seckill.validatePhone(inputPhone)){
						//验证通过，1.写入cookie,2.刷新页面
						$.cookie("killPhone", inputPhone, {
							expires : 7,
							path : '/seckill'
						});
						window.location.reload();
					}else{
						$('#killPhoneMessage')
								.hide()
								.html('<label class="label label-danger">手机号错误!</label>')
								.show(300);
					}
				});
			} 
			var seckillId = params['seckillId'];
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			//cookie中已经有手机号了，计时交互
			$.get(seckill.URL.now(), {}, function(result) {
				if(result && result['success']){
					var nowTime = result['data'];
					console.log("phone = " + killPhone);
					console.log("id =" + seckillId + 
							"\nServer time = "+ nowTime +
							"\nstartTime = "+ startTime +
							"\nendTime = " + endTime);
					seckill.countdown(seckillId, nowTime, startTime, endTime);
				}else{
					console.log('result:' + result);
				}
			});
		}
	},

}
