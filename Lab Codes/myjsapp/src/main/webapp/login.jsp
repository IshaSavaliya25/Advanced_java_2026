<%
    response.setContentType("text/html");
%>

<%
    boolean isLogin = false;
    String btnLogin = request.getParameter("btnLogin");
    if(btnLogin!=null){
        String nm = request.getParameter("txtUnm");
        String pwd = request.getParameter("txtPwd");
        //out.println("username: "+nm+" password: "+pwd);
        if(nm.equals(pwd)){
            out.println("Welcome "+nm);
            isLogin = true;
        }else{
            out.println("<strong style='color:red'>Invalid credentials</strong>");
            isLogin = false;
        }
    }
    if(isLogin==false){
%>
<form method="post">
    <input name="txtUnm" placeholder="Enter username"/>
    <input name="txtPwd" type="password" placeholder="Enter password"/>
    <input type="submit" name="btnLogin" value="Login"/>
</form>
<%
    }
%>