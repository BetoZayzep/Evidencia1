<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculadora de IMC</title>
</head>
<body>
    <h1>Calculadora de IMC</h1>
    
    <h2>IMC Actual</h2>
    <p>Su IMC actual es: ${imcActual}</p>
    
    <h2>Historial de IMC</h2>
    <table border="1">
        <tr>
            <th>Fecha</th>
            <th>IMC</th>
        </tr>
        <c:forEach var="imcData" items="${historialIMC}">
            <tr>
                <td>${imcData.date}</td>
                <td>${imcData.imc}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
