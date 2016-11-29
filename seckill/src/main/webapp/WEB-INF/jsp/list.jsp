<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
   <head>
      <title>秒杀列表</title>
      <%@include file="common/head.jsp" %>
      <%@include file="common/tag.jsp" %>
      <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
   </head>
   <body>
     <!-- 页面显示 -->
     <div class="container">
     	<div class="panel panel-default">
     		<div class="panel-heading text-center">
     			<h2>秒杀列表</h2>
     		</div>
     		<div class="panel-body">
     			<table class="table table-hover">
     				<thead>
     					<tr>
     						<th>名称</th>
     						<th>库存</th>
     						<th>开始时间</th>
     						<th>结束时间</th>
     						<th>创建时间</th>
     						<th>详情页</th>
     					</tr>
     				</thead>
     				<tbody>
     					<c:forEach items="${list}" var="sk">
     						<tr>
     							<td>${sk.name}</td>
     							<td>${sk.quantity}</td>
     							<td><fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
     							<td><fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
     							<td><fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
     							<td><a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="-blank">详情</a></td>
     						</tr>
     					</c:forEach>
     				</tbody>
     			</table>
     		</div>
     	</div>
     </div>
      
   </body>
</html>