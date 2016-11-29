<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<%@include file="common/head.jsp" %>
<title>秒杀详情</title>
 	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
	
	<!-- 引入jQuery cookie插件 -->
	<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
	<!-- 引入jQuery countdown倒计时 -->
	<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.js"></script>
	
	<!-- 引入自己的js文件 -->
	<script type="text/javascript" src="/seckill/resource/script/seckill.js"></script>
	<script type="text/javascript">
		$(function(){
			seckill.detail.init({
				seckillId : "${seckill.seckillId}",
				startTime : "${seckill.startTime.time}",
				endTime : "${seckill.endTime.time}"
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="panel-heading">
				<h1>${seckill.name}</h1>
			</div>
			<div class="panel-body">
				<h2 class="text-danger">
					<!-- 显示time图标 -->
					<span class="glyphicon glyphicon-time"></span>
					<!-- 显示倒计时 -->
					<span class="glyphicon" id="seckill-box"></span>
				</h2>
			</div>
		</div>
	</div>
	<!-- 登录弹出层，输入电话 -->
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"></span>秒杀电话：
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="killPhone" id="killPhoneKey"
							placeholder="输入手机号" class="form-control">
						</div> 
					</div>
				</div>
				<div class="modal-footer">
					<!-- 验证信息 -->
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span>
						Submit
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>