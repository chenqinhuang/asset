/**
 * @author 黄平平
 * @date 
 */
$("#login-button").bind('click', function () {

        if(""==$("#userName").val()){
            alert("用户名不能为空！~");
        }else if(""==$("#pwd").val()){
            alert("密码不能为空！~");
        }else{
        
        
        $.ajax({
            type: "POST",
            url: "userLogin",
            data: {
            
                userName:$("#userName").val(),
                pwd:$("#pwd").val()
            	
            },
            success: function (data) {
                              
                if("loginsuccess"==data){
                
                $('.login-box').fadeOut(500);
	            $('.wrapper').addClass('form-success');	
	            
	            setTimeout('javascript:location.href="jsp/index.jsp"',1300); 
	            
                }else{
                   alert("账号或密码错误，请重新输入！");
                }
                
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });
        
        }
           
    });
