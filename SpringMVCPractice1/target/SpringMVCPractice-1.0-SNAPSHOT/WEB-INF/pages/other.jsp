
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment10</title>
    </head>
    <body>
         <%
            String name ="";
            String course ="";
            String fee ="";
            String year ="";
            String curDate="";
        
          name = request.getAttribute("NameRet").toString();
          course = request.getAttribute("CourseRet").toString();
          fee = request.getAttribute("FreRet").toString();
          year = request.getAttribute("YearRet").toString();
          curDate = request.getAttribute("CurDateRet").toString();       
          out.println(name); 
          out.println(course); 
          out.println(fee); 
          out.println(year); 
          out.println(curDate); 
            %>
    </body>
</html>
