  <%@ page import="java.util.HashMap"
  import="java.net.URLEncoder" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Expedia Offers</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Expedia Offers</h2>
          
          
          
  <table class="table">
    <thead>
      <tr>
        <th class="text-left">
        Destination
        	<form action=""><input type="text" class="form-control input-sm" name="destinationName" placeholder="Destination"></form>
	      </th>
        <th>Hotel Name</th>
        <th>Hotel Website</th>
        <th>Travel Date</th>
        <th>Travel Days</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotels}">
      <tr>
      <c:out value=""></c:out>
        <td>${hotel.destination.longName}</td>
        <td>${hotel.hotelInfo.hotelName}</td>
        <c:set var="url" value="${hotel.hotelUrls.hotelInfositeUrl}"></c:set>
        <c:set var="date" value="${hotel.offerDateRange.travelStartDate}"></c:set>
        <%
        	String url = java.net.URLDecoder.decode(pageContext.getAttribute("url").toString(), "UTF-8");
        	pageContext.setAttribute("url", url);
            String date = pageContext.getAttribute("date").toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll(", ","/");
            pageContext.setAttribute("date", date);

        %>
        <td><a href="${url}">Vist Website</a></td>
        <td>${date}</td>
        <td>${hotel.offerDateRange.lengthOfStay}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
