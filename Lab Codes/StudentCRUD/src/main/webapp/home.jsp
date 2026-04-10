<%
    Cookie[] cookies= request.getCookies();
//    out.print(cookies.length);
    for(Cookie c : cookies){
//        out.print("<br/>"+c.getName()+" "+c.getValue());
        if(c.getName().equals("user")){
            out.print("Welcome " + c.getValue());
        }
        else{
            out.print("No user found!!!");
        }
    }
%>