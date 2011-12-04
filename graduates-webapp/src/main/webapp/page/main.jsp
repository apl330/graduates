<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="script/jq.js"  type="text/javascript"></script>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<title>log feel</title>
</head>
<body>
<%@ include file="head.jsp" %> 
<div id="wrapper">
    <div id="main_container">
    
        <%@ include file="menu_container.jsp" %> 
       				
        <div id="content_container">
        		 <div class="content" style="right">
        		 			<s:form id="logFrom" theme="simple">
        		 			<div> <textarea cols="52" rows="5" id="feel" name="feel.text"></textarea></div>
        		 			<div style="text-align: right;"><s:submit value="好了" cssStyle="width:60px;height:50px;" /></div>
        		 			<div class="msg" style="display:none; text-align:right;padding-right:10px;"></div>
        		 			</s:form>
        		 </div>
        		 	<div id="template"></div>
        		 	<s:iterator value="feels" id="feel">
        		 			<div class="content">
        		 				${feel.text} : ${feel.date} &nbsp;&nbsp;&nbsp;&nbsp; <a onclick="del(${feel.id},this)">删除</a>
        		 			</div>
        		 	</s:iterator>
            
        </div>
        
    <div id="clear"></div>
    
    
    </div>
</div>

<script type="text/javascript">
$(function(){
	$("#logFrom").submit(function(){
		var text = $.trim($("#feel").val());
		if("" == text){
			 $(".msg").html("求你了,给我点feel").show().fadeOut(6000,function(){
				 $(".msg").hide();
				});
			 return false;
			}
		 $.post("save-feel.action",$("#logFrom").serialize(),function(result){
			 if(result.success){
				  $("#template").after($("<div class='content'></div>").html(result.feel.text + " : " 
						  																																	 + result.feel.date 
						  																																	 + " &nbsp;&nbsp;&nbsp;&nbsp;"
						  																																	 + "<a onclick='del("+result.feel.id+",this)'>删除</a>"));
						  																																	 
				  $("#feel").attr("value","").focus();
			 }else{
				 $(".msg").html("哦哦, 服务器那边有点小毛病").show().fadeOut(6000,function(){
					 $(".msg").hide();
					});
			 }
		 });
		return false;
	});
});

function del(id,self){
	$.post("remove-feel.action",{id:id},function(result){
		if(result.success){
			$(self).parent().remove();
		}else{
			$(".msg").html("哦哦, 删除失败").show().fadeOut(6000,function(){
				 $(".msg").hide();
			});
		}
		
	});
}
</script>

</body>
</html>