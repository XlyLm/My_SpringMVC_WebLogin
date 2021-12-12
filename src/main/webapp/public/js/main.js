let baseUrl = "http://localhost:8080/java22e";

//修改用户昵称
function updateUserName(){
    if(window.confirm("确认修改用户名？")){
        let name = window.prompt("请输入新昵称:");
        $.ajax({
            type:"post",
            url:baseUrl+"/toLogin/updateUserName",
            data:{username:name},
            success:function (res) {
                let req = JSON.parse(res);
                alert(req.data);
                if(req.status===0){
                    window.location.href = baseUrl+"/toLogin";
                }else{
                    window.location.href = baseUrl+"/freeLogin";
                }
            }
        })
    }
}
//注销用户
function logoutUser(){
    if(window.confirm("是否注销用户?")){
        if(window.confirm("主人，不要删除人家a!")){
            if(window.confirm("主人，再见了!555")){
                $.ajax({
                    type:"post",
                    url:baseUrl+"/toLogin/logoutUser",
                    success:function (res) {
                        let req = JSON.parse(res);
                        alert("用户注销成功!");
                        window.location.href = baseUrl + req.data;
                    }
                })
            }
        }
    }
}