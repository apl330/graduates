<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/style.css" rel="stylesheet" type="text/css" />
<script  src="script/jq.js"  type="text/javascript"></script>
<title>Login</title>
</head>
<body>

<%@ include file="head.jsp" %> 

<div id="wrapper">
    <div id="main_container">
        
        <%@ include file="menu_container.jsp" %> 
        
        <div id="content_container">
            <div class="content" style="text-align: right;">
            										   
               					<s:form id="checkUser" theme="simple" action="checkUser.action">
               										<p>用户名：<s:textfield id="uName" name="user.name"/></p>
               										<p>密&nbsp;码：<s:password id="uPasswd" name="user.passwd" /></p>
               										<p><s:submit value="确定" /></p><div class="msg" style="display:none"></div>
               				 </s:form>
            </div>
        </div>
    <div id="clear"></div>
    </div>
</div>
<script type="text/javascript">
	$(function(){
		$("#checkUser").submit(function(){
			var name = $.trim($("#uName").val());
			var passwd = $.trim($("#uPasswd").val());
			if("" == name || "" ==passwd ){
				$(".msg").html("用户名或密码不能为空!").show().fadeOut(6000,function(){
					$(".msg").hide();
				});
				return false;
			}
			$.post("exist-user.action",$("#checkUser").serialize(),function(result){
				if(result.exist){
					 location.href="main.action";
				}else{
					$(".msg").html("用户名或密码错误！!").show().fadeOut(3000,function(){
						$(".msg").hide();
					});
					$("#uPasswd").attr("value","").select();
				}
			} );
			return false;
		});
	});
</script>
</body>
</html>