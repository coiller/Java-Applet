<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Applet</title>
</head>
<body>
<APPLET CODE="ShowShape.class" HEIGHT="${x}" WIDTH="${y}" ALIGN="middle">
                    <PARAM NAME="MESSAGE" VALUE="${MESSAGE}">
                    <PARAM NAME="SHAPE" VALUE="${SHAPE}">
                    <PARAM NAME="COLOR" VALUE="${COLOR}">
                    <PARAM NAME="X" VALUE="${X}">
                    <PARAM NAME="Y" VALUE="${Y}">
                    <PARAM NAME="BGCOLOR" VALUE="${BGCOLOR}">
                    <PARAM NAME="FTSTYLE" VALUE="${FTSTYLE}">
                    <PARAM NAME="FTSIZE" VALUE="${FTSIZE}">
</APPLET>
</body>
</html>