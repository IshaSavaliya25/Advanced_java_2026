<%
    String email=request.getParameter("txtemail");
    String pwd = request.getParameter("txtpwd");
    if(email!=null && email.length() > 0 && email.equals(pwd)){
        out.print("Welcome  " +email);
        Cookie user=new Cookie("user",email);
        user.setMaxAge(60*60*2);
        response.addCookie(user);
    }else{
        out.print("Invalid credentials");
    }

%>