<%
    String in=request.getParameter("mynum");
    if(in!=null)
    {
        int n=Integer.paraseInt(in);
        for(int i=1;i<11;i++){
            out.print(n+"*"+i+"="+(n*i)+"<br/>");//Out is implicit object
        }
    }
    else
        out.print("no value found");
//    out.print("your input("+in+") length is: "+in.length());
//    else
//    out.print("no value found");
%>